public class EmptyListException extends RuntimeException
{
    public EmptyListException()
    {
        super("The list is empty");   
    }
}
