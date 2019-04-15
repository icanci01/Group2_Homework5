package hw5.menu.pitesSouvlakia;

import hw5.menu.Smiles.Smila;
import hw5.menu.Pita;
public class PitaSouvlaki {
    private Smila a;
    private Smila b;
    private Pita p;

    public PitaSouvlaki(Smila a, Smila b, Pita p) {
        this.a = a;
        this.b = b;
        this.p = p;
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
            s += "2 " + this.a.getType();
        else
            s += "1 " + this.a.getType() + " and 1 " + this.b.getType();
        return s;
    }

    public boolean equals(PitaSouvlaki pita) {
        if (this.getClass() == pita.getClass())
            if (this.a.getType() == pita.a.getType() && this.b.getType() == pita.b.getType())
                return true;
            else
                return false;
        return false;
    }
    public static void main(String[] args) {
        System.out.println("Testing");
    }

}