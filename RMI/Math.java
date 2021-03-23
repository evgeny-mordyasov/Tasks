package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Math extends Remote
{
    double sum(double ... arrayOfNumbers) throws RemoteException;
}
