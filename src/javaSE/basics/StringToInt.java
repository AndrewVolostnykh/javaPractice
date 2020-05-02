package javaSE.basics;

import java.util.Random;

public class StringToInt {

    public static int stringToInt(String s)
    {
        int result = 0;
        char[] characters = s.toCharArray();
        for(char ch : characters)
        {
            result += ch;
        }
        return result;
    }

    public static String randomString(int size)
    {
        StringBuilder result = new StringBuilder();
        Random random = new Random();
        char[] preString = new char[size];
        for(int i = 0; i < size; i++)
        {
            preString[i] =(char)(97 + random.nextInt(25)); //97 - 122

        }
        result.append(preString);
        return result + "";
    }

}
