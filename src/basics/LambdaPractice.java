package basics;

interface Operation<T> {
    T operation(int n);
}

class OperationRealise {
    public static boolean isEven(int n)
    {
        return n%2 == 0;
    }

    public boolean isPositive(int n)
    {
        return n > 0;
    }
}

public class LambdaPractice{
    public static void main()
    {
        int[] a = new int[50];
        int sum = 0;

        MaxMin.fillingArray(a);

        //sum of even numbers in array
        System.out.println("Sum of even numbers: " + sum(a, OperationRealise::isEven));

        //sum of positive numbers
        OperationRealise operationRealise = new OperationRealise();
        System.out.println("Sum of positive numbers: " + sum(a, operationRealise::isPositive));

        // lets try some lambda expression. it will sum of all numbers
        Operation<Integer> operation = n -> { for(int i: a) { n += i; } return n; };
        System.out.println("Sum of all numbers: " + operation.operation(sum));
    }

    private static int sum(int[] a, Operation<Boolean> opertion){
        int sum = 0;
        for(int i : a)
        {
            if(opertion.operation(i))
            {
                sum += i;
            }
        }
        return sum;
    }
}