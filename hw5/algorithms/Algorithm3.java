package hw5.algorithms;

import hw5.Delivery;
import hw5.Foukou;
import hw5.Order;

import java.util.ArrayList;

public class Algorithm3 {

    public static ArrayList<Delivery> useArlgorithm3(ArrayList<Order> ordersList, int sizeFoukou, int xronoKarvouna, int numTigania, int tiganiaCapacity) {
int[] texec = new int[ordersList.size()];

        Foukou foukou = new Foukou(sizeFoukou);
        for (int i = 0; i <ordersList.size() ; i++) {
            texec[i] = Foukou.timeCaclculator(ordersList.get(i),foukou,i);
        }

    }

}
