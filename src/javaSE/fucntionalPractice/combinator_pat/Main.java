package fucntionalPractice.combinator_pat;

import java.time.LocalDate;
import static fucntionalPractice.combinator_pat.CustomerRegistrationValidator.*;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Andrew",
                "+380734234783",
                "zighalt790@gmail.com",
                LocalDate.of(1999,12,4)
        );

        // Using combinator pattern :
        ValidationResult result = CustomerRegistrationValidator.isEMailValid()
                .and(CustomerRegistrationValidator.isPhoneValid()
                .and(CustomerRegistrationValidator.isAdult()))
                .apply(customer);

        System.out.println(result);

        if(result != ValidationResult.SUCCESS)
        {
            throw new IllegalStateException(result.name());
        }
    }
}
