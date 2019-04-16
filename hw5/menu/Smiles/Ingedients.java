package hw5.menu.Smiles;

public class Ingedients {
    public boolean done;
    private int size;
    private int time;

    public Ingedients(int size, int time) {
        this.time = time;
        this.size = size;
    }

    public int getTime() {
        return time;
    }

    public int getSize() {
        return size;
    }

    public int psise() {
        this.done = true;
        return this.time;
    }
}
