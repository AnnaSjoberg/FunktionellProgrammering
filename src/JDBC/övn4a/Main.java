package JDBC.övn4a;

import java.util.List;
import java.util.Scanner;

public class Main {

    public Main(){
        Repository r = new Repository();

        List<Child> list = r.getAllChildren();
        list.forEach(child -> System.out.println(child));
        //list.forEach(child -> child.print());
    }
    public static void main(String[] args) {
        Main m = new Main();
    }
}
