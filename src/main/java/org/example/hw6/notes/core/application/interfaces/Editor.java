package org.example.hw6.notes.core.application.interfaces;


import org.example.hw6.notes.core.domain.Note;

import java.util.Collection;
import java.util.Optional;

public interface Editor<T, TId> {

    boolean add(T item);

    boolean edit(T item, String title, String details);

    boolean remove(Note item);

    Optional<T> getById(TId id);

    Collection<T> getAll();
}
