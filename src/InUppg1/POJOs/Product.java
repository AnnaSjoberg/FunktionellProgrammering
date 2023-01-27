package InUppg1.POJOs;

public class Product {
    private final int id;
    private final Model model;
    private final Color color;
    private final int size;
    private int orderedAmount;

    public Product(int id, Model model, Color color, int size, int orderedAmount) {
        this.id = id;
        this.model = model;
        this.color = color;
        this.size = size;
        this.orderedAmount = orderedAmount;
    }

    public int getId() {
        return id;
    }

    public Model getModel() {
        return model;
    }

    public Color getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    public int getOrderedAmount() {
        return orderedAmount;
    }

    public void setOrderedAmount(int orderedAmount) {
        this.orderedAmount = orderedAmount;
    }
}
