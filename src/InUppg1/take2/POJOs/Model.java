package InUppg1.take2.POJOs;

import java.util.List;

public class Model {
    private int id;
    private Brand brand;
    private String name;
    private int price;


public Model(){}
    public Model(int id, Brand brand, String name, int price) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public Brand getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  id + ": " + name;
    }
}
