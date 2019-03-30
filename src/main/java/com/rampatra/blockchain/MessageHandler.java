package com.rampatra.blockchain;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

/**
 * @author rampatra
 * @since 2019-03-10
 */
public class MessageHandler implements Runnable {

    private ObjectInputStream in;
    private ObjectOutputStream out;
    private Peer peer;

    MessageHandler(Socket client, Peer peer) {
        try {
            in = new ObjectInputStream(client.getInputStream());
            out = new ObjectOutputStream(client.getOutputStream());
            this.peer = peer;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        Message message;
        try {
            while ((message = (Message) in.readObject()) != null) {
                handleMessage(message);
            }
        } catch (Exception e) {
            if (!(e instanceof SocketException)) {
                throw new RuntimeException(e);
            }
        } finally {
            try {
                in.close();
                out.close();
            } catch (Exception e) {
                // do nothing
            }
        }
    }

    /**
     * Handle messages accordingly.
     *
     * @param message is the message object from the peer.
     */
    private void handleMessage(Message message) {
        Message.MessageType type = message.getMessageType();
        switch (type) {
            case REQUEST_LATEST_BLOCK:
                sendMessage(Message.MessageBuilder
                        .aMessage()
                        .withMessageType(Message.MessageType.RECEIVE_LATEST_BLOCK)
                        .withLatestBlock(peer.getBlockchain().getLatestBlock())
                        .build());
                break;
            case RECEIVE_LATEST_BLOCK:
                handleLatestBlock(message.getLatestBlock());
                break;
            case REQUEST_BLOCKCHAIN:
                sendMessage(Message.MessageBuilder
                        .aMessage()
                        .withMessageType(Message.MessageType.RECEIVE_BLOCKCHAIN)
                        .withBlockchain(peer.getBlockchain())
                        .build());
                break;
            case RECEIVE_BLOCKCHAIN:
                handleBlockchain(message.getBlockchain());
                break;
            default:
                throw new RuntimeException("Unknown message type");
        }
    }

    private void sendMessage(Message message) {
        try {
            out.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * If the latest block received from the peer has {@code previousHash} equal to the hash of the
     * latest block in the current user's blockchain then add the latest block received to the 
     * current user's blockchain, or else, if the latest block received has a larger index then 
     * request the entire blockchain from the peer.
     *
     * @param latestBlock the block received from the peer
     */
    private void handleLatestBlock(Block latestBlock) {
        Block latestBlockWithCurrentPeer = peer.getBlockchain().getLatestBlock();

        if (latestBlock.getPreviousHash().equals(latestBlockWithCurrentPeer.getHash())) {
            peer.getBlockchain().addBlock(latestBlock);
        } else if (latestBlock.getIndex() > latestBlockWithCurrentPeer.getIndex()) {
            sendMessage(Message.MessageBuilder
                    .aMessage()
                    .withMessageType(Message.MessageType.REQUEST_BLOCKCHAIN)
                    .build());
        }
    }

    /**
     * If the blockchain received from the peer is valid and longer then replace current user's
     * blockchain with the received blockchain.
     *
     * @param blockchain the entire blockchain received from the peer
     */
    private void handleBlockchain(Blockchain blockchain) {
        if (blockchain.isValidChain() && blockchain.getSize() > peer.getBlockchain().getSize()) {
            peer.setBlockchain(blockchain);
        }
    }
}