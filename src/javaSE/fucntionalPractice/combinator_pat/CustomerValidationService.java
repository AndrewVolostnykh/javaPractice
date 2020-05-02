package fucntionalPractice.combinator_pat;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidationService {

    private boolean isEmailValid(String email)
    {
        return email.contains("@");
    }
    private boolean isPhoneNumberValid(String phoneNumber)
    {
        return phoneNumber.startsWith("+380");
    }
    private boolean isAdult(LocalDate birth)
    {
        return Period.between(birth, LocalDate.now()).getYears() > 16;
    }

    public boolean isValid(Customer customer)
    {
        return isEmailValid(customer.getEmail())
                && isPhoneNumberValid(customer.getPhoneNumber())
                && isAdult(customer.getBirth());
    }
}
