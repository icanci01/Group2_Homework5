package hw5;

import hw5.menu.Smiles.Ingedients;

import java.util.ArrayList;

public class Foukou {

    public static int counter = -30;
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
        return this.usedSpace == this.capacity;
    }

    public int getLeftSpace() {
        return capacity - usedSpace;
    }

    public static int foukouDistribution(Order order, Foukou foukou) {
        int maxTime = 0;

        for (int i = 0; i < order.getPites().length; i++) {
            if (!foukou.isFull()) {
                foukou.add(order.getPites()[i].getA());
                order.getPites()[i].getA().psise();
                foukou.add(order.getPites()[i].getB());
                order.getPites()[i].getB().psise();
                foukou.add(order.getPites()[i].getP());
                order.getPites()[i].getP().psise();
                int tempMax = Math.max(order.getPites()[i].getA().psise(), order.getPites()[i].getB().psise());
                if (maxTime < tempMax)
                    maxTime = tempMax;
            } else {
                counter += maxTime;
                for (int j = 0; j < order.getPites().length; j++) {
                    if (order.getPites()[j].getA().done)
                        foukou.remove(order.getPites()[j].getA());
                    if (order.getPites()[j].getP().done)
                        foukou.remove(order.getPites()[j].getB());
                    if (order.getPites()[j].getP().done)
                        foukou.remove(order.getPites()[j].getP());
                    for (int k = i; k < order.getPites().length; k++) {
                        foukou.add(order.getPites()[k].getA());
                        order.getPites()[i].getA().psise();
                        foukou.add(order.getPites()[k].getB());
                        order.getPites()[i].getB().psise();
                        foukou.add(order.getPites()[k].getP());
                        order.getPites()[i].getP().psise();
                        int tempMax = Math.max(order.getPites()[i].getA().psise(), order.getPites()[i].getB().psise());
                        if (maxTime < tempMax)
                            maxTime = tempMax;
                    }
                }
            }
        }

        counter += maxTime;
        for (int i = 0; i < order.getPites().length; i++) {
            foukou.remove(order.getPites()[i].getA());
            foukou.remove(order.getPites()[i].getB());
            foukou.remove(order.getPites()[i].getP());
        }


        return counter;
    }

    public void clear() {
        this.foukou.clear();
        this.usedSpace = 0;
    }
}
