package InUppg1.POJOs;

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


    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Order)) {
            return false;
        }
        Order o = (Order) obj;

        return o.getId()==(this.getId());

    }
}
