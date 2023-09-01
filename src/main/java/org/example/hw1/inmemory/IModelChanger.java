package org.example.hw1.inmemory;

public interface IModelChanger {
    /**
     * Произошло изменение в хранилище моделей
     */
    void notifyChange();

    void registerModelChanger(IModelChangeObserver modelChanger);
    void removeModelChanger(IModelChangeObserver modelChanger);
}
