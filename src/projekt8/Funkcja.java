package projekt8;

import java.util.ArrayList;
import java.util.List;

/*
 * Klasa przechowujaca funkcje
 */

public class Funkcja {
    
    String wzorFunkcji;
    List<Punkt> punkty;
        
    //Konstruktor domyslny
    public Funkcja(){
        
    }
   
    //Metoda wyznaczajaca wartosc funkcji
    public double ObliczWartosc(double x){
        
        return Math.sqrt(x);
    } 
    
    public void TworzPunkty(double[] arg){
        
        this.punkty = new ArrayList<Punkt>();
        for(int i=0; i<arg.length; i++){
  
            double x = arg[i];
            double y = this.ObliczWartosc(x);
            
            Punkt point = new Punkt(x, y);
            this.punkty.add(point);
        }
    }
    
    public static void WyswietlPunkty(List<Punkt> punkty){
        System.out.println("Punkty dla podanych argumentów:");
        for(Punkt p: punkty){
            System.out.println(p.get());
        }
    }
    
}
