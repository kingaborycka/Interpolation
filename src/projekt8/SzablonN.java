package projekt8;

/**
 *  Klasa rysujaca szablon wykresu wielomianu na zadanym przedziale
 */

import java.awt.*;
import java.awt.geom.*;
import javax.swing.JPanel;

public class SzablonN extends JPanel {
    
    int width;          //szerokosc okna
    int height;         //wysokosc okna
    double a, b;        //krance przedzialu
    double MAX_W;       //maksymalna wartosc funkcji
    double MIN_W;       //minimalna wartosc funkcji
    double[] x;         //tablica argumentow
    double[] W;         //tablica wartosci funkcji
    int N = 100;        //liczba wyswietlanych danych
    Newton f;         //funkcja
            
    /*Konstruktor przyjmujący:
     *  f - wielomian
     *  n0 - numer pierwszej wyswietlanej danej
    */
    public SzablonN( Newton funkcja, double lewy_kraniec, double prawy_kraniec) {
        double dx;
        a = lewy_kraniec;
        b = prawy_kraniec;
        f = funkcja;
        width = 480;
        height = 480;
        x = new double[N + 1];
        W = new double[N + 1];
        dx = 1.0 * (b - a) / N;
        
        System.out.println("\nInterpolacja Newtona");
        for(int i = 0; i < N + 1; i++) {
            x[i] = a + i * dx;
            W[i] = f.ObliczWartosc(x[i]);
            System.out.println(x[i]+": "+W[i]);
        }
        setPreferredSize(new Dimension(width,height));
    }
    
