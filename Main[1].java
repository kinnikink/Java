import java.util.Scanner;
import java.lang.Math;

public class Main{
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);//ask the user what shape they want to enter data for
	System.out.println("Would you like to enter data for a 1. Triangle, 2. Hexagon, 3. Octagon, 4. Pentagon, 5. Quadrilateral? "
				+ "Please enter the number associated with the term.");
	int input = in.nextInt();
	//if user enters 1
	while(input != -1) {
            if(input==1) {
                System.out.println("Which type of Triangle would you like to calculate? 1. Any triangle, 2. Isosceles Triangle, or 3. Equilateral Triangle? ");
		int data =  in.nextInt();
		
                //this is for any triangle			
                if (data ==1) {
                    int a=0,b=0,c=0;
                    System.out.println("Please enter 3 sides of the traingle ");
                    a = in.nextInt();
                    b = in.nextInt();
                    c=in.nextInt();				
                    Triangle T1 = new Triangle(a,b,c);
                    
                    System.out.println("Triangle area: " + T1.area());
                    System.out.println("Triangle perimeter: " + T1.perimeter());
		}//closes if statement on line 18
		
                //for a isosceles triangle
                else if(data == 2) {
                    int a=0,b=0;
                    System.out.println("Please enter two values in this order: The same side then the other side that is different");
                    a = in.nextInt();
                    b = in.nextInt();
                    IsoscelesTriangle T2 = new IsoscelesTriangle(a,b);
                    System.out.println("Triangle area: " + T2.area());
                    System.out.println("Triangle perimeter: " + T2.perimeter());
		}//closes else-if statement on line 31
		
                //for a equilateral triangle
                else if(data == 3) {
                    int a=0;
                    System.out.println("Please enter the length of the side ");
                    a = in.nextInt();
                    EquilateralTriangle T3 = new EquilateralTriangle(a);
                    System.out.println("Triangle area: " + T3.area());
                    System.out.println("Triangle perimeter: " + T3.perimeter());
		}//closes else-if statement on line 42		
		
                else{
                    //NEED TO ERROR CHECK HERE
                    System.out.println("Please enter either 1,2,or 3");
                    in.nextInt();
		}//closes else on line 51
            }//closes if statement on line 13
            
            //for a hexagon
            else if(input == 2) {
                System.out.println("Please enter the length of the 6 sides ");
		double h=in.nextInt();
		//this is for hexagon			
		Hexagon H1 = new Hexagon(h);
		System.out.println("Hexagon area:  " + H1.area());
		System.out.println("Hexagon perimeter:  " + H1.perimeter());				
            }//closes else-if statement on line 59		
            
            //for an octagon
            else if(input ==3) {	
                System.out.println("Please enter the length of the 8 sides ");
		double o=in.nextInt();
		Octagon O1 = new Octagon(o);
		System.out.println("Octagon area: " + O1.area());
		System.out.println("Octagon perimeter: " + O1.perimeter());				
            }//closes else-if statement on line 69
            
            //for a pentagon
            else if(input ==4) {			
                System.out.println("Please enter the length of the 5 sides ");
                double p=in.nextInt();
                //this is for pentagon			
		Pentagon P1 = new Pentagon(p);
		System.out.println("Pentagon area: " + P1.area());
		System.out.println("Pentagon perimeter: " + P1.perimeter());
            }//closes else-if statement line 77		
            
            else if(input==5) {			
                System.out.println("Are you wanting to calculate a 1. Square or 2. Rectangle? ");
		int data5 =  in.nextInt();
		//for a square		
		if (data5 ==1) {
                    int s=0;
                    System.out.println("Please enter the length of the side of the Square ");
                    s = in.nextInt();
                    Square S1 = new Square(s);
                    System.out.println("Square area: " + S1.area());
                    System.out.println("Square perimeter: " + S1.perimeter());
		}//closes if statement
                
                //for a rectangle
                else if(data5 == 2) {
                    int r1=0,r2=0;
                    System.out.println("Please enter 2 sides of Rectangle ");
                    r1 = in.nextInt();
                    r2= in.nextInt();
                    Rectangle R1 = new Rectangle(r1,r2);
                    System.out.println("Rectangle area: " + R1.area());
                    System.out.println("Rectangle perimeter: " + R1.perimeter());
		}//closes else-if statement on line 100
		
                else {
                    //NEED TO ERROR CHECK HERE
                    System.out.println("Please enter either 1 or 2.");
                    in.nextInt();
		}//closes else statement on line 110
            }
            
            else{
                //NEED TO ERROR CHECK HERE
		System.out.println("ERROR! Invalid input");
		System.out.println("Please enter a number from 1 to 5");
		//in.nextInt();
            }//closes else loop on line 116		
            System.out.println("Would you like to enter data for a 1. Triangle, 2. Hexagon, 3. Octagon, 4. Pentagon, 5. Quadrilateral? "
					+ "Please enter the number associated with the term.");
            input = in.nextInt();
	}//closes while loop on line 12
		in.close();

    }	
}//closes main class