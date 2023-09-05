package org.example.hw3;

import java.awt.*;

public class Harvester extends Car implements Fueling, Wiping, Washing {
    private Refueling refueling;
    private Washing washing;

    {
        fuelType = FuelType.Diesel;
    }

    public Harvester(String make, String model, Color color) {
        super(make, model, color);
        setWheelsCount(6);
    }

    /**
     * Метод для назначения мойки для машины.
     *
     * @param washing
     */
    public void setWashingStation(Washing washing) {
        this.washing = washing;
    }

    /**
     * Метод для осуществления мойки машины снаружи
     */
    @Override
    public void washCar() {
        if (washing != null) {
            washing.washCar();
        }

    }

    /**
     * Метод для осуществления мойки салона машины
     */
    @Override
    public void washInterior() {
        if (washing != null) {
            washing.washInterior();
        }
    }


    public void setRefuelingStation(Refueling refuelingStation) {
        this.refueling = refuelingStation;
    }

    /**
     * Заправить автомобиль
     */
    @Override
    public void fuel() {
        if (refueling != null) {
            refueling.fuel(fuelType);
        }
    }

    @Override
    public void movement() {

    }

    @Override
    public void maintenance() {

    }

    @Override
    public boolean gearShifting() {
        return false;
    }

    @Override
    public boolean switchHeadlights() {
        return false;
    }

    @Override
    public boolean switchWipers() {
        return false;
    }

    public void sweeping() {
        System.out.println("Автомобиль метет улицу.");
    }


    @Override
    public void wipMirrors() {

    }

    @Override
    public void wipWindshield() {

    }

    @Override
    public void wipHeadlights() {

    }
}
