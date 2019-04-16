package hw5.menu.Smiles;

public abstract class Smila extends Ingedients {
    private String type;


    public Smila(int size, int time, String type) {
        super(size, time);
        this.type = type;
    }

    public boolean equals(Smila a) {
        if (this.getClass() == a.getClass())
            return this.getType() == a.getType();
        return false;
    }

    public String getType() {
        return type;
    }
}
