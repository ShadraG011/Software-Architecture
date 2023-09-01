package org.example.hw1.inmemory;

public class Observer1 implements IModelChangeObserver {
    @Override
    public void applyUpdateModel(String message) {
        System.out.println(message + " | observer#1");
    }
}
