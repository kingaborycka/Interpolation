
package projekt8;

public class Punkt {
    
    protected double x;
    protected double y;
    
    public Punkt(double x, double y) {
        
        this.x = x;
        this.y = y;
    }
    
    public String get(){
        return "(" + this.x + "; "+ this.y +")";
    }
    
}
