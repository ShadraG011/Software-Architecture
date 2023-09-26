package org.example.hw8.presenters;

import org.example.hw8.models.Table;

import java.util.Collection;
import java.util.Date;

public class BookingPresenter implements ViewObserver {

    private final Model model;
    private final View view;

    public BookingPresenter(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.setObserver(this);
    }

    /**
     * Получение списка всех столиков
     */
    public Collection<Table> loadTables(){
        return model.loadTables();
    }

    /**
     * Отобразить список столиков (на представлении)
     */
    public void updateUIShowTables(){
        view.showTables(loadTables());
    }

    public void updateUIShowReservationTableResult(int reservationNo, int tableNo, String name, Date reservationDate){
        view.showReservationTableResult(reservationNo, tableNo, name, reservationDate);
    }

    /**
     * Произошло событие, пользователь нажал на кнопку резерва столика
     * @param orderDate дата резерва
     * @param tableNo номер столика
     * @param name имя клиента
     */
    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        try {
            int reservationNo = model.reservationTable(orderDate, tableNo, name);
            updateUIShowReservationTableResult(reservationNo, tableNo, name, orderDate);

        }
        catch (RuntimeException e){
            updateUIShowReservationTableResult(-1, -3, null, null);
        }
    }

    @Override
    public void onChangeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        try {
            int newReservationNo = model.changeReservationTable(oldReservation, reservationDate, tableNo, name);
            updateUIShowReservationTableResult(newReservationNo, tableNo, name, reservationDate);
        } catch (RuntimeException e){
            updateUIShowReservationTableResult(-2, -3, name, null);
        }
    }
}
