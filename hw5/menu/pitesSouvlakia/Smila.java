package hw5.menu.pitesSouvlakia;

public abstract class Smila {
    private int size;
    private int time;
    private String type;

    public Smila(int size, int time, String type) {
        this.size = size;
        this.time = time;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public int getSize() {
        return size;
    }

    public int getTime() {
        return time;
    }
}
