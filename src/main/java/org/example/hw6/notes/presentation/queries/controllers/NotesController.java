package org.example.hw6.notes.presentation.queries.controllers;

import org.example.hw6.database.NotesRecord;
import org.example.hw6.notes.core.application.interfaces.NoteEditor;
import org.example.hw6.notes.core.domain.Note;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.Scanner;

public class NotesController extends Controller {
    private Scanner scanner = new Scanner(System.in);
    private final NoteEditor notesEditor;

    public NotesController(NoteEditor notesEditor) {
        this.notesEditor = notesEditor;
    }

    public void routeAddNote() {
        this.notesEditor.add(new Note((getAll().iterator().next().getId()) + getAll().size(), getAll().iterator().next().getUserId() + getAll().size(), setTitle(), setDetails(), new Date()));
    }

    public void routeRemoveNote() {
        this.notesEditor.remove(this.notesEditor.getById(getById()).get());
    }

    public void routeEditNote() {
        this.notesEditor.edit(this.notesEditor.getById(getById()).get(), setTitle(), setDetails());
    }

    public void routePrintAll() {
        this.notesEditor.printAll();
    }

    public Optional<Note> routeGetById(Integer id) {
        return this.notesEditor.getById(id);
    }

    public Collection<Note> getAll() {
        return notesEditor.getAll();
    }

    private String setTitle() {
        System.out.print("Введите новое название: ");
        return scanner.nextLine();
    }

    private String setDetails() {
        System.out.print("Введите новое описание: ");
        return scanner.nextLine();
    }

    private Integer getById() {
        System.out.print("Введите Id заметки: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        return id;
    }
}
