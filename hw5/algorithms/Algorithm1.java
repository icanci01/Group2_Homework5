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
            foukou.add(order.getPites()[i].getA());
            foukou.add(order.getPites()[i].getB());
            foukou.add(order.getPites()[i].getP());
            int tempMax = Math.max(order.getPites()[i].getA().getTime(), order.getPites()[i].getB().getTime());
            if (maxTime < tempMax)
                maxTime = tempMax;
        }

        return maxTime;
    }
}
