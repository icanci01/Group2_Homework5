package hw5;

import hw5.menu.Fries;
import hw5.menu.pitesSouvlakia.ChickenPitaSouvlaki;
import hw5.menu.pitesSouvlakia.MixPitaSouvlaki;
import hw5.menu.pitesSouvlakia.PorkPitaSouvlaki;
import hw5.menu.pitesSouvlakia.SheftaliaPitaSouvlaki;

public class Order implements Comparable {

    private int idNum = 0;
    private int tOrder;
    private int tRequested;
    private PorkPitaSouvlaki[] porkPites;
    private ChickenPitaSouvlaki[] chickenPites;
    private SheftaliaPitaSouvlaki[] sheftaliaPites;
    private MixPitaSouvlaki[] mixPites;
    private Fries[] fries;

    public Order(int individualOrderID, int tOrder, int tRequested, int numberPorkPites, int numberChickenPites, int numberSheftaliaPites, int numberMixPites, int numberFries) {
        idNum = individualOrderID;
        this.tOrder = tOrder;
        this.tRequested = tRequested;

        try {
            if (numberPorkPites < 0 || numberChickenPites < 0 || numberSheftaliaPites < 0 || numberMixPites < 0 || numberFries < 0)
                throw new Exception("Wrong"); // Needs improvement
            porkPites = generatePorkPites(numberPorkPites);
            chickenPites = generateChickenPites(numberChickenPites);
            sheftaliaPites = generateSheftaliaPites(numberSheftaliaPites);
            mixPites = generateMixPites(numberMixPites);
            fries = generateFries(numberFries);
        } catch (Exception e) {
            System.out.println("Error Occured, Order can't be created");
            System.exit(0);
        }

    }

    private PorkPitaSouvlaki[] generatePorkPites(int totalNumberOfPites) {
        PorkPitaSouvlaki[] pork = new PorkPitaSouvlaki[totalNumberOfPites];

        return pork;
    }

    private ChickenPitaSouvlaki[] generateChickenPites(int totalNumberOfPites) {
        ChickenPitaSouvlaki[] chicken = new ChickenPitaSouvlaki[totalNumberOfPites];

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
    public  Order(Order a) {
    	idNum = new Integer(a.idNum);
        this.tOrder = new Integer(a.tOrder);
        this.tRequested =new Integer(a.tRequested); 
        this.porkPites = a.porkPites.clone();
        this.chickenPites = a.chickenPites.clone();
        this.sheftaliaPites = a.sheftaliaPites.clone();
        this.mixPites = a.mixPites.clone();
        this.fries = a.fries.clone();
        
    	     	
    }
    public Order clone() {
    	Order b =  new Order(this);
    	return b;
    	
    }
   

	@Override
	public int compareTo(Object arg0) {		
		int compareage=((Order)arg0).tRequested;
	       
        return this.tRequested-compareage;
	}

	public int gettRequested() {
		return tRequested;
	}

	public void settRequested(int tRequested) {
		this.tRequested = tRequested;
	}
}
