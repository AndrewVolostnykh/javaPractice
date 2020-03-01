package testing;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import testing.calculator.CalculatorTesting;

@RunWith(Suite.class)
@Suite.SuiteClasses(CalculatorTesting.class)
public class TestSuite {

    @Before
    void before()
    {

    }

    @After
    void after()
    {

    }
}
