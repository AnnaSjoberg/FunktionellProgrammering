package InUppg1.take2.POJOs;

public class Order {
    private int id;
    private Customer customer;
    private boolean delivered;

    public Order (){}

    public Order(int id, Customer customer, boolean delivered) {
        this.id = id;
        this.customer = customer;
        this.delivered = delivered;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }
}
