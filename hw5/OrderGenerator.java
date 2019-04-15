package hw5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class OrderGenerator {
    public static int[] generateIndividualPitesAndFries(int numOfThem) {
        int[] c = new int[5];
        int numOfPp = 0;
        int numOfPc = 0;
        int numOfPs = 0;
        int numOfPm = 0;

        for (int i = 0; i < numOfThem; i++) {
            double a = Math.random() * 100;
            if (a < 25) {
                numOfPp++;

            } else if (a < 50) {
                numOfPc++;
            } else if (a < 75) {
                numOfPs++;
            } else {
                numOfPm++;
            }

        }
        c[0] = (numOfPp);
        c[1] = (numOfPc);
        c[2] = (numOfPs);
        c[3] = (numOfPm);
        c[4] = generateFries(numOfPp + numOfPc + numOfPs + numOfPm);
        return c;

    }

    public static int[][] generatePites(int n) {
        int[][] pites = new int[n][5];

        int fullNumOfPites = 0;

        for (int i = 0; i < n; i++) {
            double a = Math.random() * 100;
            if (a < 20) {
                fullNumOfPites = 1;

            } else if (a < 55) {
                fullNumOfPites = 2;
            } else if (a < 65) {
                fullNumOfPites = 3;
            } else if (a < 85) {
                fullNumOfPites = 4;
            } else {
                fullNumOfPites = (int) (Math.random() * 15) + 5;
            }

            pites[i] = generateIndividualPitesAndFries(fullNumOfPites);

        }
        return pites;
    }

    public static int generateFries(int fullNumOfPites) {
        int fries = 0;
        double b = Math.random() * 100;
        if (b < 60) {
            fries = (fullNumOfPites);

        } else if (b < 95) {
            fries = 0;
        } else {
            fries = (fullNumOfPites * 2);
        }
        return fries;

    }

    public static int[] generateTimeOfOrder(int n) {
        int[] s = new int[n];
        Random r = new Random();

        for (int i = 0; i < n; i++) {

            int time = (int) (r.nextGaussian() * 60 + 180);
            s[i] = (time);
        }
        return s;
    }


    public static int[] generateWantedTime(int[] order, int[][] pites) {
        int[] req = new int[order.length];
        Random r = new Random();
        for (int i = 0; i < order.length; i++) {
            int time = (int) (Math.random() * 150 + 30) + (order[i]);
            if (((pites[i][0]) + (pites[i][1]) + (pites[i][2])
                    + (pites[i][3])) > 10)
                do {
                    time = (int) (Math.random() * 150 + 30) + (order[i]);

                } while (time > 360 || time < (order[i]) + 60);

            req[i] = (time);
        }
        return req;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("testing");
        int n = 0;
        try {
            n = Integer.parseInt(args[0]);

        } catch (NumberFormatException e) {
            System.out.println("args isn't a num");
            System.exit(0);
        }
        if (n <= 0) {
            System.out.println("En evales thetiko arithmo");
            System.exit(0);
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter("orders.txt"));
        writer.write(n + "\n");
        int[] orde = generateTimeOfOrder(n);
        int[][] pites = generatePites(n);
        int[] req = generateWantedTime(orde, pites);
        List<Order> orders = new ArrayList<Order>();
        

        for (int i = 0; i < n; i++) {
            orders.add(new Order((i + 1), orde[i], req[i], pites[i][0], pites[i][1], pites[i][2], pites[i][3], pites[i][4]));
        	
        }
        Collections.sort(orders);
        Order[] finalOrders  = orders.toArray(new Order[n]);
 
        
        	 for (int i = 0; i < n; i++) {
        		 writer.write(finalOrders[i].toString() + "\n");
        		 System.out.println(finalOrders[i].toString() + "\n");
        	 }
        	 

    
        
        writer.flush();
        writer.close();

    }

}
