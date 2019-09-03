import java.lang.Math;

//implements the Polygon Class

public class Pentagon implements Polygon{
    
    private double n;	
	
    //no argument constructor
    public Pentagon(){
        n = 0;	
    }
    //this is the constructor with arguments
    
    public Pentagon(double x){
        n = x;
    }
    
    //calculates the area of the pentagon
    public double area() {
        double area = (5 * n * n) / (4 * Math.tan(Math.PI / 5));
        return area;
    }
    
    //calculates the perimeter of the pentagon
    public double perimeter() {
        double perimeter = n*5;//takes the value of side n and multiples it by 5(numbre of sides a pentagon has
        return perimeter;
    }
}