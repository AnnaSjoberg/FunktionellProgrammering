package InUppg1.POJOs;

import java.util.List;

public class Orders {
    private final int id;
    private boolean delivered;
    private List<Product> products;


    public Orders(int id, boolean delivered, List<Product> products) {
        this.id = id;
        this.delivered = delivered;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
