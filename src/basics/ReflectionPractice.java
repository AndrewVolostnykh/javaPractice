package basics;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;

public class ReflectionPractice {
    public static void reflPract() throws Exception
    {
        Class cls1 = Class.forName("basics.SomeClass");

        Constructor[] constructors = cls1.getConstructors();
        for(Constructor constructor : constructors)
        {
            System.out.println(constructor.getName());
            Parameter[] parameters = constructor.getParameters();
            for(Parameter parameter : parameters)
            {
                System.out.println(parameter.getName());
                System.out.println(parameter.getType().getName());
            }
        }
    }
}

class SomeClass{
    String firstField;
    String secondField;
    private static int a;
    int b;

    public SomeClass(String firstField, String secondField, int b) {
        this.firstField = firstField;
        this.secondField = secondField;
        this.b = b;
    }

    public String returnTwoFields()
    {
        return "First: " + firstField + ", second: " + secondField;
    }
}
