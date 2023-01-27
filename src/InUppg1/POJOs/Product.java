package InUppg1.POJOs;

public class Product {
    private final int id;
    private final Model model;
    private final Color color;
    private final int size;
    private int balance;

    public Product(int id, Model model, Color color, int size, int balance) {
        this.id = id;
        this.model = model;
        this.color = color;
        this.size = size;
        this.balance = balance;
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

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
