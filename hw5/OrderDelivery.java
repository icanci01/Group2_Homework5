package hw5;
/*

 A class for generating the output file of the deliveries informations
@author Group2(Canciu Ionut - Cristian, George Christoforou, Panikos Christou)
* @version 1.0
* @see https://piazza-resources.s3.amazonaws.com/jqntyc7qdj77hk/ju2alvgoihp443/HW5Spring19.pdf?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=ASIAR6AWVCBXVMJ5WK5O%2F20190416%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20190416T154431Z&X-Amz-Expires=3600&X-Amz-SignedHeaders=host&X-Amz-Security-Token=AgoJb3JpZ2luX2VjEDsaCXVzLWVhc3QtMSJHMEUCIQD%2Fjzdz9HQiKU9wUZF81h9P%2BF9WNCwYOJdA9dWtMUzWFwIgUHlySvjdO4isf8kMGtyYCp5ejt5pU64gcHSLJN4IQJ8q2gMIFBAAGgwxMzMxOTE1MDM5ODMiDGdEwQnRp%2FA20oul8Cq3A%2BE7Ir229Pu9Qo2oDZCMFLPldeYMaPXWEcVJPNRNVJpbkC70kLAjqMh2e%2F22ORg3KvU5iyIs0cVMlgFYuW2e%2FcIcyFxGMhiZRgB7uq5oO0g6cql2EvMLeeU78PmgjMdyEYhwGNQ6mZSuwTmRmwVCXVfX2pbA7CDz1%2FwMPjghVHBJ46IpRt3Q7Uf2ylmmNN1wtgzGzVbtaEngD3ynhf9wXM0VtdfZWgViYRkVw%2FAsBEEE%2FJ4hbN5J03H0DmlB%2BnYv7C3VO%2BTA0wz1eqjgmle4YcECFN49UdOyZO1wjVVCgm7IJ1dDRPz%2BUAa2RmVOeu%2BEfA5CQ8OQ2EHHNKnngps9OgRl4F79y1crgLRXjjRetMszjqDipv%2BfDeOITpsTTpcLCLXB4Wyh3XAJFbusooE2H%2BSqCTI3KCGbs53k5S9ht%2BgjSWq7YbqM3pOxnvThDrEBJ4ee%2BS38yNlt8QoQYLGzAXLfwvOOjKof0Nc02hxUbVhaZyEIIJ5QqcxknmVKzm%2BPE1%2BvPZVZdfxpN9nrDFGG8LSYY6%2BmeEbbiOchNkyB8U%2B3jqXrgGum7VdsJOSYHM4jvpawQVBxOCww%2FOTW5QU6tAHpfqe%2B7EbdsFUA%2B%2FkimEcU6oTTveojQ1iesad146zeXXaTP3TAVxwH2fAoYEASk%2Fnu2gh2%2Fck2aR3%2BekxdQ8qzbn9gapRgWjXssyvIrYRz5kafwBe3U3gf5kS%2BY0LPO%2BGtqcbM8Slj8fKgi28ADXEhvjHzqtNPXHjx7BjkVjaFOAUQCra31dvV1Fl4MJ%2BcWjXdxpAd0zhrWO9ML8cLz3%2FC1AA%2Bn5momOTh1bhMjmdHtn%2FzTuI%3D&X-Amz-Signature=739432a410675654bcc35edcc10c9a8b5225f0c2fffb76fddf35a31502cbf85a
* @since 16/04/19
        */
