import java.io.*;
import java.util.*;

// Подсчет символов текстового документа и вывод их на экран.

public class Test1
{
    public static void main(String[] args) throws IOException
    {
        countCharacters(args[0]);
    }

    public static void countCharacters(String fileName) throws IOException
    {
        HashMap<Integer, Integer> byteAndNumberOfRepetitions = new HashMap<>();

        try(BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(fileName))))
        {
            readDataFromFileToMap(file, byteAndNumberOfRepetitions);

            Set<Integer> setKeys = byteAndNumberOfRepetitions.keySet();
            ArrayList<Integer> listKeys = new ArrayList<>(setKeys);
            Collections.sort(listKeys);

            printNumberOfCharacters(listKeys, byteAndNumberOfRepetitions);
        }
    }

    private static void readDataFromFileToMap(BufferedReader file, HashMap<Integer, Integer> byteAndNumberOfRepetitions) throws IOException
    {
        int currentByte;

        while ((currentByte = file.read()) != -1)
        {
            if (byteAndNumberOfRepetitions.containsKey(currentByte))
            {
                byteAndNumberOfRepetitions.replace(currentByte, byteAndNumberOfRepetitions.get(currentByte) + 1);
            }
            else
            {
                byteAndNumberOfRepetitions.put(currentByte, 1);
            }
        }
    }

    private static void printNumberOfCharacters(ArrayList<Integer> listKeys, HashMap<Integer, Integer> byteAndNumberOfRepetitions)
    {
        for (int iterator = 0; iterator < listKeys.size(); iterator++)
        {
            int character = listKeys.get(iterator);
            int numberOfRepetitions = byteAndNumberOfRepetitions.get(listKeys.get(iterator));

            System.out.println((char) character + " " + numberOfRepetitions);
        }
    }
}












