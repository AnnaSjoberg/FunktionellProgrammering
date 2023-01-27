package JDBC.övn4b;

import java.util.List;

public class Main {

    public Main(){
        Repository r = new Repository();

        List<Present> list = r.getAllPresents();
        list.forEach(present -> present.print());
    }
    public static void main(String[] args) {
        Main m = new Main();
    }
}
