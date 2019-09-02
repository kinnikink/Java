public abstract class Employee {

    private String eName, eNum, hireDate;

    public Employee(String eName, String eNum, String hireDate){
        this.eName = eName;
        this.eNum = eNum;
        this.hireDate = hireDate;
    }
    public void setEName(String eName){
        this.eName = eName;
    }
    public String getEName(){
        return eName;
    }

    public void setENum(String eNum){
        this.eNum = eNum;
    }
    public String getENum(){
        return eNum;
    }

    public void setHireDate(String hireDate){
        this.hireDate = hireDate;
    }
    public String getHireDate(){
        return hireDate;
    }
}
