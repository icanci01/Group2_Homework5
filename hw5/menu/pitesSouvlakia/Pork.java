package hw5.menu.pitesSouvlakia;

public class Pork extends Smila {
    public Pork(int size) {
        super(size, timeRnadom(), "Pork");
    }

    private static int timeRnadom() {
        int x = 15;
        x += Math.random() * 5;
        return x;
    }

}
