import java.util.*;
import java.io.*;
import java.text.*;

public class Main
{
    public  static void main(String[] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
        in.useDelimiter("\n");
        DecimalFormat df = new DecimalFormat("00.00");
        
        FileReader fr = new FileReader("Customer.txt");
        BufferedReader br = new BufferedReader(fr);
        FileReader fr2 = new FileReader("Employee.txt");
        BufferedReader br2 = new BufferedReader(fr2);
        
        LinkedListCustomer customerList = new LinkedListCustomer();
        LinkedListCustomer custBefore = new LinkedListCustomer();
        LinkedListEmployee employeeList = new LinkedListEmployee();
        
        String inData;
        //Customer
        String custName, custId, cLocation, cPhoneNum, bookDate, presentDate;
        double startTime, payment;
        //Employee
        String empName, empID, eLocation, ePhoneNum;
        double workHours, hourlyRate, empSalary = 0;
        
        System.out.print("-------------------------------------Cleaning Service Management System-------------------------------------");
        System.out.print("\n\nEnter today's date [dd/mm/yyyy]: ");
        presentDate = in.next();
        
        //insert data from Customer.txt to customerList
        while ((inData = br.readLine()) != null)
        {
            StringTokenizer input = new StringTokenizer (inData,":");
            custName = input.nextToken();
            custId = input.nextToken();
            cLocation = input.nextToken();
            cPhoneNum = input.nextToken();
            bookDate = input.nextToken();
            startTime = Double.parseDouble(input.nextToken());
            payment = Double.parseDouble(input.nextToken());
            
            Customer cust = new Customer (custName, custId, cLocation, cPhoneNum, bookDate, startTime, payment);
            customerList.insertAtBack(cust);
        }
        
        //insert data from Employee.txt to employeeList
        while ((inData = br2.readLine()) != null)
        {
            StringTokenizer input = new StringTokenizer (inData,":");
            empName = input.nextToken();
            empID = input.nextToken();
            eLocation = input.nextToken();
            ePhoneNum = input.nextToken();
            workHours = Double.parseDouble(input.nextToken());
            hourlyRate = Double.parseDouble(input.nextToken());
            
            Employee emp = new Employee (empName, empID, eLocation, ePhoneNum, workHours, hourlyRate);
            employeeList.insertAtBack(emp);
        }
       
        System.out.print("\n------------------------------------------------------------------------------------------------------------");
        System.out.print("\n--------------------------------------------CUSTOMER INFORMATION--------------------------------------------");
        System.out.print("\n------------------------------------------------------------------------------------------------------------");
        Customer objC;
        System.out.print("\nList of customer information: ");
        System.out.print("\nCustomer Name" + "\tCustomer ID" + "\tLocation" + "\tPhone Number" + "\tBook Date" + "\tStart Time" + "\tPayment (RM)");
        objC = (Customer)customerList.getFirst();
        while(objC != null)
        {
            System.out.print("\n" + objC.toString());
            objC = (Customer)customerList.getNext();
        }
        System.out.print("\n------------------------------------------------------------------------------------------------------------");
        
        //To sort customer based on their name
        System.out.print("\nList of customer based on name in ascending order: ");
        System.out.print("\nCustomer Name" + "\tCustomer ID" + "\tLocation" + "\tPhone Number" + "\tBook Date" + "\tStart Time" + "\tPayment (RM)");
        customerList.sortCust();
        objC = (Customer)customerList.getFirst();
        while(objC != null)
        {
            System.out.print("\n" + objC.toString());
            objC = (Customer)customerList.getNext();
        }
        System.out.print("\n------------------------------------------------------------------------------------------------------------");
        
      
        //To delete the customer information after the present date
        int cnt = 0;
        LinkedListCustomer newCustList = new LinkedListCustomer();
        Queue queueCust = new Queue();
        while(!customerList.isEmpty())
        {
            objC = (Customer)customerList.removeFromFront();
            if(Integer.parseInt(objC.getBookDate().substring(0,2)) > Integer.parseInt((presentDate.substring(0,2))))
            {
                newCustList.insertAtBack(objC);
                queueCust.enqueue(objC);
                cnt++;
            }
            else
            {
                custBefore.insertAtBack(objC);
            }
        }
        
        System.out.print("\nList of customer information before " + presentDate);
        System.out.print("\nCustomer Name" + "\tCustomer ID" + "\tLocation" + "\tPhone Number" + "\tBook Date" + "\tStart Time" + "\tPayment (RM)");
        objC = (Customer)custBefore.getFirst();
        while(objC != null)
        {
            System.out.print("\n" + objC.toString());
            objC = (Customer)custBefore.getNext();
        }
        System.out.print("\n------------------------------------------------------------------------------------------------------------");
        
        System.out.print("\nList of customer information after " + presentDate);
        System.out.print("\nCustomer Name" + "\tCustomer ID" + "\tLocation" + "\tPhone Number" + "\tBook Date" + "\tStart Time" + "\tPayment (RM)");
        objC = (Customer)newCustList.getFirst();
        while(objC != null)
        {
            System.out.print("\n" + objC.toString());
            objC = (Customer)newCustList.getNext();
        }
        System.out.print("\n------------------------------------------------------------------------------------------------------------");
        
        //To find the highest payment made by the customer
        Queue temp = new Queue();
        Customer high;
        high = (Customer)queueCust.dequeue();
        temp.enqueue(high);
        double max = high.getPayment();
        while(!queueCust.isEmpty())
        {
            objC = (Customer)queueCust.dequeue();
            if(objC.getPayment() > max)
            {
                max = objC.getPayment();
                high = objC;
            }
        }
        System.out.print("\nThe highest payment made by a customer is ");
        System.out.print("\nCustomer Name" + "\tCustomer ID" + "\tLocation" + "\tPhone Number" + "\tBook Date" + "\tStart Time" + "\tPayment (RM)");
        System.out.print("\n" + high.toString());
        while(!temp.isEmpty())
        {
            queueCust.enqueue(temp.dequeue());
        }
        System.out.print("\n------------------------------------------------------------------------------------------------------------");
        
        //To calculate total customer after present date
        //To calculate total sales and average sales for this month
        double totalSales = 0;
        objC = (Customer)newCustList.getFirst();
        while(objC != null)
        {
            totalSales = totalSales + objC.getPayment();
            objC = (Customer)newCustList.getNext();
        }
        System.out.print("\nTotal customer after " + presentDate + " is " + cnt + " customers");
        System.out.print("\nTotal sales for this month is RM" + df.format(totalSales));
        System.out.print("\nThe average sales for this month is RM" + df.format(totalSales/cnt));
        
        System.out.print("\n------------------------------------------------------------------------------------------------------------");
        System.out.print("\n--------------------------------------------EMPLOYEE INFORMATION--------------------------------------------");
        System.out.print("\n------------------------------------------------------------------------------------------------------------");
        Employee objE;
        double avg = 0;
        System.out.print("\nList of employee and salary for last month");
        System.out.print("\nEmployee Name" + "\tEmployee ID" + "\tLocation" + "\tPhone Number" + "\tWork Hours" + "\tHourly Rate" + "\tSalary (RM)");
        objE = (Employee)employeeList.getFirst();
        
        //To calculate employee salary base on employee workHours and hourlyRate
        while(objE != null)
        {
            if(objE.getWorkHours() > 156)
            {
                empSalary = objE.getWorkHours() * objE.getHourlyRate();
                empSalary = empSalary + (objE.getWorkHours()+(objE.getWorkHours() - 156) * 5);
            }
            
            else
            {
                empSalary = objE.getWorkHours() * objE.getHourlyRate();
            }
            System.out.print("\n" + objE.toString() + "\t\t" + df.format(empSalary));
            avg = avg + empSalary;
            objE = (Employee)employeeList.getNext();
        }
        System.out.print("\n------------------------------------------------------------------------------------------------------------");
        
        Queue empList = new Queue();
        int count = 0;
        objE = (Employee)employeeList.getFirst();
        
        //To count average salary of employee for this month 
        //To count employee who work more than 156 hours per month
        while(objE != null)
        {
            if(objE.getWorkHours() > 156)
            {
                count++;
            }
            //empList.enqueue(objE);
            objE = (Employee)employeeList.getNext();
        }
      
        System.out.print("\nThe average salary of employee is: RM" + df.format(avg/10));
        System.out.print("\nThe number of employee who work more than 156 hours per month is " + count);
        System.out.print("\n------------------------------------------------------------------------------------------------------------");
        
        
        //To search Employee id and update their new work hours
        String option = "Yes";
        while(option.equalsIgnoreCase("Yes"))
        {
            System.out.print("\nEnter an Employee Id : ");
            String searchId = in.next();
            System.out.print("Enter new work hours : ");
            double newWorkHours = in.nextDouble();
            employeeList.updateEmp(searchId, newWorkHours);
            System.out.print("\nDo you want to search and update another employee? [Yes/No] :");
            option = in.next();
        }
        System.out.print("\n------------------------------------------------------------------------------------------------------------");
        
        System.out.print("\nEmployee list after update: ");
        System.out.print("\nEmployee Name" + "\tEmployee ID" + "\tLocation" + "\tPhone Number" + "\tWork Hours" + "\tHourly Rate" + "\tSalary (RM)");
        objE = (Employee)employeeList.getFirst();
        double total = 0;
        while(objE != null)
        {
            if(objE.getWorkHours() > 156)
            {
                empSalary = objE.getWorkHours() * objE.getHourlyRate();
                empSalary = empSalary + (objE.getWorkHours()+(objE.getWorkHours() - 156) * 5);
            }
            
            else
            {
                empSalary = objE.getWorkHours() * objE.getHourlyRate();
            }
            System.out.print("\n" + objE.toString() + "\t\t" + df.format(empSalary));
            objE = (Employee)employeeList.getNext();
            total = total + empSalary;
            
        }
        System.out.print("\n------------------------------------------------------------------------------------------------------------");
        
        objE = (Employee)employeeList.getFirst();
        int count2 = 0;
        while(objE != null)
        {
            if(objE.getWorkHours() > 156)
            {
                count2++;
            }
            empList.enqueue(objE);
            objE = (Employee)employeeList.getNext();
        }
      
        System.out.print("\nThe average salary of employee is: RM" + df.format(total/10));
        System.out.print("\nThe number of employee who work more than 156 hours per month is " + count2);
        System.out.print("\n------------------------------------------------------------------------------------------------------------");
        
        //To find lowest salary for the employee by their work hours
        Employee low;
        low = (Employee)empList.dequeue();
        temp.enqueue(low);
        double min = low.getWorkHours();
        while(!empList.isEmpty())
        {
            objE = (Employee)empList.dequeue();
            if(objE.getWorkHours() < min)
            {
                min = objE.getWorkHours();
                low = objE;
            }
        }
        
        System.out.print("\nThe lowest salary for the employee is ");
        System.out.print("\nEmployee Name" + "\tEmployee ID" + "\tLocation" + "\tPhone Number" + "\tWork Hours" + "\tHourly Rate" + "\tSalary (RM)");
        System.out.print("\n" + low.toString() + "\t\t" + df.format((low.getWorkHours() * low.getHourlyRate())));
        while(!temp.isEmpty())
        {
            empList.enqueue(temp.dequeue());
        }
        System.out.print("\n------------------------------------------------------------------------------------------------------------");
        /*Made by 
         * Siti Alieana Shahda Binti Sheikh Ali
         * Ayunni Natasya Binti Mohd Noor
         * Nurul Hanani Binti Mohd Adan
         * From JCS1104K
         */
    }
}
