package testing.calculator;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


import static junit.framework.TestCase.assertEquals;

@RunWith(value = Parameterized.class)
public class CalculatorTesting {

    private int a, b, resultExpected;
    private Calculator calculator = new Calculator();

    public CalculatorTesting(int a, int b, int resultExpected) {
        this.a = a;
        this.b = b;
        this.resultExpected = resultExpected;
    }

    @Rule
    public TestRule timeout = new Timeout(100);

    @Parameterized.Parameters
    public static Collection numbers()
    {
        return Arrays.asList(new Object[][] {{1,2,3},{2,9,11},{3,3,6}}); // Elements in brackets {} will give to constructor CalculatorTesting and tests will be started with this params
    }

    @Test
    public void calculatorNewTest()
    {
        int result = calculator.add(a, b);
        assertEquals(resultExpected, result);
    }

    @Ignore // This is hard-variables test
    @Test
    public void calculatorTesting() throws Exception
    {
        int a = 5; int b = 7;
        int addingExpected = 12;
        int differenceExp = -2;
        int multExp = 35;
        double divExp = 0.7142;

        int addingRes = calculator.add(a, b);
        int differenceRes = calculator.dif(a,b);
        double multRes = calculator.multiple(a, b);
        double divRes = calculator.division(a, b);


        assertEquals(addingExpected, addingRes);
        assertEquals(differenceExp, differenceRes);
        assertEquals(multExp, (int)multRes);
        assertEquals(divExp, divRes, 1);
    }

}
