 public class Employee{
    protected String employeeSummary;
    protected double compensation;
    protected int employeeID;
    protected double totalCompensation;
    protected int hiredYear;
    protected double employeeSalary;
	 
    public Employee() {
        employeeID = 0;
        totalCompensation = 0;
        hiredYear = 0;
	employeeSalary = 0;	
    }
    public String EndingSummary() {
        return "null";
    }	 
    public void setCompensation(double Compensation) {
        compensation = Compensation;
    }
    public void setID(int userID) {
        employeeID = userID;
    } 
    public void setTotalCompensation(double TotalCompensation) {
        totalCompensation = TotalCompensation;
    }
    public void setYearHired(int YearHired) {
        hiredYear = YearHired;
    }
    public void setBaseSalary(double BaseSalary) {
        employeeSalary = BaseSalary;
    }	
    public double getCompensation() {
        return compensation;
    }
    public int getID() {
        return employeeID;
    }
    public double getTotalCompensation() {
        return totalCompensation;
    }
    public int getYearHired() {
        return hiredYear;
    }
    public double getBaseSalary() {
        return employeeSalary;
    }
    public String EmployeeSummary() {
        return getID() +"\t"+getYearHired()+"\t"+getBaseSalary()+"\t"+getCompensation();
    }
    public String toString() {
        return employeeID +" "+ hiredYear +" "+ employeeSalary +" "+ totalCompensation;
    }	
}