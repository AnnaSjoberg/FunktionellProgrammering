package JDBC.övn4a;

public class Present {
    private final int id;
    private final String name;

    public Present(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
