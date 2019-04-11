package hw5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OrderDelivery {

    public static void main(String[] args) {

        /*
        First of all we have to initialize the parameters used for the OrderDelivery
        given within the command line.

        Cases where the program might terminate with an error message :
             1) Any of the arguments given are either equal to 0 or a negative number.
             2) There are not enough parameters given within the command line.
             3) There are more parameters given within the command line.
             4) There are characters or strings given within the command line
             5) Algorithm we are trying to use is not on the list of algorithms (algorithmUsed != [1,4])

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
        the program will continue with creating the list of Orders from the "orders.txt"

         In case the file "orders.txt" doesn't exist, the program will terminate with an error message.
         */
        Scanner ordersInput = null;
        try {

            ordersInput = new Scanner(new FileInputStream("orders.txt"));

        } catch (FileNotFoundException e) {
            System.err.println("File \"orders.txt\" not found !");
            System.out.println("Program will exit...");
            System.exit(0);
        }


        System.out.println(ordersInput.nextInt());

//        PrintWriter deliveryOutput = null;
//        try {
//            deliveryOutput = new PrintWriter(new FileOutputStream("hw5\\delivery\\deliveries.txt"));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }


    }
}
