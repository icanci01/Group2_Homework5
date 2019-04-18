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

    public static int timeCaclculator(Order order, Foukou foukou) {
        int maxTime = 0;
        for (int j = 0; j < order.getPites().length; j++) {
            foukou.add(order.getPites()[j].getA());
            order.getPites()[j].getA().psise();
            foukou.add(order.getPites()[j].getB());
            order.getPites()[j].getB().psise();
            foukou.add(order.getPites()[j].getP());
            order.getPites()[j].getP().psise();
            int tempMax = Math.max(order.getPites()[j].getA().psise(), order.getPites()[j].getB().psise());
            if (maxTime < tempMax)
                maxTime = tempMax;
        }
        return maxTime;

    }

    public void add(Ingedients item) {
        if (this.isFull())
            System.out.println("Foukou is full");
        else {
            foukou.add(item);
            usedSpace = usedSpace + item.getSize();
        }
    }

    public int psise(Ingedients item) {
        return item.psise();
    }

    public void remove(Ingedients item) {
        usedSpace = usedSpace - item.getSize();
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
        return this.usedSpace < 3;
    }

    public int getLeftSpace() {
        return capacity - usedSpace;
    }

    public boolean itFits(Order order) {
        if (order.getTotalLength() <= this.capacity - this.usedSpace)
            return true;
        return false;
    }

    public void clear() {
        this.foukou.clear();
        this.usedSpace = 0;
    }
}
