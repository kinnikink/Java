import java.lang.Math;

//implements the Polygon Class 

public class Octagon implements Polygon{
    
    private double side;//this is the variable that will be used to take in the sides of the square		
    
    public Octagon(){//no argument constructor
    }		
    
    public Octagon(double side) {//argument constructor
        this.side = side;
    }		
    
    public double getSide() {
        return side;
    }
	    
    public void setSide(double side) {
        this.side = side;
    }
	    
    //calculates the area of the octagon
    public double area() {
        double perimeter = (2 + 4/(Math.sqrt(2)))* side * side;
	return perimeter;
    }
    //calculates the perimeter of the octagon
    public double perimeter() {
        return side * 8;//takes the side and multiples by the number of sides in an octagon which is 8
    }
}




