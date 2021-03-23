package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client
{
    public static final String NAME_OBJECT = "object";


    public static void main(String[] args) throws Exception
    {
        Registry registry = LocateRegistry.getRegistry(1099);
        Math object = (Math) registry.lookup(NAME_OBJECT);

        System.out.println(object.sum(1, 2, 3, 4, 5));
    }
}
