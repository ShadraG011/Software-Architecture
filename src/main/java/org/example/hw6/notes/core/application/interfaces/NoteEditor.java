package org.example.hw6.notes.core.application.interfaces;

import org.example.hw6.notes.core.domain.Note;

public interface NoteEditor extends Editor<Note, Integer> {

    void printAll();
}
