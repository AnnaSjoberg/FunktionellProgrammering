package InUppg1;

import java.util.Scanner;

public class DashBoard {
    Scanner sc = new Scanner(System.in);

    public DashBoard() {
        RepoInterface repo = new Repository();

        System.out.println("Enter your name: ");
        String customerName = sc.nextLine().trim();
        System.out.println("Enter your password: ");
        String customerPassword = sc.nextLine().trim();

        System.out.println(repo.verifyCustomer(customerName, customerPassword));

    }

    public static void main(String[] args) {
        DashBoard db = new DashBoard();
    }
}
