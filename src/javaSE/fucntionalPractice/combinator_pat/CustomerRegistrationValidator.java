package fucntionalPractice.combinator_pat;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import static fucntionalPractice.combinator_pat.CustomerRegistrationValidator.*;

public interface CustomerRegistrationValidator
    extends Function <Customer, ValidationResult> {

    static CustomerRegistrationValidator isEMailValid ()
    {
        return customer -> customer.getEmail().contains("@") ?
                ValidationResult.SUCCESS : ValidationResult.EMAIL_NOT_VALID;
    }

    static CustomerRegistrationValidator isPhoneValid()
    {
        return customer -> customer.getPhoneNumber().startsWith("+380") ?
                ValidationResult.SUCCESS : ValidationResult.PHONE_NUMBER_NOT_VALID;
    }

    static CustomerRegistrationValidator isAdult()
    {
        return customer -> Period.between(customer.getBirth(), LocalDate.now()).getYears() > 16 ?
                ValidationResult.SUCCESS : ValidationResult.IS_NOT_AN_ADULT;
    }

    default CustomerRegistrationValidator and (CustomerRegistrationValidator other)
    {
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(ValidationResult.SUCCESS) ? other.apply(customer) : result;
        };
    }

    enum ValidationResult
    {
        SUCCESS,
        PHONE_NUMBER_NOT_VALID,
        EMAIL_NOT_VALID,
        IS_NOT_AN_ADULT
    }
}
