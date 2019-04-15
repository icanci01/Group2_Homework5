package hw5;

public class Delivery {
    private int id;
    private int timeOfOrder;
    private int timeOfDelivery;
    private int timeOdDelivered;
    private int timeDelay;
    private int numberOfPites;
    private int numberOfFries;

    public Delivery(int id, int timeOfOrder, int timeOfDelivery, int timeOdDelivered, int numberOfPites, int numberOfFries) {
        this.id = id;
        this.timeOfOrder = timeOfOrder;
        this.timeOfDelivery = timeOfDelivery;
        this.timeOdDelivered = timeOdDelivered;
        this.numberOfPites = this.numberOfPites;
        this.numberOfFries = numberOfFries;
        this.timeDelay = timeOdDelivered - timeOfDelivery;
    }

    public int getId() {
        return id;
    }

    public int getNumberOfFries() {
        return numberOfFries;
    }

    public int getNumberOfPites() {
        return numberOfPites;
    }

    public int getTimeDelay() {
        return timeDelay;
    }

    public int getTimeOdDelivered() {
        return timeOdDelivered;
    }

    public int getTimeOfDelivery() {
        return timeOfDelivery;
    }

    public int getTimeOfOrder() {
        return timeOfOrder;
    }
}
