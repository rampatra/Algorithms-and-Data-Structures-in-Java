package com.rampatra.blockchain;

import java.io.Serializable;

/**
 * @author rampatra
 * @since 2019-03-05
 */
public class Block implements Serializable {
    
    private int index;
    private String previousHash;
    private long timestamp;
    private String data;
    private String hash;
    private int nonce;

    public Block(int index, String previousHash, long timestamp, String data, String hash, int nonce) {
        this.index = index;
        this.previousHash = previousHash;
        this.timestamp = timestamp;
        this.data = data;
        this.hash = hash;
        this.nonce = nonce;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Block{");
        sb.append("index=").append(index);
        sb.append(", previousHash='").append(previousHash).append('\'');
        sb.append(", timestamp=").append(timestamp);
        sb.append(", data='").append(data).append('\'');
        sb.append(", hash='").append(hash).append('\'');
        sb.append(", nonce=").append(nonce);
        sb.append('}');
        return sb.toString();
    }
}