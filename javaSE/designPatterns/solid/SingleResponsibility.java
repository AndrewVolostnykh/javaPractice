package designPatterns.solid;

public class SingleResponsibility {
    // Only one reason to re-write code of class. If we have 2 reasons -> it must be re-written
    public static void main(String[] args) {
        Employee java_developer = new Developer(100000001, 2560, "Junior Android Developer", 1);
        Developer seniorJavaDeveloper = new Developer(10000002, 5000, "Senior Java WebDeveloper", 5);
        Developer jhc_frontend = new Developer(1212321, 900, "Frontend Developer", 1);
        Employee manager = new Manager(123654654, 900, "Head Manager");

        Office first_office = new Office(java_developer, seniorJavaDeveloper, jhc_frontend, manager);
    }

}

// it's a simple example
class Office
{
    public Office(Employee... java_developers)
    {
        for(Employee developer : java_developers)
        {
            System.out.println("Here now works: " + "'"
                    + developer.getPosition() + "'" + ", with next salary: "
                    + developer.getSalary());
        }
    }
}


interface Employee
{
    int getSalary();
    int getId();
    String getPosition();
}

class Manager implements Employee
{
    private int id;
    private int salary;
    private String position;

    public Manager(int id, int salary, String position) {
        this.id = id;
        this.salary = salary;
        this.position = position;
    }

    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public String getPosition() {
        return position;
    }

    public int getId()
    { return id;}
}

class Developer implements Employee
{
    int id;
    int salary;
    private String position;
    private int experience;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public int getSalary() {
        return 0;
    }

    @Override
    public String getPosition() {
        return null;
    }

    public Developer(int id, int salary, String position, int experience) {
        this.id = id;
        this.salary = salary;
        this.position = position;
        this.experience = experience;
    }
}