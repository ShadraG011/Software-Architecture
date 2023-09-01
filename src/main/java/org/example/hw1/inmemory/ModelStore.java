package org.example.hw1.inmemory;


import org.example.hw1.models.Flash;
import org.example.hw1.models.Camera;
import org.example.hw1.models.PoligonalModel;
import org.example.hw1.models.Scene;

import java.util.ArrayList;
import java.util.List;

public class ModelStore implements IModelChanger {
    private List<IModelChangeObserver> observers = new ArrayList<>();
    private List<PoligonalModel> models = new ArrayList<>();
    private List<Camera> cameras = new ArrayList<>();
    private List<Scene> scenes = new ArrayList<>();
    private List<Flash> flashes = new ArrayList<>();

    public void add(PoligonalModel model) {
        models.add(model);
        notifyChange();
    }

    @Override
    public void notifyChange() {
        String message = "Публикация: Новая полигональная модель добавлена";
        for (IModelChangeObserver observer : observers) {
            observer.applyUpdateModel(message);
        }

    }

    @Override
    public void registerModelChanger(IModelChangeObserver modelChanger) {
        observers.add(modelChanger);
    }

    @Override
    public void removeModelChanger(IModelChangeObserver modelChanger) {
        observers.remove(modelChanger);

    }

    public Scene getScene(int id) {
        return scenes.get(id);
    }
}
