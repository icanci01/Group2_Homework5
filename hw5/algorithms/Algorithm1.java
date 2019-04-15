package hw5.algorithms;

import hw5.Delivery;
import hw5.Order;

import java.util.ArrayList;

public class Algorithm1 {

    public static ArrayList<Delivery> useArlgorithm1(ArrayList<Order> ordersList) {

        ArrayList<Delivery> deliveryList = new ArrayList<Delivery>();

        deliveryList.add(new Delivery(ordersList.get(0).getIdNum(), ordersList.get(0).gettOrder(), ordersList.get(0).gettRequested(), ordersList.get(0).gettRequested() + 10, 10, 2));

        return deliveryList;
    }
}
