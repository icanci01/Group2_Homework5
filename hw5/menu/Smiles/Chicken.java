package hw5.menu.Smiles;

import hw5.menu.Smiles.Smila;

public class Chicken extends Smila {


    public Chicken(int size) {
        super(size, timeRnadom(), "Chicken");
    }

    private static int timeRnadom() {
        int x = 15;
        x += Math.random() * 5;
        return x;
    }

}
