package org.example.hw3;

import java.awt.*;

public class SportCar extends Car implements Fueling, Washing {

    private Refueling refueling;
    private Washing washing;


    public SportCar(String make, String model, Color color) {
        super(make, model, color);
        setWheelsCount(3);
    }

    {
        fuelType = FuelType.Gasoline;
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

}
