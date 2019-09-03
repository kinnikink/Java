//this extends from the Triangle class and uses the area and perimeter methods from the Triangle class

public class EquilateralTriangle extends Triangle{
    
    public EquilateralTriangle(){
		super(0,0,0);//super allows you to call the constructor of the triangle class 
    }
    public EquilateralTriangle(int x) {//this calls the second constructor from the triangle class
        super(x,x,x);
    }	
} //closes EquilateralTriangle class