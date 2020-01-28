package basics;

public class Sortings {
    public static int[] insertSorting(int[] array)
    {
        for (int left = 0; left < array.length; left++) {
            int value = array[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value < array[i]) {
                    array[i + 1] = array[i];
                } else {
                    break;
                }
            }
            array[i + 1] = value;
        }
        System.out.println("Insertion sort finished! ");
        return array;
    }

    public static int[] quickSorting(int[] array)
    {
        int startIndex = 0, endIndex = array.length - 1;

        quickFunctionSorting(startIndex, endIndex, array);
        System.out.println("Quick sort finished! ");

        return array;
    }

    private static void quickFunctionSorting(int startIndex, int endIndex, int[]array)
    {
        if (startIndex >= endIndex)
            return;
        int i = startIndex, j = endIndex;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (array[i] <= array[cur])) {
                i++;
            }
            while (j > cur && (array[cur] <= array[j])) {
                j--;
            }
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        quickFunctionSorting(startIndex, cur, array);
        quickFunctionSorting(cur+1, endIndex, array);
    }

}
