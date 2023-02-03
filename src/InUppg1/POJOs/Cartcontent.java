package InUppg1.POJOs;

public class Cartcontent {
    private int id;
    private Order order;
    private Product product;
    private int orderedAmount;

    public Cartcontent(){}
    public Cartcontent(int id, Order order, Product product, int orderedAmount) {
        this.id = id;
        this.order = order;
        this.product = product;
        this.orderedAmount = orderedAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Cartcontent)) {
            return false;
        }
        Cartcontent cc = (Cartcontent) o;

        return cc.getId()==(this.getId());

    }
}
