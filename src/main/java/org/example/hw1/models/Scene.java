package org.example.hw1.models;

import java.util.List;

public class Scene {
    private int counter = 0;
    private int id;
    private PoligonalModel model;
    private List<Flash> flashes;

    {
        id = ++counter;
    }

    public Scene(PoligonalModel model, List<Flash> flashes) {
        this.model = model;
        this.flashes = flashes;
    }

    public Flash findFlash(List<Flash> flashes, int id){
        return flashes.get(id);
    }

    public String showScene(PoligonalModel model){
        return model == null ? "Сцена создана!" : "Ошибка создания сцены, полигональная модель не найдена!";
    }

    public PoligonalModel getModel() {
        return model;
    }

    public void setModel(PoligonalModel model) {
        this.model = model;
    }

    public List<Flash> getFlashes() {
        return flashes;
    }

    public void setFlashes(List<Flash> flashes) {
        this.flashes = flashes;
    }

    public int getId() {
        return id;
    }
}
