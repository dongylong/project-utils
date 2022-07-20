package com.design.patter.template.v3;

public abstract class AbstractClass {


    void templateMethod(){
        primitiveOperation1();
        primitiveOperation2();
        concreteOperation();
        hook();
    }

    protected abstract void primitiveOperation1();
    protected abstract void primitiveOperation2();

    final void concreteOperation(){
        //实现类
    }

    void hook(){

    }

}
