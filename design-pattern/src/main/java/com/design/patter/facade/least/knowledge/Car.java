package com.design.patter.facade.least.knowledge;

public class Car {
    Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public Car() {
    }
    public void start(Key key){
        Doors doors = new Doors();
        boolean authorized = key.turns();
        if(authorized){
            engine.start();
            updateDashBoardDisplay();
            doors.lock();
        }
    }

    private void updateDashBoardDisplay() {
    }
}
