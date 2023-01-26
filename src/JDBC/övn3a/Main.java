package JDBC.övn3a;


import java.util.Scanner;

public class Main {

    public Main(){
        Repository repo = new Repository();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter your old name: ");
            String deadName = scanner.nextLine();

            System.out.println("Enter your chosen name: ");
            String newName = scanner.nextLine();

            System.out.println(repo.updateElfName(newName.trim(), deadName.trim()));;


        }

    }


    public static void main(String[] args) {
        Main m = new Main();
    }
}
