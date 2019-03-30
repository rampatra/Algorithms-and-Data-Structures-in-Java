package com.rampatra.blockchain;

import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
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

    /**
     * Once a new peer is created, we start the socket server to receive messages from the peers.
     */
    private void startServer() {
        try {
            executor.submit(() -> {
                server = new ServerSocket(port);
                while (true) {
                    // we create a new thread for each new client thereby supporting multiple client simultaneously
                    new Thread(new MessageHandler(server.accept(), this)).start();
                }
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Stop the server once a peer is removed from the network.
     */
    public void stopServer() {
        try {
            if (!server.isClosed()) {
                server.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Once a new peer is created and added to the network, it requests the latest block from
     * all the peers and updates its blockchain if it is outdated.
     */
    private void getLatestBlockFromPeers() {
        sendMessageToPeers(Message.MessageBuilder
                .aMessage()
                .withMessageType(Message.MessageType.REQUEST_LATEST_BLOCK)
                .build());
    }

    private void sendMessageToPeers(Message message) {
        try {
            // send to all peers except itself
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

    /**
     * Mine, create a new block with the {@code data}, and finally, add it to the blockchain.
     *
     * @param data
     */
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

    public int getPort() {
        return port;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Peer{");
        sb.append("blockchain=").append(blockchain);
        sb.append(", port=").append(port);
        sb.append('}');
        return sb.toString();
    }
}