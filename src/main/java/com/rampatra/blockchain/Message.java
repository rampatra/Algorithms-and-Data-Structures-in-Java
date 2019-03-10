package com.rampatra.blockchain;

import java.io.Serializable;

/**
 * @author rampatra
 * @since 2019-03-10
 */
public class Message implements Serializable {

    enum MessageType {
        REQUEST_LATEST_BLOCK,
        RECEIVE_LATEST_BLOCK,
        REQUEST_BLOCKCHAIN,
        RECEIVE_BLOCKCHAIN
    }

    private MessageType messageType;
    private Block latestBlock;
    private Blockchain blockchain;


    public MessageType getMessageType() {
        return messageType;
    }

    public Block getLatestBlock() {
        return latestBlock;
    }

    public Blockchain getBlockchain() {
        return blockchain;
    }

    public static final class MessageBuilder {
        private MessageType messageType;
        private Block latestBlock;
        private Blockchain blockchain;

        private MessageBuilder() {
        }

        public static MessageBuilder aMessage() {
            return new MessageBuilder();
        }

        public MessageBuilder withMessageType(MessageType messageType) {
            this.messageType = messageType;
            return this;
        }

        public MessageBuilder withLatestBlock(Block latestBlock) {
            this.latestBlock = latestBlock;
            return this;
        }

        public MessageBuilder withBlockchain(Blockchain blockchain) {
            this.blockchain = blockchain;
            return this;
        }

        public Message build() {
            Message message = new Message();
            message.latestBlock = this.latestBlock;
            message.blockchain = this.blockchain;
            message.messageType = this.messageType;
            return message;
        }
    }
}