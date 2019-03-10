package com.rampatra.blockchain;

import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * @author rampatra
 * @since 2019-03-09
 */
public class Peer {

    private Blockchain blockchain;
    private int port;
    private ServerSocket server;
    private ExecutorService executor = Executors.newSingleThreadExecutor();

    Peer(Blockchain blockchain, int port) {
        this.blockchain = blockchain;
        this.port = port;
        startServer();
        getLatestBlockFromPeers();
    }

    private void startServer() {
        try {
            executor.submit(() -> {
                server = new ServerSocket(port);
                while (true) {
                    new Thread(new MessageHandler(server.accept(), this)).start();
                }
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public void stopServer() {
        try {
            if (!server.isClosed()) {
                server.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void getLatestBlockFromPeers() {
        sendMessageToPeers(Message.MessageBuilder
                .aMessage()
                .withMessageType(Message.MessageType.REQUEST_LATEST_BLOCK)
                .build());
    }

    private void sendMessageToPeers(Message message) {
        try {
            List<Peer> peers = P2P.getPeers()
                    .stream()
                    .filter(peer -> !(peer.port == this.port))
                    .collect(Collectors.toList());
            for (Peer peer : peers) {
                Socket client = new Socket("127.0.0.1", peer.port);
                ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
                out.writeObject(message);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void mine(String data) {
        Block latestBlock = this.blockchain.mine(data);
        sendMessageToPeers(Message.MessageBuilder
                .aMessage().withMessageType(Message.MessageType.RECEIVE_LATEST_BLOCK)
                .withLatestBlock(latestBlock)
                .build());
    }

    public Blockchain getBlockchain() {
        return blockchain;
    }

    public void setBlockchain(Blockchain blockchain) {
        this.blockchain = blockchain;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Peer{");
        sb.append("port=").append(port);
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args) {
        Blockchain blockchain = new Blockchain(new ArrayList<>(), 3);
        Peer peer1 = P2P.addPeer(blockchain);
        System.out.println("Peers:" + P2P.getPeers());
        peer1.mine("1st block by p1");
        System.out.println("Blockchain with p1: " + peer1.getBlockchain().getBlocks());
        Peer peer2 = P2P.addPeer(blockchain);
        System.out.println("Peers: " + P2P.getPeers());
        System.out.println("Blockchain with p1: " + peer1.getBlockchain().getBlocks());
        System.out.println("Blockchain with p2: " + peer2.getBlockchain().getBlocks());
        peer2.mine("2nd block by p2");
        System.out.println("Blockchain with p1: " + peer1.getBlockchain().getBlocks());
        System.out.println("Blockchain with p2: " + peer2.getBlockchain().getBlocks());
        peer1.mine("3rd block by p1");
        System.out.println("Blockchain with p1: " + peer1.getBlockchain().getBlocks());
        System.out.println("Blockchain with p2: " + peer2.getBlockchain().getBlocks());
    }
}