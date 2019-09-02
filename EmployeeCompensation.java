public interface EmployeeCompensation{
    /**
    * JuniorEmployee’s total compensation is baseSalary + commission | (inside JuniorEmployee Class)
    * SeniorEmployee’s total compensation is baseSalary + annualBonus | (inside SeniorEmployee Class)
    * Manager’s total compensation is baseSalary + stockDividend| (inside Manager Class)
    */	
    //CalculateTotalCompensation Method
    public double CalculateTotalCompensation();
}