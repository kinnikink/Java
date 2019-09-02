public class JuniorEmployee  extends Employee implements EmployeeCompensation{
    double commission;	
    
    public JuniorEmployee (int employeeID, int hiredYear, double BaseSalary, double Commission){
        setID(employeeID);
        setYearHired(hiredYear);
	setBaseSalary(BaseSalary);
	setCommission(Commission);
    }
    public void setCommission(double Commission){
        commission = Commission;
    }
    public double getCommission(){
        return commission;
    }
    //EmployeeSummary string method extracts important information from file and arranges them
    //in this order: ID, Year Hired, Base Salary, Total Compensation (line 32)
	
    public String EmployeeSummary(){
        return String.format("%d\t%d\t\tJunior\t\t$%,.2f\t\t$%,.2f\r\n", getID(), getYearHired(), getBaseSalary(), CalculateTotalCompensation());
    }
    //Produces a general print Summary based on information compiled in line 23
	
    public String toString() {
        return String.format("This is a junior employee. ID is %d, hired since %d, and commission is $%,.2f.\r\n", 
                              getID(), getYearHired(), getCommission());
	}
	//Calculation for Junior Employee Total Compensation: Commission + Base Salary
	
    public double CalculateTotalCompensation(){
        setTotalCompensation(getCommission() + getBaseSalary());
	return getTotalCompensation();
    }
}