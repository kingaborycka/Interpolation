
package projekt8;

import java.util.ArrayList;
import java.util.List;

public class Lagrange {
    List<Punkt> punkty;         
    
    public Lagrange(Funkcja f){
        this.punkty = f.punkty;
    }

    public double ObliczWartosc(double x_s){
        double[] l = new double[punkty.size()];
        double w = 0.0;           //wartość wielomianu interpolacyjnego Lagrange'a dla podanego x_s
        
        for(int k=0; k<this.punkty.size(); k++){
            double x_k = punkty.get(k).x;
            double y_k = punkty.get(k).y;
            l[k] = 1.0;
            
            for(int n=0; n<this.punkty.size(); n++){
                if(n!=k){
                    double x_n = punkty.get(n).x;
                    l[k] = l[k]*((x_s-x_n)/(x_k-x_n));       
                } 
            }

            w += y_k*l[k];
            
        }
        return w;
    }
    
}
