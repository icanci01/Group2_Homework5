package hw5.graphics;

import javax.swing.*;
import java.awt.*;

public class MenuPrinted extends JFrame {

    private JLabel item1;

    public MenuPrinted() {
        super("Menu for souvlakia");
        setLayout(new FlowLayout());

        item1 = new JLabel("Here i will print the variables");
        add(item1);


    }
}
