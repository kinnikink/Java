//this extends from the Triangle class and uses the same area and perimeter methods from the Triangle Class
public class IsoscelesTriangle extends Triangle{
    
    public IsoscelesTriangle(){
        super(0,0,0);//using super allows you to call the constructor of the triangle class 
    }
    
    public IsoscelesTriangle(int x,int y) {
        super(x,x,y);//this calls the second constructor from the triangle class
    }
}