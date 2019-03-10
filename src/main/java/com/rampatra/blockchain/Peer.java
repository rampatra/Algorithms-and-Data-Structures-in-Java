package com.rampatra.blockchain;

import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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

    public static void main(String[] args) {
        try {
            int menuChoice;
            int peerIndex;
            String data;
            Scanner s = new Scanner(System.in);
            Blockchain blockchain = new Blockchain(new ArrayList<>(), 3);

            while (true) {

                System.out.println("\n======= Welcome to Blockchain in Java =======");
                System.out.println("1. Add Peer");
                System.out.println("2. Mine data in peer");
                System.out.println("3. Remove peer");
                System.out.println("4. Show peers");
                System.out.println("5. Exit");

                menuChoice = s.nextInt();

                switch (menuChoice) {
                    case 1:
                        P2P.addPeer(blockchain);
                        System.out.println("New peer added!");
                        P2P.showPeersWithBlockchain();
                        break;
                    case 2:
                        System.out.println("Choose peer: (ex. 1, 2, etc.)");
                        P2P.showPeers();
                        peerIndex = s.nextInt();
                        Peer p = P2P.getPeer(peerIndex - 1);
                        System.out.println("Enter data: ");
                        data = s.next();
                        p.mine(data);
                        System.out.println("Data mined!");
                        P2P.showPeersWithBlockchain();
                        break;
                    case 3:
                        System.out.println("Choose peer: (ex. 1, 2, etc.)");
                        P2P.showPeers();
                        peerIndex = s.nextInt();
                        P2P.removePeer(peerIndex - 1);
                        System.out.println("Peer " + peerIndex + " removed!");
                        P2P.showPeersWithBlockchain();
                        break;
                    case 4:
                        P2P.showPeersWithBlockchain();
                        break;
                    case 5:
                        P2P.removeAllPeers();
                        System.out.println("Bye, see you soon!");
                        System.exit(0);
                    default:
                        System.out.println("Wrong choice!");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}