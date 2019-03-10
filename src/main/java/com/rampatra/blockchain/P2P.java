package com.rampatra.blockchain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
            System.out.println("Peer " + (i + 1) + ": " + peers.get(i).getBlockchain());
        }
    }
}