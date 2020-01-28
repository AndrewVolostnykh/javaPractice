import basics.*;

public class Main{
    public static void  main(String[] args)
    {
        try {
            HelloConsole.helloConsole();
            //CollectionsPractice.hashSetPractice();
            //CollectionsPractice.treeSetPractice();
            //CollectionsPractice.researchOfLists();
            //CollectionsPractice.mapPractice();
            //ReflectionPractice.reflPract();
            //CollectionsPractice.letsStream();

//            FileSystem fileSystem = new FileSystem();
//            fileSystem.menu();
            CollectionsPractice.letsStream2();


        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}