    public void getMax(){
        MAX_W = 0.0;
        MIN_W = 0.0;
        for(int i = 0; i < N + 1; i++) {
            if(W[i] > MAX_W) MAX_W = W[i];
            if(W[i] < MIN_W) MIN_W = W[i];
        }
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        super.setBackground(Color.WHITE);
        Graphics2D g2d = (Graphics2D) g;
        int dist = 10;
        getMax();
        
        //Wyznaczam krok wartosci na osi x
        double dx;
        dx = 1.0 * (b - a) / N;
        int dn_x;
        dn_x = (int) ((width - 8.0 * dist) / N);
        
        //Osie
        //Wyznaczam polozenie i rysuje os y
        int poz_osi_y;
        if(a >= 0) poz_osi_y = 40;
        else if (b <= 0) poz_osi_y = 440;
        else poz_osi_y = 40 + (int)((-400.0) * a / (b - a));
        Line2D osy = new Line2D.Double(poz_osi_y, height-2*dist, poz_osi_y, 2*dist);
        Line2D osyal = new Line2D.Double(poz_osi_y - dist, 3*dist, poz_osi_y, 2*dist);
        Line2D osyar = new Line2D.Double(poz_osi_y + dist, 3*dist, poz_osi_y, 2*dist); 
        g2d.draw(osy);
        g2d.draw(osyal);
        g2d.draw(osyar);
        //Wyznaczam polozenie i rysuje os x
        int poz_osi_x;
        if(MAX_W == 0.0) poz_osi_x = 40;
        else if (MIN_W == 0.0) poz_osi_x = 440;
        else poz_osi_x = 40 + (int)(400.0 * MAX_W / (MAX_W - MIN_W));
        Line2D osx = new Line2D.Double(2*dist, poz_osi_x, width-2*dist, poz_osi_x); 
        Line2D osxau = new Line2D.Double(width-3*dist, poz_osi_x - dist,width-2*dist, poz_osi_x); 
        Line2D osxad = new Line2D.Double(width-3*dist, poz_osi_x + dist,width-2*dist, poz_osi_x);
        g2d.draw(osx);
        g2d.draw(osxau);
        g2d.draw(osxad);
        
        //Podziałka na osi OX
        int dx_os;
        double dxx;
        Line2D podzx = new Line2D.Double();
        if(a >= 0 || b <= 0) {
            dx_os = (int)((width - 8 * dist) / 5.0);
            dxx = (b - a) / 5.0;
            for(int i = 0; i < 6; i++){
                podzx.setLine(4*dist + i*dx_os, poz_osi_x - 0.5*dist, 4*dist + i*dx_os, poz_osi_x + 0.5*dist);
                g2d.draw(podzx); 
                g2d.drawString(String.format("%4.2f", a + dxx * i), (float)(3*dist + i * dx_os), poz_osi_x + 2 * dist);
            }
        }
        else {
            podzx.setLine(4*dist, poz_osi_x - 0.5*dist, 4*dist, poz_osi_x + 0.5*dist);
            g2d.draw(podzx); 
            g2d.drawString(String.format("%4.2f", a), (float)(3*dist), poz_osi_x + 2 * dist);
            podzx.setLine(width - 4*dist, poz_osi_x - 0.5*dist, width - 4*dist, poz_osi_x + 0.5*dist);
            g2d.draw(podzx); 
            g2d.drawString(String.format("%4.2f", b), (float)(width - 5*dist), poz_osi_x + 2 * dist);        
        }
        
        //Podzialka na osi OY
        int dy_os;
        double dyy;
        Line2D podzy = new Line2D.Double();
        if(MAX_W == 0.0 || MIN_W == 0.0) {
            dy_os = (int)((height - 8 * dist) / 5.0);
            dyy = (MAX_W - MIN_W) / 5.0;
            for(int i = 0; i < 6; i++){
                podzx.setLine(poz_osi_y - 0.5*dist, 4*dist + i*dy_os, poz_osi_y + 0.5*dist, 4*dist + i*dy_os);
                g2d.draw(podzx); 
                g2d.drawString(String.format("%4.2f", MAX_W - dyy * i), poz_osi_y - 4*dist, (float)(4*dist + i * dy_os));
            }
        }
        else {
            podzx.setLine(poz_osi_y - 0.5*dist, 4*dist, poz_osi_y + 0.5*dist, 4*dist);
            g2d.draw(podzx); 
            g2d.drawString(String.format("%4.2f", MAX_W), poz_osi_y - 4*dist, (float)(4*dist));
            podzx.setLine(poz_osi_y - 0.5*dist,height - 4*dist, poz_osi_y + 0.5*dist, height - 4*dist);
            g2d.draw(podzx); 
            g2d.drawString(String.format("%4.2f", MIN_W), poz_osi_y - 4*dist, (float)(height - 4*dist));
        }
        /*double dx = (width - 9*dist)/5.0;
        double dy = (height - 8*dist)/5.0;
        Line2D podzx = new Line2D.Double();
        Line2D podzy = new Line2D.Double();
        for(int i = 1; i < 6; i++){
            podzx.setLine(5*dist + i*dx, height-3.5*dist, 5*dist + i*dx, height-4.5*dist);
            podzy.setLine(4.5*dist, height-4*dist - i*dy, 5.5*dist, height-4*dist - i*dy);
            g2d.draw(podzx);
            g2d.draw(podzy);
        }
        
        //Opisy podziałki
        int dn = (int)Math.ceil((MAX_W-MIN_W)/5.0);
        double dt = (MAX_W-MIN_W)/5.0;
        for(int i = 0; i < 6; i++) g2d.drawString(String.format("%4.2f", a + dn*i), (float)(4.5*dist + i*dx), height-2*dist);
        for(int i = 0; i < 6; i++) g2d.drawString(String.format("%4.2f",MIN_W + dt*i), 0, (float)(height-3.5*dist-i*dy));
        */        
        
        //Rysujemy wykres
        Line2D wyk = new Line2D.Double();
        g2d.setStroke(new BasicStroke(4));
        g2d.setColor(Color.RED);
        double skalujW = (height - 8.0 * dist) / (MAX_W - MIN_W);
        for(int i = 0; i < N; i++){
           wyk.setLine(4*dist + i * dn_x, height - 4 * dist - (int)(skalujW * (W[i] - MIN_W)), 4*dist + (i + 1) * dn_x, height - 4 * dist - (int)(skalujW * (W[i+1] - MIN_W))); 
           g2d.draw(wyk);
        }
    }
}

