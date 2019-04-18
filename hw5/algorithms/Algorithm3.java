//package hw5.algorithms;
//
//import hw5.Delivery;
//import hw5.Foukou;
//import hw5.Order;
//
//import java.util.ArrayList;
//
//public class Algorithm3 {
//
//    public static ArrayList<Delivery> useArlgorithm3(ArrayList<Order> ordersList, int sizeFoukou, int xronoKarvouna, int numTigania, int tiganiaCapacity) {
//        int[] texec = new int[ordersList.size()];
//        double[] w = new double[ordersList.size()];
//        Foukou foukou = new Foukou(sizeFoukou);
//        ArrayList<Delivery> deliveryList = new ArrayList<>(ordersList.size());
//
//        for (int i = 0; i < ordersList.size(); i++) {
//
//
//            for (int j = 0; j < ordersList.size(); j++) {
//                texec[j] = Foukou.timeCaclculator(ordersList.get(j), foukou);
//                w[j] = (texec[j] - (ordersList.get(j).gettRequested() - Foukou.counter)) / texec[j];
//            }
//
//            double maxW = 0;
//            int position = 0;
//            for (int k = 0; k < w.length; k++) {
//                if (w[k] > maxW) {
//                    maxW = w[k];
//                    position = k;
//                }
//            }
//
//            Order process = new Order(ordersList.get(position));
//            int tDelivered = Foukou.foukouDistribution(process, foukou);
//            deliveryList.add(new Delivery(process.getIdNum(), process.gettOrder(),
//                    process.gettRequested(), tDelivered, process.getNumberOfPites(), process.getNumberOfFries()));
//
//
//            w[position] = 0;
//
//
//
//
//        }
//        System.out.println(deliveryList.size());
//        return deliveryList;
//    }
//
//}
