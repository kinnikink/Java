//extends the Quadrilateral Class

class Rectangle extends Quadrilateral{
    private int a;// variable for one length
    private int b;//variable for other length
	
    //this is the no argument constructor
    public Rectangle(){
        a = 0;
	b = 0;
    }	
	
    //this is the argument constructor
    public Rectangle(int x,int y){
        a = x;
	b = y;
    }
	
    public double area(){
        double area =a*b;//side a * side b finds the area of a rectangle
	return area;
    }	
	
    //this is finding the perimeter by adding the 4 sides
    public double perimeter(){
        double perimeter= 2*(a+b);
	return perimeter;
    }
}