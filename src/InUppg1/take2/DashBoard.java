package InUppg1.take2;

import InUppg1.take2.POJOs.Customer;
import InUppg1.take2.POJOs.Model;
import InUppg1.take2.POJOs.Product;

import java.util.List;
import java.util.Scanner;

public class DashBoard {
    Scanner sc = new Scanner(System.in);
    CustomerRepository repo = new CustomerRepository();
    String userType = "";
    String customerName;
    String customerPassword;
    String input;
    Customer customer;
    List<Model> models;
    List<Product> products;
    List<Customer> customers;
    public DashBoard() {

        System.out.println("Enter your name: ");
        customerName = sc.nextLine().trim();
        System.out.println("Enter password: ");
        customerPassword= sc.nextLine().trim();

        customer = repo.getVerifiedCustomer(customerName,customerPassword);

        products = repo.getAllProducts();
        models = products.stream().map(m -> m.getModel()).toList();
        customers = repo.getAllCustomers();

        System.out.println("Which model do you want to buy? (Choose number 1-9 (0=exit)");
        models.stream().map(m -> m.toString()).distinct().sorted().forEach(m -> System.out.println(m));


        int chosenModel = sc.nextInt();
        if (chosenModel == 0) {
            System.out.println("Order has been cancelled");
            System.exit(0);
        }
        System.out.println("Please select which product you want by choosing the corresponding number.");
        products.stream().filter(p -> p.getModel().getId() == chosenModel).forEach(p -> System.out.println(p));

        int chosenProduct = sc.nextInt();

        if (chosenProduct == 0) {
            System.out.println("Order has been cancelled");
            System.exit(0);
        }

        System.out.println("How many pairs do you want to buy?");
        int amount = sc.nextInt();

        if (amount <0){
            System.out.println("Ordered amount must be greater than 0");
        }

        Product product = repo.getProductById(chosenProduct);
        repo.callAddToCart(customer,product,amount,18);

    }


    public static void main(String[] args) {


        DashBoard db = new DashBoard();
    }
}
