package my.tasks;

import java.util.HashMap;
import java.util.Map;

public class FrequencyVocabulary {
    public static void letterVocabulary(String text)
    {
        text.toLowerCase();
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < text.length(); i++)
        {
            char letter = text.charAt(i);

            if(letter >= 'a' && letter <= 'z')
            {
                map.compute(letter, (character, integer) -> integer == null ? 1 : integer+1);
            }
        }

        for(Map.Entry entry : map.entrySet())
        {
            System.out.println("Letter: " + entry.getKey() + ", frequency: " + entry.getValue());
        }
    }

    public static void wordVocabulary(String text)
    {
        text.toLowerCase();
        Map<String, Integer> map = new HashMap<>();
        String[] words = text.split(" ");

        for(int i = 0; i< words.length; i++)
        {
            String tempStr = words[i];
            map.compute(tempStr, (str, integer) -> integer == null ? 1 : integer+1);
        }

        for(Map.Entry entry : map.entrySet())
        {
            System.out.println("Letter: " + entry.getKey() + ", frequency: " + entry.getValue());
        }
    }

}
