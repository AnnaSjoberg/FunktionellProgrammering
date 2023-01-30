package InUppg1;

import InUppg1.POJOs.Customer;
import InUppg1.POJOs.Model;

import java.util.List;
import java.util.Scanner;

public class DashBoard {
    Scanner sc = new Scanner(System.in);
    Repository repo = new Repository();
    String userType = "";
    String customerName;
    String customerPassword;

    Customer customer;
    List<Model> models;
    public DashBoard() {

        startUp();

        if (userType.equalsIgnoreCase("c")) {
            getCustomerFromInput();

            System.out.println("What model are you interested in?");


        }

    }

    public void startUp() {
        System.out.println("Welcome! ");

        while (true) {
            System.out.println("Press C for Customer or E for Employee: ");
            userType = sc.nextLine().trim();
            if (userType.equalsIgnoreCase("c") || userType.equalsIgnoreCase("e")) {
                break;
            }
            if (userType.equalsIgnoreCase("q")) {
                System.out.println("You chose to end the program!");
                System.exit(0);
            }
            System.out.println("Unable to comply. Please try again");
        }
    }

    public void getCustomerFromInput() {
        System.out.println("Enter your name: ");
        customerName = sc.nextLine().trim();
        System.out.println("Enter your password: ");
        customerPassword = sc.nextLine().trim();
        customer = repo.getCustomerByLogIn(customerName, customerPassword);
    }

    public static void main(String[] args) {
        DashBoard db = new DashBoard();
    }
}
