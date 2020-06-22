package javaSE.fucntionalPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

class Customer
{
    String name;
    String pass;

    public Customer(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}

class Example implements Runnable
{
    private String name;
    public Example(String name)
    {
        this.name = name;
    }
    @Override
    public void run() {
        System.out.println("This user have no written password. " +
                "\n This will added to black list! ");
        FunctionalMainClass.blacklist.add(name);

    }
}

class CancelBlackList implements Runnable
{
    private String name;

    public CancelBlackList(String name) {
        this.name = name;
    }

    public void run()
    {
        FunctionalMainClass.blacklist.remove(name);
    }
}

public class FunctionalMainClass {
    static List<String> blacklist = new ArrayList<>();

    public static void main(String[] args) {

//        function(); example of Function<T, R> using
//        biFunction();

//        consumer();
//        biConsumer();

//        predicate();

//        supplier();
        String name = "Andrij";

        callBackFunctionalExample(name, null, new Example("Andrij"));
        callBackFunctionalExample(name, "123456789", new CancelBlackList(name));
        callBackImperetiveExample(name, null, ", some problems with pass :( ");

        System.out.println(blacklist);

    }

    static void callBackFunctionalExample(String name, String pass, Runnable callBack)
    {
        System.out.print(name);
        if (pass != null)
        {
            System.out.print(" " + pass);
        } else {
            callBack.run();
        }
    }

    static void callBackImperetiveExample(String name, String pass, String except)
    {
        System.out.print(name);
        if (pass != null)
        {
            System.out.print(" " + pass);
        } else {
            System.out.println(except);
        }
    }

    // ======================================================================================================================================== //
    static void supplier()
    {
        powerOfSupplier.get().stream().filter(line -> line.length() > 6).forEach(line -> System.out.println(line));
    }

    Supplier<String> supplier = () -> "Hello, this simple of Supplier";
    static Supplier<List<String>> powerOfSupplier = () ->
            List.of("hello", "this is", "power of", "supplier");

    // ======================================================================================================================================== //
    static void predicate()
    {
        System.out.println(validPhone.test("+380508604186"));
        System.out.println(validPhone.or(orWithoutFirstPart).test("0508695321"));
    }

    static Predicate<String> validPhone = phoneNumber ->
        (phoneNumber.length() == 13)&(phoneNumber.startsWith("+380"));
    static Predicate<String> orWithoutFirstPart = phoneNumber -> (phoneNumber.length() == 10) & phoneNumber.startsWith("0");

    // ======================================================================================================================================== //
    static void biConsumer()
    {
        showNameAndPassByReq.accept(new Customer("Andrij", "12121212"), true);
        showNameAndPassByReq.accept(new Customer("Solya", "thebest"), false);
    }

    static BiConsumer<Customer, Boolean> showNameAndPassByReq = (customer, showPassReq)
            -> System.out.println("Name: " + customer.getName() + ", pass: "
            + (showPassReq ? customer.name : "<hidden pass>"));
    // ======================================================================================================================================== //
    static void consumer()
    {
        //Customer customer = new Customer("Andrew", "123456789"); // no sense to user ;)
        showCustomer.accept(new Customer("Andrew", "123456789")); // this return "nothing", Consumer is void function
    }

    static Consumer<Customer> showCustomer = customer -> System.out.println("Name: " + customer.getName() + ", password: " + customer.getPass());
    // ======================================================================================================================================== //

    static void biFunction()
    {
        System.out.println(incrementByOneAndMultiply.apply(20, 200));
        System.out.println("Chain of functions: " +
                incrementByOneAndMultiply.andThen(incrementAndMultiplyThen).apply(10,10)); // ((10 + 1) + 10) * 10
    }

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiply =
            (numberToIncrement, numberToMultiply)
            -> (numberToIncrement + 1) * numberToMultiply;
    // ======================================================================================================================================== //
    static void function()
    {
        int result = incrementFunction.apply(2);
        result = multiplyBy10Function.apply(result); // must be 30
        System.out.println(result);
        result = multiplyBy10Function.apply(incrementFunction.apply(2)); // too must be 30
        System.out.println(result);
        result = incrementAndMultiplyThen.apply(10);
        System.out.println(result);
    }

    static Function<Integer, Integer> incrementFunction = number -> number + 1; // left part mean type Integer and wright type mean Integer.
    static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;
    static Function<Integer, Integer> incrementAndMultiplyThen = incrementFunction.andThen(multiplyBy10Function);
    // ======================================================================================================================================== //
}

