package hw5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class OrderGenerator {
    public static String[] generateIndividualPitesAndFries(int numOfThem) {
        String[] c = new String[5];
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
        c[0] = Integer.toString(numOfPp);
        c[1] = Integer.toString(numOfPc);
        c[2] = Integer.toString(numOfPs);
        c[3] = Integer.toString(numOfPm);
        c[4] = generateFries(numOfPp + numOfPc + numOfPs + numOfPm);
        return c;

    }

    public static String[][] generatePites(int n) {
        String[][] pites = new String[n][5];

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

    public static String generateFries(int fullNumOfPites) {
        String fries = "";
        double b = Math.random() * 100;
        if (b < 60) {
            fries = String.valueOf(fullNumOfPites);

        } else if (b < 95) {
            fries = "0";
        } else {
            fries = String.valueOf(fullNumOfPites * 2);
        }
        return fries;

    }

    public static String[] generateTimeOfOrder(int n) {
        String[] s = new String[n];
        Random r = new Random();

        for (int i = 0; i < n; i++) {

            int time = (int) (r.nextGaussian() * 60 + 180);
            s[i] = Integer.toString(time);
        }
        return s;
    }

    public static String[] generateWantedTime(String[] order, String[][] pites) {
        String[] req = new String[order.length];
        Random r = new Random();
        for (int i = 0; i < order.length; i++) {
            int time = (int) (Math.random() * 150 + 30) + Integer.parseInt(order[i]);
            if ((Integer.parseInt(pites[i][0]) + Integer.parseInt(pites[i][1]) + Integer.parseInt(pites[i][2])
                    + Integer.parseInt(pites[i][3])) > 10)
                do {
                    time = (int) (Math.random() * 150 + 30) + Integer.parseInt(order[i]);

                } while (time < Integer.parseInt(order[i]) + 60);

            req[i] = Integer.toString(time);
        }
        return req;
    }

    public static void main(String[] args) throws IOException {
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
        String[] orde = generateTimeOfOrder(n);
        String[][] pites = generatePites(n);
        String[] req = generateWantedTime(orde, pites);


        for (int i = 0; i < n; i++) {
            writer.write("<" + (i + 1) + ", " + orde[i] + ", " + req[i] + ", " + pites[i][0] + ", "
                    + pites[i][1] + ", " + pites[i][2] + ", " + pites[i][3] + ", " + pites[i][4] + ">\n");
            System.out.println("<" + (i + 1) + " ," + orde[i] + " ," + req[i] + " ," + pites[i][0] + " ,"
                    + pites[i][1] + " ," + pites[i][2] + " ," + pites[i][3] + " ," + pites[i][4] + ">");
        }
        writer.flush();
        writer.close();

//		PrintWriter orderOutput = null;
//		try {
//			orderOutput = new PrintWriter(new FileOutputStream("hw5\\order\\orders.txt"));
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//
//		assert orderOutput != null;
//		orderOutput.println("1000");
//		orderOutput.println("<1 75, 105, 1, 0, 0, 0, 1>");
//
//		orderOutput.close();
    }

}
