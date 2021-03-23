package RMI;

import java.rmi.RemoteException;
import java.util.Arrays;

public class Calculator implements Math
{
    @Override
    public double sum(double ... arrayOfNumbers) throws RemoteException
    {
        return Arrays.stream(arrayOfNumbers).sum();
    }
}
