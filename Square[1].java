//extends the Quadrilateral Class

public class Square extends Quadrilateral{
    private int a;//variable a will be used to get the side of the square
    
    //no argument constructor
    public Square(){
        a = 0;
    }	
	
    //argument constructor
    public Square(int x){
        a = x;
    }
	
    //method to find the area of the square
    public double area(){
        double area= a*a;//calcuates the area( side*side)
        return area;
    }
	
    //method to find the perimeter
    public double perimeter(){
        double perimeter= 4*a;//adds the 4 sides of the square to get perimeter
	return perimeter;
    }
}