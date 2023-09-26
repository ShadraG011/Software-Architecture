package org.example.hw8.models;

import java.util.Date;

public class Reservation {

    public boolean isReservationCancelled() {
        return reservationCancelled;
    }

    public void setReservationCancelled(boolean reservationCancelled) {
        this.reservationCancelled = reservationCancelled;
    }

    public int getId() {
        return id;
    }

    private static int counter = 1000;
    private final int id;

    private Table table;

    private Date date;
    private String name;

    private boolean reservationCancelled = false;

    {
        id = ++counter;
    }

    public Reservation(Table table, Date date, String name) {
        this.table = table;
        this.date = date;
        this.name = name;
    }
}
