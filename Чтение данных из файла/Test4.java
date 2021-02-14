import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.*;

public class Test4
{
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException
    {
        if (args != null & args.length != 0)
        {
            fillListWithDataFromFile(args[0]);
        }
    }

    public static void fillListWithDataFromFile(String fileName) throws IOException, ParseException
    {
        ArrayList<String> dataFromFile = getDataFromFile(fileName);

        for (int iterator = 0; iterator < dataFromFile.size(); iterator++)
        {
            Person person = getPerson(dataFromFile, iterator);

            PEOPLE.add(person);
        }
    }

    private static ArrayList<String> getDataFromFile(String fileName) throws IOException
    {
        try(BufferedReader file = new BufferedReader(new FileReader(fileName)))
        {
            ArrayList<String> dataFromFile = new ArrayList<>();
            String lineData;

            while((lineData = file.readLine()) != null)
            {
                dataFromFile.add(lineData);
            }

            return dataFromFile;
        }
    }

    private static Person getPerson(ArrayList<String> dataFromFile, int iterator) throws ParseException
    {
        Matcher searchNameAndBirthDate = Pattern.compile("([a-zA-Zа-яА-Я -]*) ([\\d ]*)").matcher(dataFromFile.get(iterator));
        Person person = null;

        if (searchNameAndBirthDate.find())
        {
            String namePerson = searchNameAndBirthDate.group(1);
            String date = searchNameAndBirthDate.group(2);

            person = new Person(namePerson, new SimpleDateFormat("d M yyyy").parse(date));
        }

        return person;
    }
}


                                                  
                              