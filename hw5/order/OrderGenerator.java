package hw5.order;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;


	import java.io.BufferedWriter;
	import java.io.File;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.util.Random;
	public class OrderGenerator {

		public String[][] generatePites(int n) {
			String[][] pites = new String[4][n]; 
			
			
			
			
			
			
		}

		public String[] generateTimeOfOrder(int n) {
			String[] s = new String[n];
			Random r = new Random();

			for (int i = 0; i < n; i++) {

				int time = (int) (r.nextGaussian() * 60 + 180);
				s[i] = Integer.toString(time) + ",";
			}
			return s;
		}

		public String[] generateWantedTime(String[] order, String[][] pites) {
			String[] req = new String[order.length];
			Random r = new Random();
			for (int i = 0; i < order.length; i++) {
				int time = (int) (Math.random() * 150 + 30) + Integer.parseInt(order[i]);
				if ((Integer.parseInt(pites[0][i]) + Integer.parseInt(pites[1][i]) + Integer.parseInt(pites[2][i])
						+ Integer.parseInt(pites[3][i])) > 10)
					do {
						time = (int) (Math.random() * 150 + 30) + Integer.parseInt(order[i]);

					} while (time < Integer.parseInt(order[i]) + 60);

				req[i] = Integer.toString(time) + ",";
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

			for (int i = 0; i < n; i++) {
				writer.write(i);

			}

		}
	}
	
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
