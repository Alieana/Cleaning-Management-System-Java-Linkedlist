public class ListNodeCustomer
{
   //package access data so class List can access it directly
   Customer data;
   ListNodeCustomer next;
   
   //Constructor: create a ListNodeCustomer that refer to Number o
   ListNodeCustomer(Customer o)
   {
       this(o, null);
   }
   
   //Constructor: create a ListNodeCustomer that refers to Number o and to the next ListNodeCustomer in the List
   ListNodeCustomer(Customer o, ListNodeCustomer nextNode)
   {
       data = o;
       next = nextNode;
    }
    
    //return a reference to the Number in this node
    Customer getData()
    {
        return data;
    }
    
    //return the next node
    ListNodeCustomer getNext()
    {
        return next;
    }
}
