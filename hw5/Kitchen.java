package hw5;

import java.util.ArrayList;

public class Kitchen {
    public static int counter = -30;
    private Foukou foukou;
    private Pan pan;


    public Kitchen(Foukou foukou, int xronosKarvouna, Pan pan) {
        this.foukou = foukou;
        this.pan = pan;
        counter += xronosKarvouna;

        if (counter < 0) {
            counter = 0;
        }
    }

    public int[] KitchenDistribution(ArrayList<Order> order) {

        int[] timeDelivered = new int[order.size()];
        int idKeep = 0;
        int processingId = 0;

        do {

            for (int i = 0; i < order.size(); i++) {
                if (foukou.itFits(order.get(i))) {


                }


                for (int j = 0; j < order.get(processingId).getSmiles().length; j++)
                    System.out.println(order.get(processingId).getSmiles()[j]);


            }


            timeDelivered[idKeep] = 0;
        } while (order.size() > 0);

        return timeDelivered;
    }

    private boolean itFits(Order order) {
        return foukou.itFits(order) && pan.
    }

}
