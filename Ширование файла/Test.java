import java.io.*;

// Шифрование и дешифрование файла.

public class Test
{
    private final int ENCRYPTION_OR_DECRYPTION = 0;
    private final int NAME_OF_FILE_TO_ENCRYPT_OR_DECRYPT = 1;
    private final int NAME_OF_FILE_TO_WRITE_RESULT_TO = 2;

    public static void main(String[] args)
    {
        try
        {
            new Test().checkingSetOfParameters(args);
        } catch (IOException e) { e.printStackTrace(); }
    }

    public void checkingSetOfParameters(String [] setOfParameters) throws IOException
    {
        if (setOfParameters == null || setOfParameters.length < 3)
        {
            throw new IllegalArgumentException();
        }
        else
        {
            this.encryptingAndDecryptingFileData(setOfParameters);
        }
    }

    private void encryptingAndDecryptingFileData(String [] setOfParameters) throws IOException
    {
        switch (setOfParameters[ENCRYPTION_OR_DECRYPTION])
        {
            case "-e":
                encryptDataFile(setOfParameters[NAME_OF_FILE_TO_ENCRYPT_OR_DECRYPT], setOfParameters[NAME_OF_FILE_TO_WRITE_RESULT_TO]);
                break;

            case "-d":
                decryptDataFile(setOfParameters[NAME_OF_FILE_TO_ENCRYPT_OR_DECRYPT], setOfParameters[NAME_OF_FILE_TO_WRITE_RESULT_TO]);
                break;

            default:
                throw new IllegalArgumentException();
        }

    }

    private static void encryptDataFile(String fileName, String fileOutputName) throws IOException
    {
        try(BufferedInputStream fileToEncrypt = new BufferedInputStream(new FileInputStream(fileName));
            BufferedOutputStream resultOfFileEncryption = new BufferedOutputStream(new FileOutputStream(fileOutputName)))
        {
            while(fileToEncrypt.available() > 0)
            {
                resultOfFileEncryption.write(fileToEncrypt.read() * 2);
            }
        }
    }

    private static void decryptDataFile(String fileName, String fileOutputName) throws IOException
    {
        try(BufferedInputStream fileToDecrypt = new BufferedInputStream(new FileInputStream(fileName));
        BufferedOutputStream resultOfFileDecryption = new BufferedOutputStream(new FileOutputStream(fileOutputName)))
        {
            while(fileToDecrypt.available() > 0)
            {
                resultOfFileDecryption.write(fileToDecrypt.read() / 2);
            }
        }
    }
}                                                  
                                                  
                                                  
                                                  
                                                  
                                                  
                          