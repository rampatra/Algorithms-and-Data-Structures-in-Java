package com.rampatra.blockchain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * @author rampatra
 * @since 2019-03-09
 */
public class P2P {

    private static List<Peer> peers = new ArrayList<>();
    private static int lastUsedPort = 4000;

    public static Peer addPeer(Blockchain blockchain) {
        Peer peer = new Peer(blockchain, lastUsedPort++);
        peers.add(peer);
        return peer;
    }
    
    public static void removePeer(int index) {
        Peer peer = peers.get(index);
        peer.stopServer();
        peers.remove(index);
    }

    public static void removePeer(Peer peer) {
        Iterator<Peer> iterator = peers.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(peer)) {
                peer.stopServer();
                iterator.remove();
                break;
            }
        }
    }
    
    public static void removeAllPeers() {
        Iterator<Peer> iterator = peers.iterator();
        while (iterator.hasNext()) {
            Peer peer = iterator.next();
            peer.stopServer();
            iterator.remove();
        }
    }
    
    public static Peer getPeer(int index) {
        return peers.get(index);
    }

    public static List<Peer> getPeers() {
        return peers;
    }
    
    public static void showPeers() {
        for (int i = 0; i < peers.size(); i++) {
            System.out.println("Peer " + (i + 1) + ": " + peers.get(i).getPort());
        }
    }

    public static void showPeersWithBlockchain() {
        for (int i = 0; i < peers.size(); i++) {
            System.out.println("Peer " + (i + 1) + " (" + peers.get(i).getPort() + "): " + peers.get(i).getBlockchain());
        }
    }

    /**
     * The main starting point of the blockchain demo. At first, add some peers (option 1) and mine some data 
     * by choosing a particular peer (option 2). You would soon see that the newly mined block is broadcast to
     * all the peers.
     *
     * @param args
     */
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
                        System.out.println("Choose peer: (a number for ex. 1, 2, etc.)");
                        P2P.showPeers();
                        peerIndex = s.nextInt();
                        Peer p = P2P.getPeer(peerIndex - 1);
                        System.out.println("Enter data: (a string with no spaces)");
                        data = s.next();
                        p.mine(data);
                        System.out.println("Data mined!");
                        P2P.showPeersWithBlockchain();
                        break;
                    case 3:
                        System.out.println("Choose peer: (a number for ex. 1, 2, etc.)");
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