package hw5.order;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class OrderGenerator {

    public static void main(String[] args) {
        PrintWriter orderOutput = null;
        try {
            orderOutput = new PrintWriter(new FileOutputStream("hw5\\order\\orders.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        assert orderOutput != null;
        orderOutput.println("1000");
        orderOutput.println("<1  75, 105, 1, 0, 0, 0, 1>");

        orderOutput.close();
    }

}
