package hw5;

import hw5.menu.Fries;
import hw5.menu.Pita;
import hw5.menu.Smiles.Chicken;
import hw5.menu.Smiles.Pork;
import hw5.menu.Smiles.Sheftalia;
import hw5.menu.Smiles.Smila;
import hw5.menu.pitesSouvlakia.*;

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
    private int minTime;
    private int totalLength;
    private Smila[] smiles;

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
            porkPites = generatePorkPites(numberPorkPites, sizeChickenPork, sizePita);
            chickenPites = generateChickenPites(numberChickenPites, sizeChickenPork, sizePita);
            sheftaliaPites = generateSheftaliaPites(numberSheftaliaPites, sizeSheftalia, sizePita);
            mixPites = generateMixPites(numberMixPites, sizeChickenPork, sizeSheftalia, sizePita);
            total = numberChickenPites + numberMixPites + numberPorkPites + numberSheftaliaPites;
            pites = new PitaSouvlaki[total];
            fries = generateFries(numberFries);
        } catch (Exception e) {
            System.out.println("Error Occured, Order can't be created");
            System.exit(0);
        }
        this.minTime = calculayeMinTime();
        this.totalLength = calculateTotalLength();
        this.smiles = calculateSmiles();
    }

    public Order(int individualOrderID, int tOrder, int tRequested, int numberPorkPites, int numberChickenPites, int numberSheftaliaPites, int numberMixPites, int numberFries) {
        this(individualOrderID, tOrder, tRequested, numberPorkPites, numberChickenPites, numberSheftaliaPites, numberMixPites, numberFries, 1, 1, 1);
    }

    public int calculateTotalLength() {
        int sum = 0;
        for (int i = 0; i < this.getPites().length; i++) {
            sum += this.getPites()[i].getA().getSize();
            sum += this.getPites()[i].getB().getSize();
            sum += this.getPites()[i].getP().getSize();
        }
        return sum;
    }

    private Smila[] calculateSmiles() {
        Smila[] smiles = new Smila[getPites().length * 2];
        int counter = 0;
        for (int i = 0; i < this.getPites().length; i++) {
            smiles[counter] = this.getPites()[i].getA();
            counter++;
            smiles[counter] = this.getPites()[i].getB();
            counter++;
        }
        return smiles;
    }

    public int getMinTime() {
        return minTime;
    }

    public Smila[] getSmiles() {
        return smiles;
    }

    public int getTotalLength() {
        return totalLength;
    }

    private int calculayeMinTime() {
        int max = 0;
        for (int i = 0; i < this.getPites().length; i++) {
            int a = this.getPites()[i].getA().getTime();
            int b = this.getPites()[i].getB().getTime();
            max = Math.max(a, b);
        }
        return max;
    }

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

    public boolean isDone(int i) {
        return this.getPites()[i].getA().done && this.getPites()[i].getB().done && this.getPites()[i].getP().done && this.getFries()[i].done;
    }

    public int getNumberOfPites() {
        return this.chickenPites.length + this.porkPites.length + this.mixPites.length + this.sheftaliaPites.length;
    }

    public int getNumberOfFries() {
        return this.fries.length;
    }

    public PitaSouvlaki[] getPites() {
        int num = getNumberOfPites();
        PitaSouvlaki[] pites = new PitaSouvlaki[num];
        for (int i = 0; i < sheftaliaPites.length; i++) {
            pites[i] = new SheftaliaPitaSouvlaki(new Sheftalia(sizeSheftalia), new Sheftalia(sizeSheftalia), new Pita(sizePita));
        }
        for (int i = sheftaliaPites.length; i < sheftaliaPites.length + mixPites.length; i++) {
            pites[i] = new MixPitaSouvlaki(new Sheftalia(sizeSheftalia), new Pork(sizeChickenPork), new Pita(sizePita));
        }
        for (int i = sheftaliaPites.length + mixPites.length; i < porkPites.length + mixPites.length + sheftaliaPites.length; i++) {
            pites[i] = new PorkPitaSouvlaki(new Pork(sizeChickenPork), new Pork(sizeChickenPork), new Pita(sizePita));
        }
        for (int i = porkPites.length + mixPites.length + sheftaliaPites.length; i < pites.length; i++) {
            pites[i] = new ChickenPitaSouvlaki(new Chicken(sizeChickenPork), new Chicken(sizeChickenPork), new Pita(sizePita));
        }


        return pites;
    }

    public Fries[] getFries() {
        return fries;
    }

    private PorkPitaSouvlaki[] generatePorkPites(int totalNumberOfPites, int size, int sizePita) {
        PorkPitaSouvlaki[] pork = new PorkPitaSouvlaki[totalNumberOfPites];
        for (int i = 0; i < pork.length; i++)
            pork[i] = new PorkPitaSouvlaki(new Pork(size), new Pork(size), new Pita(sizePita));
        return pork;
    }

    private ChickenPitaSouvlaki[] generateChickenPites(int totalNumberOfPites, int size, int sizePita) {
        ChickenPitaSouvlaki[] chicken = new ChickenPitaSouvlaki[totalNumberOfPites];
        for (int i = 0; i < chicken.length; i++)
            chicken[i] = new ChickenPitaSouvlaki(new Chicken(size), new Chicken(size), new Pita(sizePita));
        return chicken;
    }

    private SheftaliaPitaSouvlaki[] generateSheftaliaPites(int totalNumerOfPites, int sizeSheftalia, int sizePita) {
        SheftaliaPitaSouvlaki[] sheftalia = new SheftaliaPitaSouvlaki[totalNumerOfPites];
        for (int i = 0; i < sheftalia.length; i++)
            sheftalia[i] = new SheftaliaPitaSouvlaki(new Sheftalia(sizeSheftalia), new Sheftalia(sizeSheftalia), new Pita(sizePita));
        return sheftalia;
    }

    private MixPitaSouvlaki[] generateMixPites(int totalNumberOfPites, int sizeChickenPork, int sizeSheftalia, int sizePita) {
        MixPitaSouvlaki[] mix = new MixPitaSouvlaki[totalNumberOfPites];
        for (int i = 0; i < mix.length; i++)
            mix[i] = new MixPitaSouvlaki(new Sheftalia(sizeSheftalia), new Pork(sizeChickenPork), new Pita(sizePita));
        return mix;
    }

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

    public Order clone() {
        Order b = new Order(this);
        return b;

    }

    public int getIdNum() {
        return idNum;
    }

    public int gettOrder() {
        return tOrder;
    }

    @Override
    public int compareTo(Object arg0) {
        int compareage = ((Order) arg0).tOrder;

        return this.tOrder - compareage;
    }

    public int gettRequested() {
        return tRequested;
    }

    public void settRequested(int tRequested) {
        this.tRequested = tRequested;
    }
}
