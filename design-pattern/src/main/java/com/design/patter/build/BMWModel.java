package com.design.patter.build;

/**
 * @author dongyl
 * @date 20:01 1/9/19
 * @project study-demo
 */
public class BMWModel extends CarModel {
    @Override
    protected void start() {
        System.out.println("BMW start");
    }

    @Override
    protected void stop() {
        System.out.println("BMW stop");
    }

    @Override
    protected void alarm() {
        System.out.println("BMW alarm");
    }

    @Override
    protected void engineBoom() {
        System.out.println("BMW engineBoom");
    }
}
