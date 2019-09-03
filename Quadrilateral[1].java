//implements the Polygon Class

public class Quadrilateral implements Polygon{
    int a =0;
    int b=0;
    
    //no argument constructor
    public void Quadilateral() {	
    }	
    
    //calulates the area of the quadrilateral
    public double area() {
        double area= a*b;
	return area;
    }	
	
    //calculates the perimeter of the quadilateral
    public double perimeter() {
        double perimeter = (a*2)+(b*2);
	return perimeter;
    }
}