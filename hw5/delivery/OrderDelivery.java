package hw5.delivery;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class OrderDelivery {

    public static void main(String[] args) {

        /*
        First of all we have to initialize the parameters used for the OrderDelivery
        from the command line.
        In case there are not enough parameters given, the program will exit.
        Also in case we give more parameters, an error message saying "Please check your parameters"
        will be shown and the program will also exit.
        If all parameters are correct then the program will move on creating the List of Orders from
        the "orders.txt" file.
         */
        try {
            int M = Integer.parseInt(args[0]); //xwritikotita tis foukous
            int T = Integer.parseInt(args[1]); //xronos proetimasias karvounwn
            int N = Integer.parseInt(args[2]); //arithmo tiganiwn
            int C = Integer.parseInt(args[3]); //xwritikwtita tiganiwn
            int x = Integer.parseInt(args[4]); //xwro smilas souvlaki
            int y = Integer.parseInt(args[5]); //xwro smilas sieftalies
            int z = Integer.parseInt(args[6]); //xwro gia pittes
            int algorithmUsed = Integer.parseInt(args[7]); //algorithmos pou xrisimopoihsame

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Not enough arguments given!");
            System.out.println("Program will exit...");
            System.exit(0);
        }

        if (args.length > 8) {
            System.out.println("Please check your parameters!");
            System.out.println("Program will exit...");
            System.exit(0);
        }

        FileInputStream ordersFile;
        Scanner ordersInput = null;
        try {
            ordersFile = new FileInputStream("hw5\\order\\orders.txt");
            ordersInput = new Scanner(ordersFile);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);
        }

        System.out.println(ordersInput.nextInt());

        PrintWriter deliveryOutput = null;
        try {
            deliveryOutput = new PrintWriter(new FileOutputStream("hw5\\delivery\\deliveries.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        assert deliveryOutput != null;
        deliveryOutput.println("1000");

        System.out.println("TESTING");

    }
}
