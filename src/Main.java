import concurrencyPractice.FirstConcurrencyTask;

public class Main{
    public static void  main(String[] args)
    {
        try {
            //CollectionsPractice.hashSetPractice();
            //CollectionsPractice.treeSetPractice();
            //CollectionsPractice.researchOfLists();
            //CollectionsPractice.mapPractice();
            //ReflectionPractice.reflPract();
            //CollectionsPractice.letsStream();

//            FileSystem fileSystem = new FileSystem();
//            fileSystem.menu();
//            CollectionsPractice.letsStream2();

            //filling files
//            FileIO.practDBwFiller("filesWithLogPas/fileOne.txt", 100);
//            FileIO.practDBwFiller("filesWithLogPas/fileTwo.txt", 80);
//            FileIO.practDBwFiller("filesWithLogPas/fileThree.txt", 300);
//            FileIO.practDBwFiller("filesWithLogPas/fileFour.txt", 50);


            FirstConcurrencyTask.main();


        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}
