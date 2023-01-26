package JDBC.övn6;

import java.util.Scanner;

public class Main {

    public Main(){
        Repository r = new Repository();
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Who do you want to hire?");
            String name = scanner.nextLine().trim();


            if (name.trim().equalsIgnoreCase("bye")){
                System.exit(0);
            }
            r.callHireMakerElf(name);
        }

    }
    public static void main(String[] args) {
        Main m = new Main();
    }
}
