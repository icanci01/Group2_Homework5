package hw5.algorithms;

import hw5.Delivery;
import hw5.Kitchen;
import hw5.Order;

import java.util.ArrayList;

public class Algorithm1 {

    public static ArrayList<Delivery> useArlgorithm1(ArrayList<Order> ordersList, Kitchen workingKitchen) {

        ArrayList<Delivery> deliveryList = new ArrayList<>();

        //Since it is already time ordered we dont have to make any changes
        int[] timeDelivered = workingKitchen.KitchenDistribution(ordersList);

        for (int i = 0; i < ordersList.size(); i++) {
            Order processingOrder = ordersList.get(i);
            deliveryList.add(new Delivery(processingOrder.getIdNum(), processingOrder.gettOrder(),
                    processingOrder.gettRequested(), timeDelivered[i], processingOrder.getNumberOfPites(), processingOrder.getNumberOfFries()));
        }

        return deliveryList;
    }


}
