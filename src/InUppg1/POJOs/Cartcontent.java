package InUppg1.POJOs;

public class Cartcontent {
    private final Product product;
    private int orderdAmount;

    public Cartcontent(Product product, int orderdAmount) {
        this.product = product;
        this.orderdAmount = orderdAmount;
    }

    public Product getProduct() {
        return product;
    }

    public int getOrderdAmount() {
        return orderdAmount;
    }

    public void setOrderdAmount(int orderdAmount) {
        this.orderdAmount = orderdAmount;
    }
}
