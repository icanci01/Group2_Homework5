package hw5;

import hw5.graphics.LineChartTimeOrder;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * A class for Generating an integer amount of orders by the argument line. Each
 * order is sorted by the time it was ordered.For more info on the their
 * appropriate times and probabilities of each order's items and times please
 * look @see They are printed on the screen for checking and also save at a
 * local text file(orders.txt)
 *
 * @author Group2(Canciu Ionut - Cristian, George Christoforou, Panikos Christou)
 * @version 1.0
 * @see https://piazza-resources.s3.amazonaws.com/jqntyc7qdj77hk/ju2alvgoihp443/HW5Spring19.pdf?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=ASIAR6AWVCBXVMJ5WK5O%2F20190416%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20190416T154431Z&X-Amz-Expires=3600&X-Amz-SignedHeaders=host&X-Amz-Security-Token=AgoJb3JpZ2luX2VjEDsaCXVzLWVhc3QtMSJHMEUCIQD%2Fjzdz9HQiKU9wUZF81h9P%2BF9WNCwYOJdA9dWtMUzWFwIgUHlySvjdO4isf8kMGtyYCp5ejt5pU64gcHSLJN4IQJ8q2gMIFBAAGgwxMzMxOTE1MDM5ODMiDGdEwQnRp%2FA20oul8Cq3A%2BE7Ir229Pu9Qo2oDZCMFLPldeYMaPXWEcVJPNRNVJpbkC70kLAjqMh2e%2F22ORg3KvU5iyIs0cVMlgFYuW2e%2FcIcyFxGMhiZRgB7uq5oO0g6cql2EvMLeeU78PmgjMdyEYhwGNQ6mZSuwTmRmwVCXVfX2pbA7CDz1%2FwMPjghVHBJ46IpRt3Q7Uf2ylmmNN1wtgzGzVbtaEngD3ynhf9wXM0VtdfZWgViYRkVw%2FAsBEEE%2FJ4hbN5J03H0DmlB%2BnYv7C3VO%2BTA0wz1eqjgmle4YcECFN49UdOyZO1wjVVCgm7IJ1dDRPz%2BUAa2RmVOeu%2BEfA5CQ8OQ2EHHNKnngps9OgRl4F79y1crgLRXjjRetMszjqDipv%2BfDeOITpsTTpcLCLXB4Wyh3XAJFbusooE2H%2BSqCTI3KCGbs53k5S9ht%2BgjSWq7YbqM3pOxnvThDrEBJ4ee%2BS38yNlt8QoQYLGzAXLfwvOOjKof0Nc02hxUbVhaZyEIIJ5QqcxknmVKzm%2BPE1%2BvPZVZdfxpN9nrDFGG8LSYY6%2BmeEbbiOchNkyB8U%2B3jqXrgGum7VdsJOSYHM4jvpawQVBxOCww%2FOTW5QU6tAHpfqe%2B7EbdsFUA%2B%2FkimEcU6oTTveojQ1iesad146zeXXaTP3TAVxwH2fAoYEASk%2Fnu2gh2%2Fck2aR3%2BekxdQ8qzbn9gapRgWjXssyvIrYRz5kafwBe3U3gf5kS%2BY0LPO%2BGtqcbM8Slj8fKgi28ADXEhvjHzqtNPXHjx7BjkVjaFOAUQCra31dvV1Fl4MJ%2BcWjXdxpAd0zhrWO9ML8cLz3%2FC1AA%2Bn5momOTh1bhMjmdHtn%2FzTuI%3D&X-Amz-Signature=739432a410675654bcc35edcc10c9a8b5225f0c2fffb76fddf35a31502cbf85a
 * @since 16/04/19
 */
public class OrderGenerator {
    /**
     * generates the amount of each pita by their total and at the same time the
     * total fries.
     *
     * @return an int[5] with each [] being numOfPp numOfPc numOfPs numOfPm
     * Fries
     */
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

    /**
     * The general method that generates the sum of the sum pites we want to
     * generate in this orders and fries and employs
     * generateIndividualPitesAndFries to generate to generate their individual
     * nums.
     *
     * @param n the total orders i want to generate
     * @return int[n][5] each orders numOfPp numOfPc numOfPs numOfPm Fries
     */
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

    /**
     * method that chooses if each pitta is accompanied by 1 or 2 or 3 or none
     * merides of fries
     *
     * @param fullNumOfPites
     * @return int sum of all fries
     */
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

    /**
     * method that generates each orders time that was ordered by utilizing
     * normal distribution with the stores working hours
     *
     * @param n sum of all orders to generate
     * @return int sum of all fries
     */
    public static int[] generateTimeOfOrder(int n) {
        int[] s = new int[n];
        Random r = new Random();
        int time = 0;
        for (int i = 0; i < n; i++) {
            do {
                time = (int) (r.nextGaussian() * 60 + 180);
            } while (time > 300 || time < 0);
            /** cap it because we will be unable to deliver further than that */
            s[i] = (time);
        }
        return s;
    }

