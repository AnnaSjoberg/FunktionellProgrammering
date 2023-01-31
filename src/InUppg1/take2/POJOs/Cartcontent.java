package InUppg1.take2.POJOs;

public class Cartcontent {
    private Customer customer;
    private Product product;
    private int orderedAmount;


    public Cartcontent() {
    }

    public Cartcontent(Customer customer, Product product, int orderedAmount) {
        this.customer = customer;
        this.product = product;
        this.orderedAmount = orderedAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getOrderedAmount() {
        return orderedAmount;
    }

    public void setOrderedAmount(int orderedAmount) {
        this.orderedAmount = orderedAmount;
    }
}
