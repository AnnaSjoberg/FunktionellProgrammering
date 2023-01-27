package InUppg1.POJOs;

import java.util.List;

public class Order {
    private final int id;
    private final Customer customer;
    private boolean delivered;
    private List<Product> products;
    //private List<Cartcontent> cartcontents; ERSÄTTA OM NÖDVÄNDIGT ATT STRUKTUREN ÄR SAMMA SOM I DB

    public Order(int id, Customer customer, boolean delivered, List<Product> products) {
        this.id = id;
        this.customer = customer;
        this.delivered = delivered;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
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
