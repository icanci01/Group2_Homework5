package hw5.algorithms;

import hw5.Delivery;
import hw5.Foukou;
import hw5.Order;

import java.util.ArrayList;

public class Algorithm1 {



    public static ArrayList<Delivery> useArlgorithm1(ArrayList<Order> ordersList, int sizeFoukou, int xronoKarvouna, int numTigania, int tiganiaCapacity) {

        ArrayList<Delivery> deliveryList = new ArrayList<>();

        if (Foukou.counter == -30) {
            Foukou.counter = Foukou.counter + xronoKarvouna;
            if (Foukou.counter < 0) {
                Foukou.counter = 0;
            }
        }
        Foukou foukou = new Foukou(sizeFoukou);

        for (int i = 0; i < ordersList.size(); i++) {
            Order processingOrder = ordersList.get(i);
            int tdelivered = Foukou.foukouDistribution(processingOrder, foukou);
            deliveryList.add(new Delivery(processingOrder.getIdNum(), processingOrder.gettOrder(),
                    processingOrder.gettRequested(), tdelivered, processingOrder.getNumberOfPites(), processingOrder.getNumberOfFries()));
        }
        return deliveryList;
    }


}
