package designPatterns.solid;

public class OpenClosed {
    public static void main(String[] args) {
        //This class must be open for extending, but closed for editing. This is open-close principle
        BMW fristCar = new BMW("model");
        Hyndai secondCar = new Hyndai("mode", "123456789");
        BMW thirdCar = new X5("model");

        driveCar("Andrij", fristCar);
        driveCar("Oksana", secondCar);
        driveCar("Solya", thirdCar);

    }

    static void driveCar(String name, Car car)
    {
        car.drive(name);
    }
}

interface Car{
    void drive(String name);
}

class BMW implements Car
{
    String model;

    public BMW(String model) {
        this.model = model;
    }

    @Override
    public void drive(String name) {
        System.out.println(name + " now driving BMW");
    }
}

class X5 extends BMW{
    public X5(String model)
    {
        super(model);
    }

    @Override
    public void drive(String name) {
        System.out.println(name + " now driving BMW-X5");
    }
}

class Hyndai implements Car{
    String model;
    String serialNumber;

    public Hyndai(String model, String serialNumber) {
        this.model = model;
        this.serialNumber = serialNumber;
    }

    @Override
    public void drive(String name) {
        System.out.println("Hyndai now driving by " + name);
    }
}