package annotationReflection.annotation.prototype;

@Proto(isBean = true)
public class TestBean{
    int id;
    String name;

    public TestBean(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void start()
    {
        System.out.println("This is prototype of Beans");
    }
}
