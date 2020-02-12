package fucntionalPractice;

import java.util.Optional;

public class OptionalPracticeClass {
    public static void main(String[] args) {
        optionalPresent("Andrew");
        optionalPresent(null); // nothing have printed

        optionalPresentOr("Andrew");
        optionalPresentOr(null);
    }

    static void optionalPresent(String name)
    {
        Optional.ofNullable(name).ifPresent(s -> System.out.println(s + " how are you? "));
    }

    static void optionalPresentOr(String name)
    {
        Optional.ofNullable(name).ifPresentOrElse(s -> System.out.println(s + " how are you? "),
                () -> {
            System.out.println("No name here :( ");
        });
    }

}
