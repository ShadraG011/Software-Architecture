package org.example.hw6;


import org.example.hw6.database.NotesDatabase;
import org.example.hw6.notes.core.application.ConcreteNoteEditor;
import org.example.hw6.notes.infrastructure.persistance.NotesDbContext;
import org.example.hw6.notes.presentation.queries.controllers.NotesController;
import org.example.hw6.notes.presentation.queries.views.NotesConsolePresenter;

import javax.swing.*;
import java.util.Date;
import java.util.Scanner;

public class Program {
    private static Scanner scanner = new Scanner(System.in);

    private static String[] menu = {
            "1. Отобразить все заметки.",
            "2. Добавить заметку.",
            "3. Изменить заметку.",
            "4. Удалить заметку.",
            "0. Выйти из приложения."
    };

    public static void main(String[] args) {
        NotesController controller = new NotesController(
                new ConcreteNoteEditor(new NotesDbContext(new NotesDatabase()), new NotesConsolePresenter()));


        boolean f = true;
        while (f) {
            System.out.println("\n*** РЕДАКТОР ЗАМЕТОК ***");
            for (String menuItem : menu) {
                System.out.println(menuItem);
            }
            System.out.print("Пожалуйста, выберите пункт меню: ");
            if (scanner.hasNextInt()) {
                int no = scanner.nextInt();
                scanner.nextLine();
                try {
                    switch (no) {
                        case 0 -> {
                            System.out.println("Завершение работы приложения");
                            f = false;
                        }
                        case 1 -> {
                            System.out.println("\n*** Список заметок ***");
                            controller.routePrintAll();
                        }
                        case 2 -> {
                            controller.routeAddNote();
                            System.out.println("Заметка успешно добавлена!");
                        }
                        case 3 -> {
                            controller.routePrintAll();
                            controller.routeEditNote();
                            System.out.println("Заметка успешно изменена!");
                        }
                        case 4 -> {
                            controller.routePrintAll();
                            controller.routeRemoveNote();
                            System.out.println("Заметка успешно уделена!");
                        }
                        default -> System.out.println("Укажите корректный пункт меню.");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Укажите корректный пункт меню.");
                scanner.nextLine();
            }
        }

    }

}
