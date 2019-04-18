package hw5;
/*
A class that generates the orders indivitually that later will go to the orderlist with the orders of the day

 @author Group2(Canciu Ionut - Cristian, George Christoforou, Panikos Christou)
        * @version 1.0
        * @see https://piazza-resources.s3.amazonaws.com/jqntyc7qdj77hk/ju2alvgoihp443/HW5Spring19.pdf?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=ASIAR6AWVCBXVMJ5WK5O%2F20190416%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20190416T154431Z&X-Amz-Expires=3600&X-Amz-SignedHeaders=host&X-Amz-Security-Token=AgoJb3JpZ2luX2VjEDsaCXVzLWVhc3QtMSJHMEUCIQD%2Fjzdz9HQiKU9wUZF81h9P%2BF9WNCwYOJdA9dWtMUzWFwIgUHlySvjdO4isf8kMGtyYCp5ejt5pU64gcHSLJN4IQJ8q2gMIFBAAGgwxMzMxOTE1MDM5ODMiDGdEwQnRp%2FA20oul8Cq3A%2BE7Ir229Pu9Qo2oDZCMFLPldeYMaPXWEcVJPNRNVJpbkC70kLAjqMh2e%2F22ORg3KvU5iyIs0cVMlgFYuW2e%2FcIcyFxGMhiZRgB7uq5oO0g6cql2EvMLeeU78PmgjMdyEYhwGNQ6mZSuwTmRmwVCXVfX2pbA7CDz1%2FwMPjghVHBJ46IpRt3Q7Uf2ylmmNN1wtgzGzVbtaEngD3ynhf9wXM0VtdfZWgViYRkVw%2FAsBEEE%2FJ4hbN5J03H0DmlB%2BnYv7C3VO%2BTA0wz1eqjgmle4YcECFN49UdOyZO1wjVVCgm7IJ1dDRPz%2BUAa2RmVOeu%2BEfA5CQ8OQ2EHHNKnngps9OgRl4F79y1crgLRXjjRetMszjqDipv%2BfDeOITpsTTpcLCLXB4Wyh3XAJFbusooE2H%2BSqCTI3KCGbs53k5S9ht%2BgjSWq7YbqM3pOxnvThDrEBJ4ee%2BS38yNlt8QoQYLGzAXLfwvOOjKof0Nc02hxUbVhaZyEIIJ5QqcxknmVKzm%2BPE1%2BvPZVZdfxpN9nrDFGG8LSYY6%2BmeEbbiOchNkyB8U%2B3jqXrgGum7VdsJOSYHM4jvpawQVBxOCww%2FOTW5QU6tAHpfqe%2B7EbdsFUA%2B%2FkimEcU6oTTveojQ1iesad146zeXXaTP3TAVxwH2fAoYEASk%2Fnu2gh2%2Fck2aR3%2BekxdQ8qzbn9gapRgWjXssyvIrYRz5kafwBe3U3gf5kS%2BY0LPO%2BGtqcbM8Slj8fKgi28ADXEhvjHzqtNPXHjx7BjkVjaFOAUQCra31dvV1Fl4MJ%2BcWjXdxpAd0zhrWO9ML8cLz3%2FC1AA%2Bn5momOTh1bhMjmdHtn%2FzTuI%3D&X-Amz-Signature=739432a410675654bcc35edcc10c9a8b5225f0c2fffb76fddf35a31502cbf85a
        * @since 16/04/19
        */
import hw5.menu.Fries;
import hw5.menu.Pita;
import hw5.menu.Smiles.Chicken;
import hw5.menu.Smiles.Pork;
import hw5.menu.Smiles.Sheftalia;
import hw5.menu.pitesSouvlakia.*;

/*
The constructor of the Class Order that implements Comparable

 */
public class Order implements Comparable {

    private int idNum = 0;
    private int tOrder;
    private int tRequested;
    private PitaSouvlaki[] pites;
    private PorkPitaSouvlaki[] porkPites;
    private ChickenPitaSouvlaki[] chickenPites;
    private MixPitaSouvlaki[] mixPites;
    private SheftaliaPitaSouvlaki[] sheftaliaPites;
    private Fries[] fries;
    private int sizeChickenPork;
    private int sizeSheftalia;
    private int sizePita;

    public Order(int individualOrderID, int tOrder, int tRequested, int numberPorkPites, int numberChickenPites, int numberSheftaliaPites, int numberMixPites, int numberFries, int sizeChickenPork, int sizeSheftalia, int sizePita) {
        idNum = individualOrderID;
        this.tOrder = tOrder;
        this.tRequested = tRequested;
        int total;
        this.sizeChickenPork = sizeChickenPork;
        this.sizeSheftalia = sizeSheftalia;
        this.sizePita = sizePita;
        try {
            if (numberPorkPites < 0 || numberChickenPites < 0 || numberSheftaliaPites < 0 || numberMixPites < 0 || numberFries < 0)
                throw new Exception("Wrong"); // Needs improvement
            porkPites = generatePorkPites(numberPorkPites);
            chickenPites = generateChickenPites(numberChickenPites);
            sheftaliaPites = generateSheftaliaPites(numberSheftaliaPites);
            mixPites = generateMixPites(numberMixPites);
            total = numberChickenPites + numberMixPites + numberPorkPites + numberSheftaliaPites;
            pites = new PitaSouvlaki[total];
            fries = generateFries(numberFries);
        } catch (Exception e) {
            System.out.println("Error Occured, Order can't be created");
            System.exit(0);
        }

    }

