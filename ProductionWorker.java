public class ProductionWorker extends Employee{

private int shift, hoursWorked;
private double payRate;

public ProductionWorker(String eName, String eNum, String hireDate, int shift,
        int hoursWorked, double payRate) {
    super(eName, eNum, hireDate);
    this.setShift(shift);
    this.setPayRate(payRate);
    this.setHoursWorked(hoursWorked);
}

public int getShift() {
    return shift;
}
public void setShift(int shift) {
    this.shift = shift;
}

public int getHoursWorked() {
    return hoursWorked;
}
public void setHoursWorked(int hoursWorked) {
    this.hoursWorked = hoursWorked;
}


public double getPayRate() {
    return payRate;
}
public void setPayRate(double payRate) {
    this.payRate = payRate;
}

public String toString(){
    if (shift == 1){
        double pay = payRate * (int)hoursWorked;
        return "Employee name: " + getEName() + "\nEmployee number: " + getENum()
                + "\nHire date: " + getHireDate() + "\nShift: " + getShift() + 
                "\nHourly pay Rate: " + getPayRate() + "\nHours worked: " + getHoursWorked()
                + "\nPay for the week: " + pay + "\n";
    }
    else if (shift == 2){
        double pay = payRate * 1.25 * (int)hoursWorked;
        return "Employee name: " + getEName() + "\nEmployee number: " + getENum()
        + "\nHire date: " + getHireDate() + "\nShift: " + getShift() + 
        "\nHourly pay Rate: " + getPayRate() + "\nHours worked: " + getHoursWorked()
        + "\nPay for the week: " + pay + "\n";
    }
    else return "Invalid shift number.";
}
}