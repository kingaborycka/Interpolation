package projekt8;

/**
 *
 *  Klasa realizujaca ramke wykresu
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.*;

public class Wykres extends JFrame {
    
//    public Wykres(Lagrange l,Funkcja f, double a, double b, String tytul){
//        super(tytul);
//        JPanel panel;
//        panel = new SzablonLF(l, f , a, b);
//        add(panel);
//        pack();
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setVisible(true);
//    }    
    //Konstruktor dla wielomianu Lagrange'a
    public Wykres(Lagrange f, double a, double b, String tytul){
        super(tytul);
        JPanel panel;
        panel = new SzablonL(f, a, b);
        add(panel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    //Konstruktor dla wielomianu Newtona
    public Wykres(Newton f, double a, double b, String tytul){
        super(tytul);
        JPanel panel;
        panel = new SzablonN(f, a, b);
        add(panel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    //Konstruktor dla funkcji
    public Wykres(Funkcja f, double a, double b, String tytul){
        super(tytul);
        JPanel panel;
        panel = new SzablonF(f, a, b);
        add(panel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
        
}

