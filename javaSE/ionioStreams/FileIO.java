package javaSE.ionioStreams;

import javaSE.basics.StringToInt;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Important, in this class use next IO-classes: File, InputStream, OutputStream, Reader and Writer */

public class FileIO {

        public static void exOfSystem() throws Exception
        {
            byte[] bytes = new byte[1024];
            System.in.read(bytes);
            char[] arCharactersw = new char[bytes.length];
            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < bytes.length; i++)
            {
                arCharactersw[i] = (char)bytes[i];
            }
            builder.append(arCharactersw);
            System.out.println(builder + " ");
            System.err.print("Successfully! ");
        }

        public static void firstByteIO()
        {
            try(InputStream inputStream = new FileInputStream("myfile.txt");
                OutputStream outputStream = new FileOutputStream("newFile.txt", true)) // boolean param if true - new writes will add in end of file
            {
                byte[] buffer = new byte[4096];
                int r = inputStream.read(buffer);
                while( r != -1)
                {
                    outputStream.write(buffer, 0, r);
                    r = inputStream.read(buffer);
                }
                //reader.close();
                //writer.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static void firstCharIO()
        {
            try (Reader reader = new FileReader("_EasyPractice.iml");
            Writer writer = new FileWriter("result.iml"))
            {
                char[] buffer = new char[1024]; // we have take first 1024 symbols
                int c = reader.read(buffer); // put it into int variable
                while(c != -1) //loop to the end of file(-1)
                {
                    writer.write(buffer, 0, c); //if not end of file -- write to new file from int with size like a buffer
                    c = reader.read(); // read next
                }
                //reader.close();
                //writer.close();

            } catch(Exception e)
            {
                e.printStackTrace();
            }
        }

        public static String[] readerByLine(String path) throws Exception
        {
            String[] result = new String[50];
            FileInputStream inputStream = new FileInputStream(path); // считывание файла побайтно
            Reader reader = new InputStreamReader(inputStream, "cp1251"); // разбор потока посимвольно и с установленной кодировкой
            BufferedReader bufferedReader = new BufferedReader(reader); // разбор потока построчно методом данного класса

            String line = bufferedReader.readLine();
            /*while(line != null)
            {
                System.out.println(line);
                line = bufferedReader.readLine();

            }
            */
            for(int i = 0; i < result.length; i++)
            {
                if(line!=null)
                {
                    result[i] = line;
                    line = bufferedReader.readLine();

                } else {
                    break;
                }
            }
            bufferedReader.close();
            reader.close();
            inputStream.close();
            return result;
        }

        public static String[] fileSystemStudy() //work with files
        {
            File file = new File("practiceDir");

            FilenameFilter filenameFilter = (File f, String s) -> s.startsWith("gen");

            String[] namesArray = file.list(filenameFilter);

            for(String g: namesArray)
            {
                System.out.println(g);
            }
            return namesArray;
        }


        public static Map<String, String> practDBParser() throws Exception
        {
            Map<String, String> resultMap = new HashMap<>();

            Reader reader = new FileReader("practiceDir/practDB.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);

            String oneLine = bufferedReader.readLine();

            for(int i = 0; i<1000; i++)
            {
                if( oneLine != null)
                {
                    String[] resTemp = oneLine.split(":");
                    resultMap.put(resTemp[0], resTemp[1]);
                } else {
                    break;
                }
            }
            return resultMap;
        }

        public static void practDBwFiller(String path, int linesWrite) throws Exception
        {
            int counter = 0;
            BufferedWriter filler = new BufferedWriter(new FileWriter(path, true)); // append mode enabled in fileWriter constructor

            while(counter != linesWrite)
            {
                String input = StringToInt.randomString(8) + ":" + StringToInt.randomString(8);
                filler.write(input);

                filler.newLine();
                counter++;
            }
            filler.close();
        }


}
