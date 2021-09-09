import java.util.*;
public class LinkedListCustomer
{
    private ListNodeCustomer firstNode;
    private ListNodeCustomer lastNode;
    private ListNodeCustomer currNode;
    
    public LinkedListCustomer()
    {
        firstNode = lastNode = currNode = null;

    }
    
    public void insertAtFront(Customer insertItem)
    {
        if(isEmpty())
        {
            firstNode = lastNode = new ListNodeCustomer(insertItem);
        }
        else
        {
            firstNode = new ListNodeCustomer(insertItem, firstNode);
        }
    }
    
        public void insertAtBack(Customer insertItem)
    {
        if(isEmpty())
            firstNode = lastNode = new ListNodeCustomer(insertItem);
        else
            lastNode = lastNode.next = new ListNodeCustomer(insertItem);
    }
    
    public Customer removeFromFront()throws EmptyListException
    {
        Customer removeItem = null;
        if(isEmpty())
        {
            throw new EmptyListException();
        }
        
        removeItem = firstNode.data; 
        
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
    public Customer getFirst()
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
    public Customer getNext()
    {
        if(currNode != lastNode)
        {
            currNode = currNode.next;
            return currNode.data;
        }
        else
        {
            return null;
        }
    }
    
    public void sortCust ()
    {
        ListNodeCustomer currNode = firstNode;
        ListNodeCustomer index = null;
        Customer temp;
        Customer a;
        Customer b;
        
        if(firstNode == null)
        {
            return;
        }
        else
        {
            while(currNode != null)
            {
                index = currNode.next;
                while(index != null)
                {
                    a = (Customer)index.data;
                    b = (Customer)currNode.data;
                    if((b.getCustName()).compareTo(a.getCustName())>0)
                    {
                        temp = currNode.data;
                        currNode.data = index.data;
                        index.data = temp;
                    }
                    index = index.next;
                }
                currNode = currNode.next;
            }
        }
    }
}

