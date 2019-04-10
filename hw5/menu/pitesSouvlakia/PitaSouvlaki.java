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

    @Override
    public String toString() {
        String s = "";
        s += this.a.getType(). + this.b.getType();
        return s;
    }

    public static void main(String[] args) {
        System.out.println("Testing");
    }

}