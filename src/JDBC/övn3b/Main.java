package JDBC.övn3b;

import java.util.Scanner;

public class Main {

    public Main(){
        Repository r = new Repository();
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Who do you want to sack?");
            String name = scanner.nextLine();

            if (name.trim().equalsIgnoreCase("bye")){
                System.exit(0);
            }

            r.dropElfByName(name.trim());
        }

    }
    public static void main(String[] args) {
        Main m = new Main();
    }
}
