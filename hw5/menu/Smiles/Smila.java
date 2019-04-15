package hw5.menu.Smiles;

public abstract class Smila {
    private int size;
    private int time;
    private String type;

    public Smila(int size, int time, String type) {
        this.size = size;
        this.time = time;
        this.type = type;
    }

    public boolean equals(Smila a) {
        if (this.getClass() == a.getClass())
            if (this.getType() == a.getType())
                return true;
            else return false;
        return false;
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
