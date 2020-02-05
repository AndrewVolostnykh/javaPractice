package app.entities;

public class User {
    private String name;
    private String password;

    private String email;
    private String country;
    private String birthDate;
    private String gender;

    private int id; // it is hashCode

    public User(String name, String password, String email, String country, String birthDate, String gender) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.country = country;
        this.birthDate = birthDate;
        this.gender = gender;
        setId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setId()
    {
        this.id = hashCode();
    }

    public int getId()
    {
        return id;
    }

    @Override
    public String toString() {
        return name + ", email: " + email + ", country: " + country
                + ", gender: " + gender + ", id: " + id;
        }

    @Override
    public int hashCode() {

        int result = (name != null ? name.hashCode() : 0) + (email != null ? email.hashCode() : 0) +
                 (birthDate != null ? birthDate.hashCode() : 0);
        result *= result * 31 + gender.hashCode() + (country != null ? country.hashCode() : 0);
        return result;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }
}
