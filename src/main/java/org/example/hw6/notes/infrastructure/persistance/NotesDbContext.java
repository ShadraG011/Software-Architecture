package org.example.hw6.notes.infrastructure.persistance;

import org.example.hw6.database.NotesDatabase;
import org.example.hw6.database.NotesRecord;
import org.example.hw6.notes.core.application.interfaces.NotesDatabaseContext;
import org.example.hw6.notes.core.domain.Note;
import org.example.hw6.notes.infrastructure.persistance.configurations.NoteConfiguration;

import java.util.ArrayList;
import java.util.Collection;

public class NotesDbContext extends DbContext implements NotesDatabaseContext {
    private Collection<Note> notesList;

    @Override
    public Collection<Note> getAll() {
        if (notesList == null) {
            notesList = new ArrayList<>();
            //TODO: Этого кастинга быть не должно, тут должен работать внутренний механизм фреймворка
            for (NotesRecord record : ((NotesDatabase) database).getNotesTable().getRecords()) {
                notesList.add(new Note(
                        record.getId(),
                        record.getUserId(),
                        record.getTitle(),
                        record.getDetails(),
                        record.getCreationDate()
                ));
            }
        }
        return notesList;
    }

    @Override
    public boolean saveChanges() {
        ArrayList<NotesRecord> records = new ArrayList<>();
        for (Note note : notesList) {
            records.add(new NotesRecord(
                    note.getId(),
                    note.getUserId(),
                    note.getTitle(),
                    note.getDetails(),
                    note.getCreationDate()
            ));
        }
        ((NotesDatabase) database).getNotesTable().setRecords(records);
        return true;
    }

    public NotesDbContext(Database database) {
        super(database);
    }

    @Override
    protected void onModelCreating(ModelBuilder builder) {
        builder.applyConfiguration(new NoteConfiguration());
    }


}
