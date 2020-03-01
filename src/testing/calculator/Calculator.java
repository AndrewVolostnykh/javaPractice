package testing.calculator;

public class Calculator {

    public int add(int a, int b)
    {
        return a+b;
    }

    public int dif(int a, int b)
    {
        return a-b;
    }

    public double division(int a, int b) throws Exception
    {
        if ( b == 0 ) throw new Exception();
        return a/b;
    }

    public double multiple(int a, int b)
    {
        return a*b;
    }


}
