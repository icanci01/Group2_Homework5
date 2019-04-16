package hw5;

import hw5.algorithms.Algorithm1;
import hw5.algorithms.Algorithm2;
import hw5.algorithms.Algorithm3;
import hw5.algorithms.Algorithm4;

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
                break;

            case 2:
                deliveryList = Algorithm2.useArlgorithm2(ordersList);
                break;

            case 3:
                deliveryList = Algorithm3.useArlgorithm3(ordersList);
                break;

            case 4:
                deliveryList = Algorithm4.useArlgorithm4(ordersList);
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

        // STILL NEEDS EXCEPTION HANDLING
        // IF orders.txt contains negatives
        // If orders.txt contains characters / strings
        // If orders.txt torder > 300 ( order made after 23:00 )
        // If orders.txt treq > 360 ( order expected after 24:00 )
        //  ||
        // \  /
        //  \/


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
        We need to create the average typical time
         */
        //
        //
        //
        int sum = 0;
        for (int i = 0; i < deliveryList.size(); i++)
            sum += deliveryList.get(i).gettDelay();
        deliveryOutput.print(sum / totalNumberOfOrders + " ");
        //
        //
        //

        /*
        We need the number of pleased customers
         */
        int countPleasedCustomers = 0;
        for (int j = 0; j < deliveryList.size(); j++) {
            if (deliveryList.get(j).gettDelay() <= 0)
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
