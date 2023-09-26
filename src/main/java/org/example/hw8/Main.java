package org.example.hw8;

import org.example.hw8.models.TableModel;
import org.example.hw8.presenters.BookingPresenter;
import org.example.hw8.presenters.Model;
import org.example.hw8.presenters.View;
import org.example.hw8.views.BookingView;

import java.util.Calendar;
import java.util.Date;

public class Main {

    /**
     * TODO: ДОМАШНЕЕ ЗАДАНИЕ: Метод changeReservationTable ДОЛЖЕН ЗАРАБОТАТЬ!
     * @param args
     */
    public static void main(String[] args) {

        View view = new BookingView();
        Model model = new TableModel();
        BookingPresenter presenter = new BookingPresenter(model, view);

        presenter.updateUIShowTables();

        /**
         * Первоначальное бронирование столиков
         */
        view.reservationTable(new Date(), 2, "Станислав");
        view.reservationTable(new Date(), 3, "Владислав");
        view.reservationTable(new Date(), 4, "Владимир");
        view.reservationTable(new Date(), 5, "Максим");

        /**
         * Работающий метод для изменения брони на столик
         */
        view.changeReservationTable(1001, new Date(123, Calendar.OCTOBER, 26, 16, 0,0), 3, "Павел");
        view.changeReservationTable(1003, new Date(123, Calendar.OCTOBER, 27, 12, 0,0), 3, "Игорь");
        view.changeReservationTable(1004, new Date(123, Calendar.OCTOBER, 28, 17, 0,0), 3, "Валентина");
        view.changeReservationTable(1002, new Date(123, Calendar.OCTOBER, 29, 20, 0,0), 3, "Ирина");
    }

}
