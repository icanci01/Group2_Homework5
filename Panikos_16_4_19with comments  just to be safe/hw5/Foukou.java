package hw5;

import hw5.menu.Smiles.Ingedients;

import java.util.ArrayList;

public class Foukou {

    private int capacity;
    private int usedSpace;
    private ArrayList<Ingedients> foukou;


    public Foukou(int capacity) {
        this.capacity = capacity;
        this.usedSpace = 0;
        foukou = new ArrayList<Ingedients>(capacity);
    }

    public void add(Ingedients item) {
        if (this.isFull())
            System.out.println("Foukou is full");
        else
            foukou.add(item);
    }

    public void remove(Ingedients item) {
        foukou.remove(item);
    }

    public int getCapacity() {
        return capacity;
    }

    public int getUsedSpace() {
        return usedSpace;
    }

    public boolean isEmpty() {
        return this.usedSpace == 0;
    }

    public boolean isFull() {
        return this.usedSpace == this.capacity;
    }

    public int getLeftSpace() {
        return capacity - usedSpace;
    }
}
