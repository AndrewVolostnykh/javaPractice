package ionioStreams.scannerPractice;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Scanner;

public class ScannerPractice {
    private static String filePath = "practiceDir/practDB.txt";
    public static void scannerAndFile()
    {
        Scanner scanner = null;
        try{
            FileReader fr = new FileReader(filePath);
            scanner = new Scanner(fr);
            while(scanner.hasNext())
            {
                if(scanner.hasNextInt())
                {
                    System.out.println("Int: " + scanner.nextInt());
                } else System.out.println("String: " + scanner.next());
            }


        } catch (Exception e)
        {
            System.err.println("Exception " + e);
        } finally {
            if (scanner != null) scanner.close();
        }
    }

    public static void scannerAndInputStream() throws Exception
    {
        InputStream is = new FileInputStream(filePath);
        Scanner scanner = new Scanner(is);
        while(scanner.hasNext())
        {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }

    public static void scannerAndRegex() throws Exception
    {
        InputStream is = new FileInputStream("practiceDir/practDBn2.txt");
        Scanner scanner = new Scanner(is);
        while(scanner.hasNext())
        {
            String found = scanner.findInLine("[a-z]+:[a-z]+");
            if(found != null)
            {
                System.out.println("Successfully line: " + found);
            } else {
                System.err.println("Incorrect line expected!");
            }
            scanner.nextLine(); // on bottom of cycle because hasNext() taking a line, but if this method take a line too, wi will lose first line in document
        }
        scanner.close();
    }
}
