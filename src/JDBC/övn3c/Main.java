package JDBC.övn3c;

import java.util.Scanner;

public class Main {

    public Main(){
        Repository r = new Repository();
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("What item do you want to add to list of presents?");
            String name = scanner.nextLine().trim();

            System.out.println("What elf should be responsible for making this item?");
            //int elfId = scanner.nextInt();
            String s = scanner.nextLine().trim();
            int elfId = Integer.parseInt(s);

            if (name.trim().equalsIgnoreCase("bye")||elfId==0){
                System.exit(0);
            }
            System.out.println(r.AddPresent(name,elfId));
        }

    }
    public static void main(String[] args) {
        Main m = new Main();
    }
}