    public Order(int individualOrderID, int tOrder, int tRequested, int numberPorkPites, int numberChickenPites, int numberSheftaliaPites, int numberMixPites, int numberFries) {
        idNum = individualOrderID;
        this.tOrder = tOrder;
        this.tRequested = tRequested;
        int total;
        this.sizeChickenPork = 0;
        this.sizeSheftalia = 0;
        this.sizePita = 0;
        try {
            if (numberPorkPites < 0 || numberChickenPites < 0 || numberSheftaliaPites < 0 || numberMixPites < 0 || numberFries < 0)
                throw new Exception("Wrong"); // Needs improvement
            porkPites = generatePorkPites(numberPorkPites);
            chickenPites = generateChickenPites(numberChickenPites);
            sheftaliaPites = generateSheftaliaPites(numberSheftaliaPites);
            mixPites = generateMixPites(numberMixPites);
            total = numberChickenPites + numberMixPites + numberPorkPites + numberSheftaliaPites;
            pites = new PitaSouvlaki[total];
            fries = generateFries(numberFries);
        } catch (Exception e) {
            System.out.println("Error Occured, Order can't be created");
            System.exit(0);
        }

    }

    /*
    The clone method for each order
     */
    public Order(Order a) {
        idNum = new Integer(a.idNum);
        this.tOrder = new Integer(a.tOrder);
        this.tRequested = new Integer(a.tRequested);
        this.porkPites = a.porkPites.clone();
        this.chickenPites = a.chickenPites.clone();
        this.sheftaliaPites = a.sheftaliaPites.clone();
        this.mixPites = a.mixPites.clone();
        this.fries = a.fries.clone();


    }

    /*
    This method the number of pittes of each order
     */
    public int getNumberOfPites() {
        return this.chickenPites.length + this.porkPites.length + this.mixPites.length + this.sheftaliaPites.length;
    }

    /*
    Sets the id of each order
     */
    public void setIdNum(int newId) {
        this.idNum = newId;
    }

    /*
    Returns the number of fries of the order
     */
    public int getNumberOfFries() {
        return this.fries.length;
    }

    /*
    Return an arrau of PitaSouvlaki that are all the pites of each order
     */
    public PitaSouvlaki[] getPites() {
        int num = getNumberOfPites();
        PitaSouvlaki[] pites = new PitaSouvlaki[num];
        for (int i = 0; i < chickenPites.length; i++) {
            pites[i] = new ChickenPitaSouvlaki(new Chicken(sizeChickenPork), new Chicken(sizeChickenPork), new Pita(sizePita));
        }
        for (int i = chickenPites.length; i < chickenPites.length + porkPites.length; i++) {
            pites[i] = new PorkPitaSouvlaki(new Pork(sizeChickenPork), new Pork(sizeChickenPork), new Pita(sizePita));
        }
        for (int i = chickenPites.length + porkPites.length; i < chickenPites.length + porkPites.length + sheftaliaPites.length; i++) {
            pites[i] = new SheftaliaPitaSouvlaki(new Sheftalia(sizeSheftalia), new Sheftalia(sizeSheftalia), new Pita(sizePita));
        }
        for (int i = chickenPites.length + porkPites.length + sheftaliaPites.length; i < pites.length; i++) {
            pites[i] = new MixPitaSouvlaki(new Sheftalia(sizeSheftalia), new Pork(sizeChickenPork), new Pita(sizePita));
        }
        return pites;
    }

    /*
    Return an array of Fries to get access to the object Fries later
     */
    public Fries[] getFries() {
        return fries;
    }

    /*
    Helps the getPites method
     */
    private PorkPitaSouvlaki[] generatePorkPites(int totalNumberOfPites) {
        PorkPitaSouvlaki[] pork = new PorkPitaSouvlaki[totalNumberOfPites];

        return pork;
    }

    /*
    Helps the getPites method
     */
    private ChickenPitaSouvlaki[] generateChickenPites(int totalNumberOfPites) {
        ChickenPitaSouvlaki[] chicken = new ChickenPitaSouvlaki[totalNumberOfPites];

        for (int i = 0; i < chicken.length; i++)
            chicken[i] = new ChickenPitaSouvlaki(new Chicken(5), new Chicken(5), new Pita(4));
        return chicken;
    }

    /*
    Helps the getPites method
     */
    private SheftaliaPitaSouvlaki[] generateSheftaliaPites(int totalNumerOfPites) {
        SheftaliaPitaSouvlaki[] sheftalia = new SheftaliaPitaSouvlaki[totalNumerOfPites];

        return sheftalia;
    }

    /*
    Helps the getPites method
     */
    private MixPitaSouvlaki[] generateMixPites(int totalNumberOfPites) {
        MixPitaSouvlaki[] mix = new MixPitaSouvlaki[totalNumberOfPites];

        return mix;
    }

    /*
    Genaerate the Fries array
     */
    private Fries[] generateFries(int totalNumberOfFries) {
        Fries[] fries = new Fries[totalNumberOfFries];

        return fries;
    }

    @Override
    public String toString() {
        return "<" + this.idNum + ", " + this.tOrder + ", " + this.tRequested + ", " + this.porkPites.length + ", "
                + this.chickenPites.length + ", " + this.sheftaliaPites.length + ", " + this.mixPites.length + ", "
                + this.fries.length + ">";
    }

    /*
    Clones an Order
     */
    public Order clone() {
        Order b = new Order(this);
        return b;

    }

    /*
    Return the id number
     */
    public int getIdNum() {
        return idNum;
    }

    /*
    Returns the time of the order
     */
    public int gettOrder() {
        return tOrder;
    }

    /*
    Compares to objects
     */
    @Override
    public int compareTo(Object arg0) {
        int compareage = ((Order) arg0).tOrder;

        return this.tOrder - compareage;
    }

    /*
    Returns the requested time of delivery
     */
    public int gettRequested() {
        return tRequested;
    }

}
