//package hw5.algorithms;
//
//import hw5.Delivery;
//import hw5.Foukou;
//import hw5.Order;
//
//import java.util.ArrayList;
//
//public class Algorithm2 {
//
//    public static ArrayList<Delivery> useArlgorithm2(ArrayList<Order> ordersList, int sizeFoukou, int xronoKarvouna, int numTigania, int tiganiaCapacity) {
//        int[] texec = new int[ordersList.size()];
//        Foukou foukou = new Foukou(sizeFoukou);
//        ArrayList<Delivery> deliveryList = new ArrayList<>(ordersList.size());
//
//        for (int i = 0; i < ordersList.size(); i++) {
//
//
//            for (int j = 0; j < ordersList.size(); j++)
//                texec[j] = Foukou.timeCaclculator(ordersList.get(j), foukou);
//
//
//            int minTExec = 0;
//            int position = 0;
//            for (int k = 0; k < texec.length; k++) {
//                if (texec[k] < minTExec) {
//                    minTExec = texec[k];
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
//            texec[position] = Integer.MAX_VALUE;
//
//
//        }
//        System.out.println(deliveryList.size());
//        return deliveryList;
//    }
//
//}
