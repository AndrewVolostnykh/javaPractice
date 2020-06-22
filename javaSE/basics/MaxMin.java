package javaSE.basics;

import java.util.Arrays;
import java.util.Random;

/**This class working only with one-dimensional arrays.
 * At start u must give to functions array. It will filled and after
 * found max/min/average/elementary integer numbers.
 */
public class MaxMin{

    public static int[] fillingArray(int[] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            array[i] = -50 + new Random().nextInt(100);
        }
        System.out.println(Arrays.toString(array));
        return array;
    }

    public static int searchMax(int[] array)
    {
        int temp = 0;
        for(int i = 0; i < array.length; i++)
        {
            if(array[i] > temp)
            {
                temp = array[i];
            }
        }
        return temp;
    }

    public static int searchMin(int[] array)
    {
        int temp = array[0];
        for(int i = 0; i < array.length; i++)
        {
            if(temp > array[i])
            {
                temp = array[i];
            }
        }
        return temp;
    }

    public static int searchAverage(int[] array)
    {
        int avg = 0;
        for(int i = 0; i < array.length; i++)
        {
            avg += array[i]/array.length;
        }
        return avg;
    }

    public static void findElementary(int[] array)
    {
        System.out.print("[");
        for(int i = 0; i < array.length; i++)
        {
            if(array[i] % 2 == 0)
            {
                System.out.print(array[i] + " ");
            }
        }
        System.out.print("]");
    }
}