import hw5.algorithms.Algorithm1;
import hw5.algorithms.Algorithm2;
import hw5.algorithms.Algorithm3;
import hw5.algorithms.Algorithm4;
import hw5.graphics.LineChartDelay;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class OrderDelivery {

    public static void main(String[] args) {

        /*
        First of all we have to initialize the parameters used for the OrderDelivery
        given wit int sizeChickenPork, int sizeSheftalia, int sizePitahin the command line.

        Cases where the program might terminate with an error message :
             1) Any of the arguments given are either equal to 0 or a negative number.
             2) There are not enough parameters given within the command line.
             3) There are more parameters given within the command line.
             4) There are characters or strings given within the command line.
             5) Algorithm we are trying to use is not on the list of algorithms (algorithmUsed != [1,4]).

         */
        int M = 0, T = 0, N = 0, C = 0, x = 0, y = 0, z = 0, algorithmUsed = 0;
        try {

            for (String arg : args)
                if (Integer.parseInt(arg) == 0 || Integer.parseInt(arg) < 0)
                    throw new IllegalArgumentException("Argument " + arg + " given on command line is illegal!");

            M = Integer.parseInt(args[0]); //xwritikotita tis foukous
            T = Integer.parseInt(args[1]); //xronos proetimasias karvounwn
            N = Integer.parseInt(args[2]); //arithmo tiganiwn
            C = Integer.parseInt(args[3]); //xwritikwtita tiganiwn
            x = Integer.parseInt(args[4]); //xwro smilas souvlaki (xoirino/kotopoulo)
            y = Integer.parseInt(args[5]); //xwro smilas sieftalies
            z = Integer.parseInt(args[6]); //xwro gia pittes
            algorithmUsed = Integer.parseInt(args[7]); //algorithmos pou tha xrisimopoihsoume

        } catch (ArrayIndexOutOfBoundsException e1) {
            System.out.println("Not enough command line arguments given!");
            System.err.println("Arguments given on command line " + e1.getLocalizedMessage() + " !\nThere should have been 8 !");
            System.out.println("Program will exit...");
            System.exit(0);

        } catch (IllegalArgumentException e2) {
            System.out.println("Wrong arguments given!");
            System.err.println(e2.getLocalizedMessage());
            System.out.println("Program will exit...");
            System.exit(0);
        }

        if (args.length > 8) {
            System.out.println("Please check your command line arguments!");
            System.err.println("Arguments given on command line " + args.length + " !\nThere should have been 8 !");
            System.out.println("Program will exit...");
            System.exit(0);
        }

        if (algorithmUsed > 4) {
            System.out.println("Wrong algorithm used!");
            System.err.println("Algorithm given within command line " + algorithmUsed + " !\nYou can only use algorithms between 1 and 4 !");
            System.out.println("Program will exit...");
            System.exit(0);
        }

        /*
        At this point of the code if all parameters given within the command line are correct,
        the program will continue with creating the list of Orders from the "orders.txt".
        */
        ArrayList<Order> ordersList = makeListOfOrders(x, y, z);

        /*
        Now we are ready to use selected algorithm to create the list of the deliveries made
        in order to process them for the output file "deliveries.txt"
         */
        ArrayList<Delivery> deliveryList = null;
        switch (algorithmUsed) {
            case 1:
                deliveryList = Algorithm1.useArlgorithm1(ordersList, M, T, N, C);
                LineChartDelay.drawDelay(deliveryList);
                break;

            case 2:
                deliveryList = Algorithm2.useArlgorithm2(ordersList, M, T, N, C);
                LineChartDelay.drawDelay(deliveryList);
                break;

            case 3:
                deliveryList = Algorithm3.useArlgorithm3(ordersList, M, T, N, C);
                LineChartDelay.drawDelay(deliveryList);
                break;

            case 4:
                deliveryList = Algorithm4.useArlgorithm4(ordersList, M, T, N, C);
                LineChartDelay.drawDelay(deliveryList);
                break;
        }

        /*
        At this point of the code we are ready to create the output file "deliveries.txt"
        where we will save the deliveries made using the method makeOutputFile
        */
        makeOutputFile(ordersList.size(), deliveryList);

    }

    private static ArrayList<Order> makeListOfOrders(int x, int y, int z) {
        /*
        Create the stream for the input file "orders.txt".
        In case the file doesn't exist, the program will terminate with an error message.
         */
        Scanner ordersInput = null;
        try {
            ordersInput = new Scanner(new FileInputStream("orders.txt"));
        } catch (FileNotFoundException e) {
            System.err.println("File \"orders.txt\" not found !");
            System.out.println("Program will exit...");
            System.exit(0);
        }

        /*
        Get the total number of orders from first the first line of "orders.txt"
        and create the list of all orders
         */
        int totalNumberOfOrders = ordersInput.nextInt();
        ArrayList<Order> listOfOrders = new ArrayList<>();
        // Move to the next line
        ordersInput.nextLine();

        for (int i = 0; i < totalNumberOfOrders; i++) {
            String orderAsLine = ordersInput.nextLine();
            String[] orderAsIndividualData = (orderAsLine.split(", "));

            if (orderAsIndividualData.length == 8) {


                orderAsIndividualData[0] = orderAsIndividualData[0].replace("<", "");
                orderAsIndividualData[7] = orderAsIndividualData[7].replace(">", "");
                int[] data = new int[8];

                //Needs exception handling if chars or string are found in orders.txt
                for (int j = 0; j < orderAsIndividualData.length; j++) {
                    data[j] = Integer.parseInt(orderAsIndividualData[j]);
                    System.out.print(data[j] + "\t");
                }
                System.out.println();

                listOfOrders.add(new Order(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], x, y, z));
            } else if (orderAsIndividualData.length < 8) {
                System.err.println("Order with num " + i + " contains less parameters!");
            } else
                System.err.println("Order with num " + i + " contains more parameters!");
        }
        ordersInput.close();
        return listOfOrders;
    }

    private static void makeOutputFile(int totalNumberOfOrders, ArrayList<Delivery> deliveryList) {
        /*
        First we create the output stream for the output file "deliveries.txt"
         */
        PrintWriter deliveryOutput = null;
        try {
            deliveryOutput = new PrintWriter(new FileOutputStream("deliveries.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("FATAL ERROR");
            System.exit(0);
        }

        // Print the total number of orders
        deliveryOutput.print(totalNumberOfOrders + " ");

        /*
        We need to create the average time
         */

        int sum = 0;
        for (int i = 0; i < deliveryList.size(); i++)
            sum += deliveryList.get(i).gettDelay();
        deliveryOutput.print(sum / totalNumberOfOrders + " ");
        /*
        We need the number of pleased customers
         */
        int countPleasedCustomers = 0;
        for (int j = 0; j < deliveryList.size(); j++) {
            if (deliveryList.get(j).gettDelay() <= 0 && deliveryList.get(j).gettDelay() > -30)
                countPleasedCustomers++;
        }

        deliveryOutput.println(countPleasedCustomers);

        /*
        Here we are ready to print the data from the deliveryList
         */

        for (int i = 0; i < deliveryList.size(); i++) {
            deliveryOutput.println(deliveryList.get(i));
        }

        deliveryOutput.flush();
        deliveryOutput.close();
    }

}
