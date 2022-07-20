package com.design.patter.chain;

public class AuthHandler extends AbstractChainHandler implements ChainHandler{
    private String name;

    public AuthHandler(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void operator() {
        System.out.println("AuthHandler");
        if(getChainHandler()!=null){
            getChainHandler().operator();
        }
    }
}
