package testing.collections.own;

import collections.own.hashMap.OwnHashMap;
import org.junit.Test;

import java.util.Random;

public class OwnHashMapTesting {
    private final int HASH_MAP_SIZE = 512;

    @Test
    public void randomTest() {

        OwnHashMap ownHashMap = new OwnHashMap(HASH_MAP_SIZE);

        int key;
        long value;
        Random random = new Random();

        int [] keys = new int[HASH_MAP_SIZE];

        for(int i =0 ; i < HASH_MAP_SIZE; i++)
        {
            key = random.nextInt();// i;
            value = random.nextLong();// (long) i;

            keys[i] = key;

            System.out.println("key: " + key);
            System.out.println("value: " + value);

            ownHashMap.put(key, value);
        }

        System.out.println("--------------");
        for(int i = 0; i < HASH_MAP_SIZE; i++)
        {
            System.out.println(ownHashMap.get(keys[i]));
        }
        System.out.println("--------------");

        ownHashMap.showFullMap();
    }

    @Test
    public void timeMeasuring()
    {
        long time_start;
        long time_finish = 0;

        OwnHashMap ownHashMap = new OwnHashMap(HASH_MAP_SIZE);

        int key;
        long value;
        Random random = new Random();
        int[] keys = new int[HASH_MAP_SIZE];

        for(int i = 0; i < HASH_MAP_SIZE; i++)
        {
            key = random.nextInt();
            value = random.nextLong();
            keys[i] = key;

            time_start = System.currentTimeMillis();
            ownHashMap.put(key, value);
            time_finish += System.currentTimeMillis() - time_start;
        }

        System.out.println("-----------!------------");
        System.out.println("Time of random filling: " + time_finish);
        System.out.println("-----------!------------");

        int temp;
        for(int i = 0; i < HASH_MAP_SIZE; i++)
        {
            temp = keys[i];

            time_start = System.nanoTime();
            ownHashMap.get(temp);
            time_finish = System.nanoTime() - time_start;

            System.out.println(time_finish);
        }
        /*
        Time of getting elements not constant because inside of method,
        going calculation of index and creating Node for search.
         */
    }

    @Test
    public void sameKey()
    {
        long time_start;
        long time_finish = 0;
        OwnHashMap ownHashMap = new OwnHashMap(HASH_MAP_SIZE);

        for(int i = 0; i<HASH_MAP_SIZE; i++)
        {
            ownHashMap.put(-100, i);
        }

        //ownHashMap.showFullMap();

        for(int i = 0; i < HASH_MAP_SIZE; i++)
        {

            time_start = System.nanoTime();
            ownHashMap.get(-100);
            time_finish = System.nanoTime() - time_start;

            System.out.println(time_finish);
        }
    }
}
