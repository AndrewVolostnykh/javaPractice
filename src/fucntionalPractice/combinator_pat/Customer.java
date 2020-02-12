package fucntionalPractice.combinator_pat;

import java.time.LocalDate;

public class Customer {
    private String name;
    private String phoneNumber;
    private String email;
    private LocalDate birth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer(String name, String phoneNumber, String email, LocalDate birth) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.birth = birth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }
}
