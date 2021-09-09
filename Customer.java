import java.text.*;
/*This is the customer class*/
public class Customer
{
    private String custName;
    private String custId;
    private String cLocation;
    private String cPhoneNum;
    private String bookDate;
    private double startTime;
    private double payment;
    DecimalFormat df = new DecimalFormat("0.00");
    
    public Customer (String custName, String custId, String cLocation, String cPhoneNum, String bookDate, double startTime, double payment)
    {
        this.custName = custName;
        this.custId = custId;
        this.cLocation = cLocation;
        this.cPhoneNum = cPhoneNum;
        this.bookDate = bookDate;
        this.startTime = startTime;
        this.payment = payment;
    }
    
    public void setAll (String custName, String custId, String cLocation, String cPhoneNum, String bookDate, double startTime, double payment)
    {
        this.custName = custName;
        this.custId = custId;
        this.cLocation = cLocation;
        this.cPhoneNum = cPhoneNum;
        this.bookDate = bookDate;
        this.startTime = startTime;
        this.payment = payment;
    }
    
    public String getCustName()
    {
        return custName;
    }
    
    public String getCustId()
    {
        return custId;
    }
    
    public String getCLocation()
    {
        return cLocation;
    }
    
    public String getCPhoneNum()
    {
        return cPhoneNum;
    }
    
    public String getBookDate()
    {
        return bookDate;
    }
    
    public double getStartTime()
    {
        return startTime;
    }
    
    public double getPayment()
    {
        return payment;
    }
    
    public String toString ()
    {
        return (custName + "\t" + custId + "\t\t" + cLocation + "\t" + cPhoneNum + "\t" + bookDate + "\t" + df.format(startTime) + "\t\t" + df.format(payment));
    }
}
