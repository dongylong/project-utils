package com.design.patter.chain;

public class ResponseHandler extends AbstractChainHandler implements ChainHandler{
    private String name;

    public ResponseHandler(String name) {
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
        System.out.println("ResponseHandler");
        if(getChainHandler()!=null){
            getChainHandler().operator();
        }
    }
}
