package concurrencyPractice;

import java.io.*;
import java.util.*;

//Simple example of using "synchronized" methods//

public class FirstConcurrencyTask{

    static private Map<String, String> syncMap = new HashMap<>();

    public static void main() {
        ThreadOne threadOne = new ThreadOne("filesWithLogPas/fileOne.txt");
        ThreadOne threadTwo = new ThreadOne("filesWithLogPas/fileTwo.txt");
        ThreadOne threadThree = new ThreadOne("filesWithLogPas/fileThree.txt");
        ThreadOne threadFour = new ThreadOne("filesWithLogPas/fileFour.txt");
        threadOne.start();
        threadTwo.start();
        threadFour.start();
        threadThree.start();
    }

    public synchronized static void placeInMap(String name, String password)
    {
        syncMap.put(name, password);
    }

    public static Map<String, String> getResultMap()
    {
        int tempCounter = 0;
//        syncMap.forEach((l, p) -> System.out.println("Login: " + l + ", password: " + p));
        for(Map.Entry<String, String> printer : syncMap.entrySet())
        {
            tempCounter++;
            System.out.println(tempCounter + ". Login: " + printer.getKey() + ", password: " + printer.getValue());
        }
        return syncMap;
    }


}

class ThreadOne extends Thread
{
    private String path;
    private boolean append;

    public ThreadOne(String path)
    {
        this.path = path;
    }

    private ThreadOne(){}

    @Override
    public void run()
    {
        List<String[]> list = new ArrayList<>(takeFromFile(path));
        for(int i = 0; i< list.size(); i++)
        {
            FirstConcurrencyTask.placeInMap(list.get(i)[0], list.get(i)[1]);
        }
        System.out.println("Thread " + Thread.currentThread().getName() + " have finished!");
        FirstConcurrencyTask.getResultMap();
    }

    private List<String[]> takeFromFile(String path)
    {
        List<String[]> resultList = new ArrayList<>();
        try(Reader reader = new FileReader(path); BufferedReader bufferedReader = new BufferedReader(reader))
        {
            String takedString = bufferedReader.readLine();

            while(takedString != null)
            {

                String[] temp = takedString.split(":");
                resultList.add(temp);
                takedString = bufferedReader.readLine();
                loggingChecked(); // logging that thread working. I like to watch what doings when application executing
            }

            return resultList;

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return resultList;
    }

    public void printRsultList(List<String[]> list)
    {
        for(String[] massive : list )
        {
            System.out.println(Arrays.toString(massive));
        }
    }

    private void logging(boolean append) throws Exception
    {
            FileWriter writer = new FileWriter("src/concurrencyPractice/threadLogging.txt", append);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(Thread.currentThread().getName() + " working with " + path);
            bufferedWriter.newLine();
            bufferedWriter.close();
    }


    private void loggingChecked() throws Exception
    {
        if(append)
        {
            logging(true);
        } else
        {
            logging(false);
            append = true;
        }
    }

}
