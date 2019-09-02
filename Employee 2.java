import java.util.Scanner;

public class ProductionWorker extends Employee{
    private int shift;
    private double hourlyRate;

    ProductionWorker(int s, double rate)
    {
        super();
        shift = s;
        hourlyRate = rate;
    }

    ProductionWorker(String name, String number, int days, int s, double rate)
    {
        super(name, number, days);
        shift = s;
        hourlyRate = rate;
    }

    double getPaid()
    {
        return super.getDays()*this.hourlyRate*8.0;
    }

    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please input employee name:");
        String name = scanner.nextLine();
        System.out.println();
        System.out.print("Please input employee number:");
        String number = scanner.nextLine();
        System.out.println();
        System.out.print("Please input number of days employed:");
        int days = scanner.nextInt();
        System.out.println();
        System.out.print("Please input shift (day=1, night=2):");
        int shift = scanner.nextInt();
        System.out.println();
        double rate = 1.0;
        if (shift == 1)
        {
            System.out.print("Please enter day rate:");
            rate = scanner.nextDouble();
            System.out.println();
        }
        else if (shift == 2)
        {
            System.out.print("Please enter night rate:");
            rate = scanner.nextDouble();
            System.out.println();
        }
        else
            System.out.println("Shift should be either 1 or 2!");

        ProductionWorker pw = new ProductionWorker(name, number, days, shift, rate);
        System.out.println("Payment is "+ pw.getPaid());
    }
}
public class Employee {
    private String employeeName = "";
    private String employeeNumber = "";
    private int employeeDays = 0;
    
    Employee()
    {
        employeeName = "X";
        employeeNumber = "000-A";
        employeeDays = 0;
    }
    
    Employee(String name, String number, int days)
    {
        employeeName = name;
        employeeNumber = number;
        employeeDays = days;
    }
    
    public String getName()
    {
        return employeeName;
    }
    
    public String getNumber()
    {
        return employeeNumber;
    }
    
    public int getDays()
    {
        return employeeDays;
    }
    
    public void setName(String name)
    {
        employeeName = name;
    }
    
    public void setNumber(String number)
    {
        employeeNumber = number;
    }
    
    public void setDays(int days)
    {
        employeeDays = days;
    }
}
