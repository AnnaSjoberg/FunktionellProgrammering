package JDBC.övn2b;

import java.util.Scanner;

public class Main {

    public Main (){
        RepoInterface repo = new Repository();
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Enter childs name and press enter: ");
            String temp = scanner.nextLine().trim();

            try{
                repo.getChildByName(temp).printOut();
            }catch (NullPointerException e){
                System.out.println(temp + " is not on record.");
            }

        }
    }


    public static void main(String[] args) {
        Main m = new Main();
    }
}
