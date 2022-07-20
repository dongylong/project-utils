package com.design.patter.stragety;

public class TravelTest {
    public static void main(String[] args) {
        Context context = new Context();
        TravelStrategy travelByAir = new TravelByAir();
        context.setTravelStrategy(travelByAir);
        context.travelMode();

        TravelStrategy travelByCar = new TravelByCar();
        context.setTravelStrategy(travelByCar);
        context.travelMode();

    }
}
