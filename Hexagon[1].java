//implements the Polygon class

public class Hexagon implements Polygon{
    private double side;
    
    public Hexagon(){//no argiment constructor
    }	
    
    public Hexagon(double side) {//argument constructor
        this.side = side;
    }
    
    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    //calculates the area of a hexagon
    public double area() {
        double area= (6*(side*side))/(4*Math.tan(Math.PI/6));//get sides then calculate the area
	return area;
    }
    //calculates the perimeter of a hexagon
    public double perimeter() {
        double perimeter= side * 6;//takes the sides and muultiplies it by the number of sides a hexagon has which is 6
        return perimeter;
    }
}
    
	