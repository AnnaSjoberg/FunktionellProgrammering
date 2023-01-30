package InUppg1.POJOs;

public class Cartcontent {
    private final Product product;
    private int orderedAmount;

    public Cartcontent(Product product, int orderedAmount) {
        this.product = product;
        this.orderedAmount = orderedAmount;
    }

    public Product getProduct() {
        return product;
    }

    public int getOrderedAmount() {
        return orderedAmount;
    }

    public void setOrderedAmount(int orderedAmount) {
        this.orderedAmount = orderedAmount;
    }
}
