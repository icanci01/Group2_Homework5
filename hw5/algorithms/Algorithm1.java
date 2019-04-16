package hw5.algorithms;

import hw5.Delivery;
import hw5.Foukou;
import hw5.Order;
import hw5.menu.Pita;

import java.util.ArrayList;

public class Algorithm1 {

    static int counter = -30;

    public static ArrayList<Delivery> useArlgorithm1(ArrayList<Order> ordersList, int sizeFoukou, int xronoKarvouna, int numTigania, int tiganiaCapacity) {

        ArrayList<Delivery> deliveryList = new ArrayList<>();

        if (counter == -30) {
            counter = counter + xronoKarvouna;
            if (counter < 0) {
                counter = 0;
            }
        }
        Foukou foukou = new Foukou(sizeFoukou);

        for (int i = 0; i < ordersList.size(); i++) {
            Order processingOrder = ordersList.get(i);
            int tdelivered = foukouDistribution(processingOrder, foukou);
            deliveryList.add(new Delivery(processingOrder.getIdNum(), processingOrder.gettOrder(),
                    processingOrder.gettRequested(), tdelivered, processingOrder.getNumberOfPites(), processingOrder.getNumberOfFries()));
        }
        return deliveryList;
    }

    public static int foukouDistribution(Order order, Foukou foukou) {
        for (int i = 0; i < order.getChickenPites().length; i++) {
            foukou.add(order.getChickenPites()[i].getA());
            foukou.add(order.getChickenPites()[i].getB());
            foukou.add(new Pita(5));
        }
        for (int i = 0; i < order. ().length; i++){
            foukou.add(order.getChickenPites()[i].getA());
            foukou.add(order.getChickenPites()[i].getB());
            foukou.add(new Pita(5));
        }
        for (int i = 0; i < order.getChickenPites().length; i++) {
            foukou.add(order.getChickenPites()[i].getA());
            foukou.add(order.getChickenPites()[i].getB());
            foukou.add(new Pita(5));
        }
        for (int i = 0; i < order.getChickenPites().length; i++) {
            foukou.add(order.getChickenPites()[i].getA());
            foukou.add(order.getChickenPites()[i].getB());
            foukou.add(new Pita(5));
        }


        int timeneed = 0;
        return timeneed;
    }
}
