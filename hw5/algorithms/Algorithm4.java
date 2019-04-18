package hw5.algorithms;

import hw5.Delivery;
import hw5.Foukou;
import hw5.Order;

import java.util.ArrayList;

public class Algorithm4 {

    public static ArrayList<Delivery> useArlgorithm4(ArrayList<Order> ordersList, int sizeFoukou, int xronoKarvouna, int numTigania, int tiganiaCapacity) {
        int[] texec = new int[ordersList.size()];
        double[] w = new double[ordersList.size()];
        double average[] = new double[ordersList.size()];
        Foukou foukou = new Foukou(sizeFoukou);

        ArrayList<Delivery> deliveryList = new ArrayList<>(ordersList.size());

        for (int z = 0; z < ordersList.size(); z++) {


            for (int j = 0; j < ordersList.size(); j++) {
                texec[j] = Foukou.timeCaclculator(ordersList.get(j), foukou);
                w[j] = (texec[j] - (ordersList.get(j).gettRequested() - Foukou.counter)) / texec[j];
                average[j] = (w[j] + texec[j]) / 2;
            }

            double minW = Double.MIN_VALUE;
            int position = 0;
            for (int k = 0; k < average.length; k++) {
                if (average[k] > minW) {
                    minW = average[k];
                    position = k;
                }
            }

            Order process = new Order(ordersList.get(position));
            int tDelivered = Foukou.foukouDistribution(process, foukou);
            deliveryList.add(new Delivery(process.getIdNum(), process.gettOrder(),
                    process.gettRequested(), tDelivered, process.getNumberOfPites(), process.getNumberOfFries()));


            average[position] = Double.MIN_VALUE;
        }
        return deliveryList;
    }

}

