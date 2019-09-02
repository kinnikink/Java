/* ========================================================================== */

/*  PROGRAM Employee Compensation
    AUTHOR: <Kelli Kinnikin>
    COURSE NUMBER: <CIS 210>
    COURSE SECTION NUMBER: <01>
    INSTRUCTOR NAME: <Guanyu Tian>
    PROJECT NUMBER: <10>
    DUE DATE: 11/30/2017

SUMMARY:
> Design an abstract Employee class that has the following members:
    o A field for the ID of the employee (an integer)
    o A field for the year that the employee was hired (an integer)
    o A field for the base salary of the employee (double)
    o A field for the total compensation of the employee (double)
    o A constructor and appropriate getters and setters
    o A toString() method that displays the employee’s name, the year in
which the employee was hired, his or her base salary, and total
compensation.

> Design a JuniorEmployee class that extends the Employee class. The
JuniorEmployee class should have the following members:
    o A field for commission (double).
    o A constructor and appropriate setters and getters.
    o A toString() method that overrides the toString() method in the base
      class. The JuniorEmployee class’s toString() method should display
      only the employee’s ID, the year he or she was hired, and the
      commission.

> Design a SeniorEmployee class that extends the Employee class. The
SeniorEmployee class should have the following members:
    o A field for the annual bonus (double).
    o A constructor and appropriate setters and getters.
    o A toString() method that overrides the toString() method in the base
      class. The SeniorEmployee class’s toString() method should display
      only the employee’s ID, the year he or she was hired, and the
      employee’s annual bonus.

> Design a Manager class that extends the Employee class. The Manager class
should have the following members:
    o A field for stock dividend (double)
    o A constructor and appropriate setters and getters
    o A ShowDividend() method that displays the amount of dividend.
    o A toString() method that overrides the toString() method in the base
      class. The Manager class’s toString() method should display only the
      employee’s ID, the year he or she was hired, and the employee’s
      dividend.

> Design an Interface named EmployeeCompensation. It has one methods:
CalculateTotalCompensation() which returns the total compensation.
JuniorEmployee, SeniorEmployee, and Manager classes MUST implement
this Interface.
    o JuniorEmployee’s total compensation is baseSalary + commission
    o SeniorEmployee’s total compensation is baseSalary + annualBonus
    o Manager’s total compensation is baseSalary + dividend
 
Demonstrate/test the classes in a program that has one Employee array. The
program reads various employees’ data from an existing file named
“Employees.txt” and create appropriate
(JuniorEmployee/SeniorEmployee/Manager) objects based the type information of
an employee. For example, if an employee’s type is Junior, the program should
create a JuniorEmployee object. Then, insert various JuniorEmployee,
SeniorEmployee, and Manager objects to the array elements.

1. The program uses selection sort algorithm to sort the array based on an
Employee’s ID in ascending order.

2. The program steps through the array, calling each object’s toString()
method.

3. The program steps through the array, calling the ShowDividend() method
from every Manager object. Your program MUST be able to distinguish
every Manager object from all of those Employee object in the array.

INPUT:
> The input is from an existing file named “Employees.txt”. Note, if the file does not
exist, your program MUST display an error message and terminate gracefully. 

OUTPUT:
> Your program should display the following on the console and to a file named
employeeOutput.txt:
    o Each employee’s ID, title (Senior, Junior, Manager), yearHired, and total
     compensation (base salary + commission/annual bonus/dividend), along
     with the content of its toString() method. They should be displayed in
     ascending order.
    o For every manager, display his or her dividend using ShowDividend()
      method.
*/
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class MainProgram{
    public static void main(String[] args) throws IOException{
	System.out.println("Enter the name of the file: ");
	Scanner keyboard = new Scanner(System.in);
	keyboard.nextLine();
	keyboard.close();	

	ArrayList<Employee> obj1 = ReadInputData("Employees.csv");
	ArrayList<Employee> obj2 = SelectionSort(obj1);
	PrintManagerDividend(obj2, "employeeOutput.txt");	
	}
	/**
	 * ReadInputData method that creates the counter for number of lines
	 * Closes the object when program finishes
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static ArrayList<Employee> ReadInputData(String fileName) throws IOException{
            int numOfLines = 0;
            File file = new File(fileName);	
            Scanner fileCount = new Scanner(file);
            Scanner fileInput = new Scanner(file);	
            while(fileCount.hasNextLine()){//Add to fileCount counter while a line is read
                fileCount.nextLine();
		numOfLines++;
            }
            fileCount.close();	
            String [] stringArray = new String[numOfLines];//Create a string array for numOfLines
            int i = 0;
            while(fileInput.hasNextLine()){//Add to fileInput counter while file has another line
                stringArray[i] = fileInput.nextLine();
                i++;
            }
            fileInput.close();
            //Creates a 2nd ArrayList inside of the Employee ArrayList called employeeClass
            ArrayList<Employee> employeeClass = new ArrayList<Employee>();
            //Loops through and reads in all employees data, separates data by comma separation
            for(i=1; i<stringArray.length; i++){
                //Organizes string elements into sub strings based 
		//on what each employee is classified as 
                String [] employeeRecord = stringArray[i].split("[,]");
                    //if element is of Junior status
                    if(employeeRecord[2].equals(" Junior")){
                        employeeClass.add(new JuniorEmployee(Integer.parseInt(employeeRecord[0]),
                            Integer.parseInt(employeeRecord[1]),
                            Double.parseDouble(employeeRecord[3]),
                            Double.parseDouble(employeeRecord[4])));
                    }
                    //if element is of Senior status
                    else if(employeeRecord[2].equals(" Senior")){
                        employeeClass.add(new SeniorEmployee(Integer.parseInt(employeeRecord[0]),
                            Integer.parseInt(employeeRecord[1]),
                            Double.parseDouble(employeeRecord[3]),
                            Double.parseDouble(employeeRecord[4])));
                    }
                    //if element is of Manager status
                    else if(employeeRecord[2].equals(" Manager")){			
                        employeeClass.add(new Manager(Integer.parseInt(employeeRecord[0]),
                        Integer.parseInt(employeeRecord[1]),
			Double.parseDouble(employeeRecord[3]),
			Double.parseDouble(employeeRecord[4])));
                    }
		}
		return employeeClass;
	}//Closes ReadInputData Method	
	/**
	 * Reads in the EmployeeList and associates related elements with ID number
	 * @param employeeList
	 * @return
	 */
	public static ArrayList<Employee> SelectionSort(ArrayList<Employee> employeeList){
            int startScan, index, minIndex;
            Employee minValue = new Employee();
            for (startScan = 0; startScan < (employeeList.size()-1); startScan++){
                minIndex = startScan;
		minValue = (employeeList.get(startScan));              
		//Organizes information from SelectionSort method in numerical ascending order   
		for(index = startScan + 1; index < employeeList.size(); index++){
                    if (employeeList.get(index).getID() < minValue.getID()){
                        minValue = employeeList.get(index);
		        minIndex = index;
                    }
		}
                //Replaces minIndex value with the startIndex value
		employeeList.remove(minIndex);
		employeeList.add(minIndex,employeeList.get(startScan));
		employeeList.remove(startScan);
		employeeList.add(startScan, minValue);
            }
            return employeeList;
	}
	/**
	 * Output all of the relevant Information out to the employeeOutput.txt file 
	 * @param employeeList
	 * @param fileName
	 * @throws IOException
	 */
	public static void PrintManagerDividend(ArrayList<Employee> employeeList, String fileName) throws IOException{
            //Creates PrintWriter object to Output to File
            PrintWriter fileOutput = new PrintWriter(fileName);
            //Prints out Header
            fileOutput.println("ID\tYEAR HIRED\tTITLE\t\tBASE SALARY\tCOMPENSATION");	
            //Print out all Information that was separated by commas
            for(int i=0; i<employeeList.size(); i++) {
                fileOutput.printf(employeeList.get(i).EmployeeSummary());
                fileOutput.printf(employeeList.get(i).toString());
            }		
            //Prints out Dividing Line
            fileOutput.println("-------------------------------------\r\n");
            //Find and Print out All Manager Employees
            for(int i=0; i<employeeList.size(); i++) {
                if(!(employeeList.get(i).EndingSummary().equals("null"))) {
                    fileOutput.printf(employeeList.get(i).EndingSummary());
		}
            }
            fileOutput.println("\r\nGoodbye.");	
            //Closes fileOutPut object
            fileOutput.close();	
            /**
            * Outputs identical information onto the console
            */
            //Prints out Header
            System.out.println("ID\tYEAR_HIRED\tTITLE\t\tBASE_SALARY\t\tCOMPENSATION");	
            //Print out all Information that was separated by commas
            for(int i=0; i<employeeList.size(); i++) {
                System.out.println(employeeList.get(i).EmployeeSummary());
		System.out.println(employeeList.get(i).toString());
            }	
            //Prints out Dividing Line
            System.out.println("----------------------------------------------\n");
            //Find and Print out All Manager Employees
            for(int i=0; i<employeeList.size(); i++) {
                if(!(employeeList.get(i).EndingSummary().equals("null"))) {
                    System.out.println(employeeList.get(i).EndingSummary());
		}
            }
            System.out.println("\nGoodbye.");		
	}
}