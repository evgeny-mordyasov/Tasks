package notFinishedTasks;

import java.io.*;
import java.util.*;
import java.util.regex.*;

// Собираем файл.

public class Test3
{
    private static TreeSet<Integer> fileNumbers = new TreeSet<>();

    public static void main(String[] args) throws IOException
    {
        new Test3().readFileNames();
    }

    private void readFileNames() throws IOException
    {
        BufferedReader readFromConsole = new BufferedReader(new InputStreamReader(System.in));
        String fileName, previousNameOfFile = "";

        while(!(fileName = readFromConsole.readLine()).equals("end"))
        {
            readFileNumber(fileName);
            previousNameOfFile = fileName;
        }

        combineDataFiles(previousNameOfFile.substring(0, previousNameOfFile.indexOf(".part")));
    }

    private void readFileNumber(String fileName)
    {
            int fileNumber = getFileNumber(fileName);

            fileNumbers.add(fileNumber);
    }

    private int getFileNumber(String fileName)
    {
        Matcher matcher = Pattern.compile("\\d+$").matcher(fileName);
        int fileNumber = 0;

        if (matcher.find())
        {
            fileNumber = Integer.parseInt(fileName.substring(matcher.start(), matcher.end()));
        }

        return fileNumber;
    }

    private void combineDataFiles(String fileName) throws IOException
    {
        try(FileOutputStream toWriteToFile = new FileOutputStream(new File(fileName)))
        {
            for (int i = 1; i <= fileNumbers.size(); i++)
            {
                try(FileInputStream toReadFile = new FileInputStream(fileName + ".part" + i))
                {
                    byte [] bufferOfBytes = new byte[toReadFile.available()];
                    toReadFile.read(bufferOfBytes);
                    toWriteToFile.write(bufferOfBytes);
                }
            }
        }
    }
}
