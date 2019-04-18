package hw5;

import hw5.menu.Fries;
import hw5.menu.Pita;
import hw5.menu.Smiles.Chicken;
import hw5.menu.Smiles.Pork;
import hw5.menu.Smiles.Sheftalia;
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

    public int getNumberOfPites() {
        return this.chickenPites.length + this.porkPites.length + this.mixPites.length + this.sheftaliaPites.length;
    }

    public void setIdNum(int newId) {
        this.idNum = newId;
    }

    public int getNumberOfFries() {
        return this.fries.length;
    }

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

    public Fries[] getFries() {
        return fries;
    }

    private PorkPitaSouvlaki[] generatePorkPites(int totalNumberOfPites) {
        PorkPitaSouvlaki[] pork = new PorkPitaSouvlaki[totalNumberOfPites];

        return pork;
    }

    private ChickenPitaSouvlaki[] generateChickenPites(int totalNumberOfPites) {
        ChickenPitaSouvlaki[] chicken = new ChickenPitaSouvlaki[totalNumberOfPites];

        for (int i = 0; i < chicken.length; i++)
            chicken[i] = new ChickenPitaSouvlaki(new Chicken(5), new Chicken(5), new Pita(4));
        return chicken;
    }

    private SheftaliaPitaSouvlaki[] generateSheftaliaPites(int totalNumerOfPites) {
        SheftaliaPitaSouvlaki[] sheftalia = new SheftaliaPitaSouvlaki[totalNumerOfPites];

        return sheftalia;
    }

    private MixPitaSouvlaki[] generateMixPites(int totalNumberOfPites) {
        MixPitaSouvlaki[] mix = new MixPitaSouvlaki[totalNumberOfPites];

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

}
