package hw5;

import hw5.menu.Fries;

import java.util.ArrayList;

public class Pan {
    private int capacity;
    private int usedSpace;
    private ArrayList<Fries> pan;
    private int numOfPans;
    private ArrayList<Fries>[] pans;

    public Pan(int capacity, int numOfPans) {
        this.capacity = capacity;
        this.usedSpace = 0;
        this.numOfPans = numOfPans;
        pans = new ArrayList[numOfPans];

        for (int i = 0; i < numOfPans; i++)
            pans[i] = new ArrayList<Fries>(capacity);
    }

    public void add(Fries item) {
        if (isFull(this.pan))
            System.out.println("Foukou is full");
        else {
            pan.add(item);
            this.usedSpace = this.usedSpace + item.getSize();
        }
    }

    public ArrayList<Fries>[] getPans() {
        return this.pans;
    }

    public boolean allFull() {
        boolean fuck = true;
        for (int i = 0; i < this.pans.length; i++)
            if (!isFull(this.pans[i]))
                fuck = true;
        return fuck;


    }

    public int psise(Fries item) {
        return item.psise();
    }

    public void remove(Fries item) {
        this.usedSpace = this.usedSpace - item.getSize();
        pan.remove(item);
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

    public boolean isFull(ArrayList<Fries> pan) {
        return pan.size() == this.capacity;
    }

    public int getLeftSpace() {
        return capacity - usedSpace;
    }
}
