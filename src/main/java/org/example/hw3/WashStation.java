package org.example.hw3;

public class WashStation implements Washing{
    @Override
    public void washCar() {
        System.out.println("Мойка №1: Осуществляется мойка машины снаружи.");
    }

    @Override
    public void washInterior() {
        System.out.println("Мойка №1: Осуществляется мойка машины внутри.");
    }
}
