package annotationReflection;

import annotationReflection.annotation.prototype.Proto;
import annotationReflection.annotation.prototype.TestBean;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnRefProcessor {
    public static void main(String[] args) {
        TestBean firstTest = new TestBean(1, "Andrew");

        // this block checking -- is this class bean (have getters and setters for fields)
        if(isBean(TestBean.class))
        {
            Class<TestBean> analisator = (Class)firstTest.getClass();
            Field[] fields = analisator.getFields();
            Method[] methods = analisator.getMethods();
            String fieldsToType = null;
            String methodsRealised = null;
            for(int i = 0; i < fields.length; i++)
            {
                fieldsToType = fields[i].toString().toLowerCase();
                methodsRealised = methods[i].toString().toLowerCase();
                if(!("set" + fieldsToType).equals(methodsRealised) |
                   !("get" + fieldsToType).equals(methodsRealised))
                {
                    System.out.println("Error, have no getter or setter!");
                }
            }
        }

        // this block checking is class have implementation of some interfaces
        if(isImplemets(TestBean.class))
        {
            System.out.println("Implement some interfaces");
        }


    }

    static boolean isBean(Class<?> bean)
    {
        if(bean.isAnnotationPresent(Proto.class))
        {
            return bean.getAnnotation(Proto.class).isBean();
        }

        return false;
    }

    static boolean isImplemets(Class<?> implementer)
    {
        if (implementer.getInterfaces() != null)
            return true;
        return false;
    }

}
