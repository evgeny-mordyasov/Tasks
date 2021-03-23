package RMI;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server
{
    public static final String NAME_OBJECT = "object";


    public static void main(String[] args) throws Exception
    {
        Registry registry = LocateRegistry.createRegistry(1099);
        Remote stub = UnicastRemoteObject.exportObject(new Calculator(), 0);

        registry.rebind(NAME_OBJECT, stub);
    }
}
