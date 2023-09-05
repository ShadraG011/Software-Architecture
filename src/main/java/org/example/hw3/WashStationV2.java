package org.example.hw3;

public class WashStationV2 implements Washing{
    @Override
    public void washCar() {
        System.out.println("Мойка №2: Осуществляется мойка машины внутри.");
    }

    @Override
    public void washInterior() {
        System.out.println("Мойка №2: Осуществляется мойка машины снаружи.");
    }
}
