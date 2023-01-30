package InUppg1.take2.POJOs;

public class Product {
    private int id;
    private Model model;
    private Color color;
    private int size;
    private int balance;

    public Product() {
    }

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

    public void print (){

    }

    @Override
    public String toString() {
        return id +". "+ model.getName() +"\t\t Color: " + color +
                "\t\t Size: " + size + "\t\t"+balance + " pairs in stock.";
    }
}
