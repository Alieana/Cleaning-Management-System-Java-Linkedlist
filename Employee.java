import java.text.*;
/*This is the employee class*/
public class Employee
{
    private String empName;
    private String empId;
    private String eLocation;
    private String ePhoneNum;
    private double workHours;
    private double hourlyRate;
    DecimalFormat df = new DecimalFormat("0.00");
    
    public Employee(String empName, String empId, String eLocation, String ePhoneNum, double workHours, double hourlyRate)
    {
        this.empName = empName;
        this.empId = empId;
        this.eLocation = eLocation;
        this.ePhoneNum = ePhoneNum;
        this.workHours = workHours;
        this.hourlyRate = hourlyRate;
    }
    
    public void setAll(String empName, String empId, String eLocation, String ePhoneNum, double workHours, double hourlyRate)
    {
        this.empName = empName;
        this.empId = empId;
        this.eLocation = eLocation;
        this.ePhoneNum = ePhoneNum;
        this.workHours = workHours;
        this.hourlyRate = hourlyRate;
    }
    
     public String getEmpName()
    {
        return empName;
    }
    
    public String getEmpId()
    {
        return empId;
    }
    
    public String getELocation()
    {
        return eLocation;
    }
    
    public String getEPhoneNum()
    {
        return ePhoneNum;
    }

    public double getWorkHours()
    {
        return workHours;
    }
    
    public double getHourlyRate()
    {
        return hourlyRate;
    }
    
    public void setWorkHours (double workHours)
    {
        this.workHours = workHours;
    }
    
    public String toString ()
    {
        return (empName + "\t" + empId + "\t\t" + eLocation + "\t" + ePhoneNum + "\t" + df.format(workHours) + "\t\t" + df.format(hourlyRate));
    }
}
