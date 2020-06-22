package javaSE.ionioStreams;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FileSystem {
    // find file
    // create if no
    // write into file
    // show file in console ( type of output function is a list of lines(Strings) )

    public void menu()
    {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while(choice != -1)
        {
            menuView();
            System.out.print("Input your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // cleaning buffer of scanner
            switch(choice)
            {
                case 1:
                    System.out.println("\tFind files");
                    System.out.print("Input path (like asd/asd/asd): ");
                    String path = scanner.nextLine();
                    System.out.print("Input file name or extension: ");
                    String nameOfFile = scanner.nextLine();
                    String[] files = findFiles(path, nameOfFile);
                    System.out.println(Arrays.toString(files));
                    break;
                case 2:
                    System.out.println("Write in file");
                    System.out.print("Input path and name(asd/asd/asd.asd): ");
                    String pathName = scanner.nextLine();
                    if(writeIntoFile(pathName))
                        System.out.println("Successfully written!");
                    else System.out.println("Fail! ");
                    break;
                case 3:
                    System.out.println("Showing full file here");
                    System.out.print("Input path and name of file(asd/asd/asd.ex): ");
                    pathName = scanner.nextLine();
                    fileReader(pathName);
                    break;
            }
        }
        System.out.println("Good bye!");
    }

    private void menuView()
    {
        System.out.println("========MENU========");
        System.out.println("1: Find files in directory. ");
        System.out.println("2: Write in file. ");
        System.out.println("3: Show all file in console. ");
        System.out.println("-1: Exit!");
        System.out.println("====================");
    }

    private String[] findFiles(String path, String nameOfFile)
    {
        File file = new File(path);
        FilenameFilter filenameFilter = (File f, String s) -> s.startsWith(nameOfFile);
        String[] resultList = file.list(filenameFilter);
        return resultList;
    }

    private boolean writeIntoFile(String pathFileName)
    {
        Scanner scanner = new Scanner(System.in);
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(pathFileName, true));
            System.out.print("Input new text: ");
            String inputText = scanner.nextLine();
            writer.write(inputText);
            writer.newLine();
            writer.close();
            return true;
        } catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    private List<String> fileReader(String pathName)
    {
        List<String> resultList = new LinkedList<>();
        try {
            Reader reader = new FileReader(pathName);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String temp = bufferedReader.readLine();
            while(temp != null)
            {
                resultList.add(temp);
                temp = bufferedReader.readLine();
            }

            bufferedReader.close();

            resultList.forEach(s -> System.out.println(s));

        } catch(Exception e)
        {
            e.printStackTrace();
        }

        return resultList;
    }

}
