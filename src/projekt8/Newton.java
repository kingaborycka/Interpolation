package projekt8;

import java.util.List;


public class Newton {
    List<Punkt> punkty;
    int n;
    
    public Newton(Funkcja f){
        this.punkty = f.punkty;
        this.n = punkty.size();
        
    }
    
    public double ObliczWartosc(double x_s){
        double[][] c = new double[n][n];
        double g = 1.0; //(x-x_0)(x-x_1)...
        double w = punkty.get(0).y;
        
        for(int i=0; i<n; i++){
            c[i][0] = punkty.get(i).y;
//            System.out.println("c_"+i+",0"+"="+c[i][0]);
        }
        
        for(int j=1; j<n; j++){
            for(int i=n-2; i>-1; i--){
                if(i+j<n){
                    c[i][j] = (c[i+1][j-1]-c[i][j-1])/(punkty.get(i+j).x - punkty.get(i).x);
                }else{
                    c[i][j] = 0.0;
                }
            }
            g *= (x_s - punkty.get(j-1).x);
            w += c[0][j]*g; 
            
        }

        return w;
    }
    


}
