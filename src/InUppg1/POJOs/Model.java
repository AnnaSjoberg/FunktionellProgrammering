package InUppg1.POJOs;

import java.util.List;

public class Model {
    private final int id;
    private final Brand brand;
    private final String name;
    private int price;
    private List<Category> categories;


    public Model(int id, Brand brand, String name, int price, List<Category> categories) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.categories = categories;
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

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
