public class LinkedListEmployee
{
    private ListNodeEmployee firstNode;
    private ListNodeEmployee lastNode;
    private ListNodeEmployee currNode;
    
    public LinkedListEmployee()
    {
        firstNode = lastNode = currNode = null;

    }
    
    public void insertAtFront(Employee insertItem)
    {
        if(isEmpty())
        {
            firstNode = lastNode = new ListNodeEmployee(insertItem);
        }
        else
        {
            firstNode = new ListNodeEmployee(insertItem, firstNode);
        }
    }
    
        public void insertAtBack(Employee insertItem)
    {
        if(isEmpty())
            firstNode = lastNode = new ListNodeEmployee(insertItem);
        else
            lastNode = lastNode.next = new ListNodeEmployee(insertItem);
    }
    
    public Employee removeFromFront()throws EmptyListException
    {
        Employee removeItem = null;
        if(isEmpty())
        {
            throw new EmptyListException();
        }
        
        removeItem = firstNode.data; //retrieve the data
   
        //reset the firstNode and lastNode references
        if(firstNode.equals(lastNode))
        {
            firstNode = lastNode = null;
        }
        else
        {
            firstNode = firstNode.next;
        }
        return removeItem;
    }
    
    public boolean isEmpty()
    {
        return firstNode == null;
    }
    
    //return first element
    public Employee getFirst()
    {
        if(isEmpty())
            return null;
        else
        {
            currNode = firstNode;
            return currNode.data;
        }
    }
    
   //return the next element
    public Employee getNext()
    {
        if(currNode != lastNode)
        {
            currNode = currNode.next;
            return currNode.data;
        }
        else
            return null;
    }
    
    public void updateEmp (String searchId, double wh)
    {
        ListNodeEmployee currNode = firstNode;
        Employee d;
        while(currNode != null)
        {
            d = (Employee)currNode.data;
            if(d.getEmpId().equalsIgnoreCase(searchId))
            {
                d.setWorkHours(wh);
            }
            currNode = currNode.next;
        }
    }
}
