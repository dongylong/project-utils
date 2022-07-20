package com.design.patter.chain;

public class BusinessHandler extends AbstractChainHandler implements ChainHandler{
    private String name;

    public BusinessHandler(String name) {
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
        System.out.println("BusinessHandler");
        if(getChainHandler()!=null){
            getChainHandler().operator();
        }
    }
}
