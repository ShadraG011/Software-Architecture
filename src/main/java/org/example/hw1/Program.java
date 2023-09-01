package org.example.hw1;

import org.example.hw1.inmemory.ModelStore;
import org.example.hw1.inmemory.Observer1;
import org.example.hw1.models.Poligon;
import org.example.hw1.models.PoligonalModel;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        Observer1 observer1 = new Observer1();

        ModelStore store = new ModelStore();
        store.registerModelChanger(observer1);

        Poligon poligon1 = new Poligon();
        Poligon poligon2 = new Poligon();
        Poligon poligon3 = new Poligon();

        List<Poligon> poligons = new ArrayList<>();
        poligons.add(poligon1);
        poligons.add(poligon2);
        poligons.add(poligon3);

        PoligonalModel poligonalModel = new PoligonalModel(poligons);

        store.add(poligonalModel);
    }
}
