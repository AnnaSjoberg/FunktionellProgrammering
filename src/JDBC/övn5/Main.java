package JDBC.övn5;

import java.util.Scanner;

public class Main {

    public Main(){
        Repository r = new Repository();
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("What item do you want to add to list of presents?");
            String name = scanner.nextLine().trim();


            if (name.trim().equalsIgnoreCase("bye")){
                System.exit(0);
            }
            r.callAddPresent(name);
        }

    }
    public static void main(String[] args) {
        Main m = new Main();
    }
}
