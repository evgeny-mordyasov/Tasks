import java.io.*;

// Поиск информации в файле по индексу.

public class Test2
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        System.out.println(getInformationAboutProduct(fileName, Integer.parseInt(args[0])));
    }

    public static String getInformationAboutProduct(String fileName, int index) throws IOException
    {
        try(BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(fileName))))
        {
            String currentProduct;

            indexFound:
            while((currentProduct = file.readLine()) != null)
            {
                int indexFromFile = Integer.parseInt(currentProduct.substring(0, currentProduct.indexOf(" ")));

                if (index == indexFromFile)
                {
                    break indexFound;
                }
            }

            return currentProduct;
        }
    }
}
