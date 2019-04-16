package hw5.algorithms;

import hw5.Delivery;
import hw5.Foukou;
import hw5.Order;

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
}
