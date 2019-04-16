package hw5.menu.pitesSouvlakia;

import hw5.menu.Pita;
import hw5.menu.Smiles.Smila;
public class PitaSouvlaki {
    private Smila a;
    private Smila b;
    private Pita p;
    private boolean done;

    public PitaSouvlaki(Smila a, Smila b, Pita p) {
        this.a = a;
        this.b = b;
        this.p = p;
    }

    public int getLength() {
        return this.a.getSize() + this.b.getSize() + this.p.getSize();
    }
    public Smila getA() {
        return a;
    }

    public Smila getB() {
        return b;
    }

    public String toString() {
        String s = "";
        if (this.a.equals(this.b))
            s += "2 smiles " + this.a.getType();
        else
            s += "1 smila" + this.a.getType() + " and 1 smila " + this.b.getType();
        return s;
    }

    public boolean isDone() {
        return (this.a.done && this.b.done && this.p.done);

    }

    public boolean equals(PitaSouvlaki pita) {
        if (this.getClass() == pita.getClass())
            return this.a.getType() == pita.a.getType() && this.b.getType() == pita.b.getType();
        return false;
    }
    public static void main(String[] args) {
        System.out.println("Testing");
    }

}