    /**
     * method that generates each requested time that by getting its timeOrdered
     * and beig 30 - 3 hours later.
     *
     * @param n sum of all orders to generate
     * @return int sum of all fries
     */

    public static int[] generateWantedTime(int[] tOrdered, int[][] pites) {
        int[] req = new int[tOrdered.length];
        Random r = new Random();
        for (int i = 0; i < tOrdered.length; i++) {
            int time = (int) (Math.random() * 150 + 30) + (tOrdered[i]);
            if (((pites[i][0]) + (pites[i][1]) + (pites[i][2]) + (pites[i][3])) > 10)
                do {
                    time = (int) (Math.random() * 150 + 30) + (tOrdered[i]);
                } while (time > 360 || time < (tOrdered[i]) + 60);
            /** cap it because we will be unable to deliver further than that */
            if (time > 360)
                time = 360;
            req[i] = (time);
        }
        return req;
    }

    /**
     * Create the list of random generated orders
     *
     * @param total number of orders
     */
    private static ArrayList<Order> makeListOfOrders(int numberOfOrders) {

        ArrayList<Order> order = new ArrayList<Order>(numberOfOrders);
        int[] tOrdered = generateTimeOfOrder(numberOfOrders);
        int[][] pites = generatePites(numberOfOrders);
        int[] tRequested = generateWantedTime(tOrdered, pites);

        for (int i = 0; i < numberOfOrders; i++) {
            order.add(new Order((i + 1), tOrdered[i], tRequested[i], pites[i][0], pites[i][1], pites[i][2], pites[i][3],
                    pites[i][4]));
        }
        Collections.sort(order);

        for (int i = 0; i < numberOfOrders; i++) {
            order.get(i).setIdNum(i + 1);
        }
        return order;
    }

    /**
     * Creates the final output "orders.txt"
     *
     * @param orderList the final list of orders
     */
    private static void makeOutputFile(ArrayList<Order> orderList, int numberOfOrders) {

        PrintWriter ordersOutput = null;
        try {
            ordersOutput = new PrintWriter(new FileOutputStream("orders.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("FATAL ERROR");
            System.exit(0);
        }
        LineChartTimeOrder.drawDelay(orderList);

        ordersOutput.println(numberOfOrders);
        Order[] finalOrders = orderList.toArray(new Order[numberOfOrders]);
        for (int i = 0; i < numberOfOrders; i++) {
            ordersOutput.println(finalOrders[i].toString());
            System.out.println(finalOrders[i].toString() + "\n");
        }

        ordersOutput.flush();
        ordersOutput.close();

    }


    /**
     * Generator of random orders
     * <p>
     * The generator of orders. It uses the arsg[0] for the number of total orders to be generated
     * this read. It then created the random orders and sorts them based on the time orders
     * were "requested".
     * Prints the orders on screen and also prints a graph showing the times created for the
     * orders.
     */
    public static void main(String[] args) {
        /*
         * First of all we have to initialize the parameter given within the
         * command line.
         *
         * Cases where the program might terminate with an error message: 1) The
         * parameter given is negative or 0. 2) The parameter given is a
         * character or a string 2) There are more parameters than expected.
         */
        int N = 0; // Number of orders to be generated
        try {
            if (Integer.parseInt(args[0]) == 0 || Integer.parseInt(args[0]) < 0)
                throw new IllegalArgumentException("Argument " + args[0] + " given in command line is illegal!");

            N = Integer.parseInt(args[0]);

        } catch (ArrayIndexOutOfBoundsException e1) {
            System.out.println("Not enough command line arguments given!");
            System.err.println(
                    "Arguments given on command line " + e1.getLocalizedMessage() + " !\nThere should have been 8 !");
            System.out.println("Program will exit...");
            System.exit(0);
        } catch (IllegalArgumentException e2) {
            System.out.println("Wrong arguments given!");
            System.err.println(e2.getLocalizedMessage());
            System.out.println("Program will exit...");
            System.exit(0);
        }

        if (args.length > 1) {
            System.out.println("Please check your command line arguments!");
            System.err.println("Arguments given on command line " + args.length + " !\nThere should have been 1 !");
            System.out.println("Program will exit...");
            System.exit(0);
        }

        /*
         * At this point of the code the parameter given within the command line
         * is correct, the program will continue with creating a list of orders
         * randomly generated.
         */
        ArrayList<Order> ordersList = makeListOfOrders(N);

        /*
         * If there are no errors, then we are ready to create the output file
         * "orders.txt"
         */
        makeOutputFile(ordersList, N);
    }
}
