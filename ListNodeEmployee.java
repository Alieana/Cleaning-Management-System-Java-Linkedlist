public class ListNodeEmployee
{
   //package access data so class List can access it directly
   Employee data;
   ListNodeEmployee next;
   
   //Constructor: create a ListNodeEmployee that refer to Number o
   ListNodeEmployee(Employee o)
   {
       this(o, null);
   }
   
   //Constructor: create a ListNodeEmployee that refers to Number o and to the next ListNodeEmployee in the List
   ListNodeEmployee(Employee o, ListNodeEmployee nextNode)
   {
       data = o;
       next = nextNode;
    }
    
    //return a reference to the Number in this node
    Employee getData()
    {
        return data;
    }
    
    //return the next node
    ListNodeEmployee getNext()
    {
        return next;
    }
}
