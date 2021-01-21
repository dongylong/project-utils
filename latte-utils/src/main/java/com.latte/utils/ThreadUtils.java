package com.latte.utils;

import org.slf4j.MDC;

import java.util.Map;

public class ThreadUtils {

    public static void copyMDCProperty(){
        Map<String, String> mdcCopy = MDC.getCopyOfContextMap();
        try{
            MDC.setContextMap(mdcCopy);
        }catch (Exception e){

        }finally {
            MDC.clear();
        }
    }
}
