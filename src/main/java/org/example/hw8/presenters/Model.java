package org.example.hw8.presenters;

import org.example.hw8.models.Table;

import java.util.Collection;
import java.util.Date;

public interface Model {

    Collection<Table> loadTables();

    int reservationTable(Date reservationDate, int tableNo, String name);
    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name);

}
