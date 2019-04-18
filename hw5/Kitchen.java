package hw5;

import java.util.ArrayList;

public class Kitchen {
    public static int counter = -30;
    private Foukou foukou;
    private Pan pan;
    public static int processingId = 0;


    public Kitchen(Foukou foukou, int xronosKarvouna, Pan pan) {
        this.foukou = foukou;
        this.pan = pan;
        counter += xronosKarvouna;

        if (counter < 0) {
            counter = 0;
        }
    }

    private void foukouAdder(ArrayList<Order> order) {
        for (int j = 0; j < order.get(processingId).getSmiles().length; j++) {
            foukou.add(order.get(processingId).getSmiles()[j]);
            foukou.psise(order.get(processingId).getSmiles()[j]);
            if (j % 2 == 0 && j > 0) {
                foukou.add(order.get(processingId).getPites()[0].getP());
                foukou.psise(order.get(processingId).getPites()[0].getP());
            }
            processingId++;
        }
    }

    private int[] FoukouDistribution(ArrayList<Order> order) {
        processingId = 0;
        int[] timeDelivered = new int[order.size()];
        int idKeep = 0;


        do {

            for (int i = 0; i < order.size(); i++) {
                while (foukou.itFits(order.get(processingId))) {
                    timeDelivered[processingId] = Foukou.timeCaclculator(order.get(processingId), foukou)
                    this.foukouAdder(order);
                    boolean cantAdd = false;
                    int continueAdding = 0;

                    while (!foukou.isFull() && continueAdding < order.get(processingId).getSmiles().length) {
                        foukou.add(order.get(processingId).getSmiles()[continueAdding]);
                        foukou.psise(order.get(processingId).getSmiles()[continueAdding]);
                        continueAdding++;
                        if (foukou.isFull()) {
                            timeDelivered[processingId] =
                        }

                        if (foukou.isEmpty()) {


                        }


                    }
            }


            timeDelivered[idKeep] = 0;
        } while (order.size() > 0);

        return timeDelivered;
    }

    private boolean itFits(Order order) {
            return foukou.itFits(order) && pan.itFits(order);
    }

        private int[] PanDistribution (ArrayList < Order > order) {
            processingId = 0;
            return null;

        }

        public int[] getFinalTime (ArrayList < Order > order) {

            int[] foukouTime = this.FoukouDistribution(order);
            int[] friesTime = this.PanDistribution(order);

            int[] finalTime = new int[order.size()];
            for (int i = 0; i < order.size(); i++)
                finalTime[i] = Math.max(foukouTime[i], friesTime[i]);

            return finalTime;
        }

}
