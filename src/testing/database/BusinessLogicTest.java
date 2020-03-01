package testing.database;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BusinessLogicTest {
    public BusinessLogicTest() {}

    Mockery context = new Mockery();

    @Test
    public void testEditItem () throws Exception
    {
        int id = 5;
        String name = "SAndrew";
        DbInt db = context.mock(DbInt.class);

        context.checking(new Expectations() {{
            oneOf(db).find(id);
            oneOf(db).save(id, name); will(returnValue(2)); // returnValue given for DbInt method save 


        }});

        BusinessLogic instance = new BusinessLogic();
        int expResult = 1;
        int result = instance.editItem(id, name, db);
        assertEquals(expResult, result);
    }


}
