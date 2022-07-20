package com.design.patter.chain;

public class ChainTest {
    public static void main(String[] args) {
        AuthHandler authHandler = new AuthHandler("authHandler");
        BusinessHandler businessHandler = new BusinessHandler("businessHandler");
        ResponseHandler responseHandler = new ResponseHandler("responseHandler");
        authHandler.setChainHandler(businessHandler);
        businessHandler.setChainHandler(responseHandler);
        authHandler.operator();
    }
}
