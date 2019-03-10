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

    public static List<Peer> getPeers() {
        return peers;
    }
}