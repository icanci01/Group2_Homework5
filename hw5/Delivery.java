package hw5;

public class Delivery {

    private int idNum;
    private int tOrder;
    private int tRequested;
    private int tDelivered;
    private int tDelay;
    private int numberOfPites;
    private int numberOfFries;

    public Delivery(int idOfOrder, int timeOfOrder,
                    int timeRequested, int timeDelivered,
                    int numberOfPites, int numberOfFries) {
        this.idNum = idOfOrder;
        this.tOrder = timeOfOrder;
        this.tRequested = timeRequested;
        this.tDelivered = timeDelivered;
        this.tDelay = timeDelivered - timeRequested;
        this.numberOfPites = numberOfPites;
        this.numberOfFries = numberOfFries;
    }

    public int gettDelay() {
        return tDelay;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(this.idNum + " " + this.tOrder + " " + this.tDelivered + " " + this.tDelay + " " + this.numberOfPites + " " + this.numberOfFries);
        return str.toString();
    }
}
