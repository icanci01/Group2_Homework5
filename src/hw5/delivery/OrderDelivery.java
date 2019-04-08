package src.hw5.delivery;

public class OrderDelivery {

    /*
         Το  πρόγραμμα  σας OrderDelivery δέχεται σαν παραμέτρουςτην χωρητικότητα
         της φουκούς (Μ)και το χρόνο προετοιμασίας των κάρβουνων (Τ),
         τον αριθμό των τηγανιών (Ν)και της χωρητικότητας τους (C)
         καθώς και το χώρο που καταλαμβάνουν οι σμίλες (x,y) και οι πίττες (z).
         java OrderDelivery 400 45 10 4 3 6 12 2 Θα ξεκινήσει το πρόγραμμα με
         μια φουκού μήκους 400 εκατοστώνπου χρειάζεται 45 λεπτά για να ανάψει,
         10 τηγάνια που χωρούν 4 μερίδες, σμίλες σουβλάκι των 3 εκατοστών,
         σμίλες  σεφταλιά  των  6  εκατοστών,πίττες  των  12  εκατοστών και
         κάνοντας χρήση του αλγόριθμού 2.
         */
    public static void main(String[] args) {

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


    }
}
