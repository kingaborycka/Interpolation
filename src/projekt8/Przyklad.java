package projekt8;
/*
 * Przyklad - porownanie metody siecznych, stycznych i bisekcji
 */

public class Przyklad {
    Funkcja f;  //funkcja, dla której będziemy szukać wartości dla podanych argumentów
    double[] arg = {0.0, 1.0, 4.0, 9.0, 16.0}; //argumenty funkcji
    double a = 0; //lewy kraniec przedziału, od którego mają zostać wyświetlone wykresy
    double b = 10.0; //prawy kraniec przedziału, do którego mają zostać wyświetlone wykresy

    //Konstruktor klasy
    public Przyklad(){
        //podaj wzór funkcji w klasie Funkcja
        f = new Funkcja();
        
        //obliczanie wartości funkcji dla podanych argumentów
        f.TworzPunkty(this.arg);
        Funkcja.WyswietlPunkty(f.punkty);
    }
    
    public void Porownaj() {
        double[] wsp;
        
        Lagrange lagrange = new Lagrange(f);
        
        Newton newton = new Newton(f);

        Wykres wykres_funkcji = new Wykres(f,a,b,"Funkcja, dla której szukaliśmy interpolacji");
        Wykres wykres_lagrange = new Wykres(lagrange,a,b,"Wielomian Lagrange'a");
        Wykres wykres_newton = new Wykres(newton,a,b,"Wielomian Newtona");
       
    }
}
