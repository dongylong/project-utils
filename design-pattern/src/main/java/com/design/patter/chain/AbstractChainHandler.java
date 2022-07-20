package com.design.patter.chain;

public abstract class AbstractChainHandler {
   private ChainHandler chainHandler;

    public ChainHandler getChainHandler() {
        return chainHandler;
    }

    public void setChainHandler(ChainHandler chainHandler) {
        this.chainHandler = chainHandler;
    }
}
