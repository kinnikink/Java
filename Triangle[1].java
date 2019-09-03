import java.lang.Math;

//implements the Polygon Class

public class Triangle implements Polygon{
    //this is declaring the 3 variables to use for the sides of the triangle 
    private double a;
    private double b;
    private double c;
    
    //this is the constructor with no arguments
    public Triangle(){
        a = 0;
	b = 0;
	c=0;
    }
	
    //this is the constructor with arguments
    public Triangle(int x,int y,int z){
        a = x;
	b = y;
	c=z;
    }
    
    public double area(){
	double s=(a+b+c)/2;//takes side a , side b, and side c, then divides them by 2
        double area=Math.sqrt(s*(s-a)*(s-b)*(s-c));//Heronis formula to find the area of a triangle
        return area;	
    }
    
    public double perimeter(){
	double perimeter =(a+b+c);//adds three sides to get perimeter
	return perimeter;
    }
}