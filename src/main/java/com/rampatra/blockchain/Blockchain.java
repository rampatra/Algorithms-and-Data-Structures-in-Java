package com.rampatra.blockchain;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

/**
 * @author rampatra
 * @since 2019-03-05
 */
public class Blockchain { // TODO: WIP

    private List<Block> blockchain;
    private int difficulty;

    public Blockchain(List<Block> blockchain, int difficulty) {
        this.blockchain = blockchain;
        this.difficulty = difficulty;
    }

    public void mine(String data) {
        if (blockchain.size() == 0) {
            blockchain.add(getGenesisBlock(data));
        } else {
            Block previousBlock = blockchain.get(blockchain.size() - 1);
            blockchain.add(getNextBlock(previousBlock, data));
        }
    }

    private boolean isValidNextBlock(Block previousBlock, Block nextBlock) {
        
        String nextBlockHash = calculateHashForBlock(nextBlock.getIndex(), previousBlock.getHash(), 
                nextBlock.getTimestamp(), nextBlock.getData(), nextBlock.getNonce());

        if (previousBlock.getIndex() + 1 != nextBlock.getIndex()) {
            return false;
        } else if (!previousBlock.getHash().equals(nextBlock.getPreviousHash())) {
            return false;
        } else if (!this.isValidHashDifficulty(nextBlockHash)) {
            return false;
        } else if (!nextBlockHash.equals(nextBlock.getHash())) {
            return false;
        } else {
            return true;
        }
    }

    private Block getGenesisBlock(String data) {
        final long timestamp = new Date().getTime();
        String hash = calculateHashForBlock(0, "0", timestamp, data, 0);

        return new Block(0, "0", timestamp, data, hash, 0);
    }

    private Block getNextBlock(Block previousBlock, String data) {
        final int index = previousBlock.getIndex() + 1;
        final long timestamp = new Date().getTime();

        final String hash = calculateHashForBlock(index, previousBlock.getHash(), timestamp, data, 0);
        return new Block(index, previousBlock.getHash(), timestamp, data, hash, 0);
    }

    private boolean isValidHashDifficulty(String hash) {
        for (int i = 0; i < difficulty; i++) {
            if (hash.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }

    private String calculateHashForBlock(final int index, final String previousHash, final long timestamp,
                                         final String data, final int nonce) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(
                    (index + previousHash + timestamp + data + nonce).getBytes(StandardCharsets.UTF_8));
            return bytesToHex(encodedhash);
        } catch (NoSuchAlgorithmException e) {
            // do nothing for now
        }
        return "";
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
