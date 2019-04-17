package hw5.algorithms;

import hw5.Delivery;
import hw5.Foukou;
import hw5.Order;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Algorithm2 {

    public static ArrayList<Delivery> useArlgorithm2(ArrayList<Order> orders, int sizeFoukou, int xronoKarvouna, int numTigania, int tiganiaCapacity) {
       int[] tNeeded = new int[orders.size()];
       Foukou foukou = new Foukou(sizeFoukou);

        for(int i = 0 ; i < orders.size();i++){
            tNeeded = Foukou.timeCaclculator(orders.get(i),foukou);


        }


       int[][] a = new int[orders.size()][2];
       for (int i = 0;i<orders.size() ;i++){
           int b = Foukou.timeCaclculator(orders.get(i),new Foukou(xronosKarvouna),i);
          tNeeded.add(i,b);
           a[i][0] = b;
           a[i][1] = i;
       }

       tNeeded.sort(new Comparator<Integer>() {

           @Override
           public int compare(Integer o1, Integer o2) {
               if(o1<o2)
               return -1;
               else if(o1>o2)
                   return 1;
               else
                   return 0;
           }

       });

        for (int i = 0;i<orders.size() ;i++){
            tNeeded.add(i,Foukou.timeCaclculator(orders.get(i),new Foukou(xronosKarvouna),i));

        }



    }
}
