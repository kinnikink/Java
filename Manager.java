public class Manager extends Employee implements EmployeeCompensation{
    double stockDividend;
    
    public Manager(int ID, int YearHired, double BaseSalary, double StockDividend){
        setID(ID);
	setYearHired(YearHired);
	setBaseSalary(BaseSalary);
	setStockDividend(StockDividend);
    }
    public void setStockDividend(double StockDividend){
        stockDividend = StockDividend;
    }
    public double getStockDividend(){
        return stockDividend;
    }
    //EmployeeSummary string method extracts important information from file and arranges them
    //in this order: ID, Year Hired, Base Salary, Total Compensation (line 31)
	
    public String EmployeeSummary(){
        return String.format("%d\t%d\t\tManager\t\t$%,.2f\t\t$%,.2f\r\n", getID(), getYearHired(), getBaseSalary(), CalculateTotalCompensation());
    }
    //Produces a general print Summary based on information compiled in line 22
	
    public String toString(){
        return String.format("This is a manager. ID is %d, hired since %d, and stock dividend is $%,.2f.\r\n", 
                              getID(), getYearHired(), getStockDividend());
    }
    //Calculation for Manager Employee Total Compensation: Stock Dividend + Base Salary
	
    public double CalculateTotalCompensation(){
        setTotalCompensation(getStockDividend() + getBaseSalary()) ;
	return getTotalCompensation();
    }
    //Once Managers are found, at the end of the program, 
    //This special message will be printed out for MANAGERS ONLY
    
    public String ShowDividend(){
        return String.format("Employee %d is a manager. Dividend is $%,.2f!\r\n", getID(), getStockDividend());
	}
    //PrintManagerDividend method returns ShowDividend value
    public String EndingSummary(){
        return ShowDividend();
    }
}