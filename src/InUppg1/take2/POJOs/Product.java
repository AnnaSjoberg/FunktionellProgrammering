package InUppg1.take2.POJOs;

public class Product {
    private int id;
    private Model model;
    private ColorC color;
    private Size size;
    private int balance;

    public Product() {
    }

    public Product(int id, Model model, ColorC color, Size size, int balance) {
        this.id = id;
        this.model = model;
        this.color = color;
        this.size = size;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public ColorC getColor() {
        return color;
    }

    public void setColor(ColorC color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Size: " + size.getSize() +
                "\tColor: " + color.getColor() +
                 "\t\t("+balance + " pairs in stock)";
        //return id +". "+ model.getName() +"\t\t Color: " + color +
          //      "\t\t Size: " + size + "\t\t"+balance + " pairs in stock.";
    }
}
