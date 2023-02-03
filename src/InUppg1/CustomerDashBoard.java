package InUppg1;

import InUppg1.POJOs.Customer;
import InUppg1.POJOs.Model;
import InUppg1.POJOs.Product;
import InUppg1.POJOs.Purchase;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomerDashBoard {

    Scanner sc = new Scanner(System.in);
    Repository repo = new Repository();
    List<Model> models = new ArrayList<>();
    List<Product> products = new ArrayList<>();

    List<Purchase> purchaseList = new ArrayList<>();
    Product product;
    Customer customer;
    String reply;

    public CustomerDashBoard() {
        customer = logInCustomer();
        while (true) {
            product = getProductToBuy();
            if (product == null){
                System.out.println("Do you want to cancel order? (y/n)");
                reply = sc.next().trim();
                if (reply.equalsIgnoreCase("y")){
                    System.exit(0);
                }
            }else {
                purchaseList.add(new Purchase(customer, product, getAmountToBuy()));
            }
            System.out.println("Do you want to add something else to your order? (y/n)");
            reply = sc.next().trim();
            if (reply.equalsIgnoreCase("n")) {
                break;
            } else if (reply.equalsIgnoreCase("y")) {
                System.out.println("Please go on with your order");
            }

        }
        if (purchaseList.size()>0) {
            repo.callAddToCart(purchaseList);
        }
    }

    public Customer logInCustomer() {
        System.out.println("Enter your name: ");
        String customerName = sc.nextLine().trim();
        System.out.println("Enter password: ");
        String customerPassword = sc.nextLine().trim();

        return repo.getVerifiedCustomer(customerName, customerPassword);
    }

    public Product getProductToBuy() {
        var tempHolder = new LinkedHashMap<Integer, Product>();
        var counter = new AtomicInteger(1);
        products = repo.getAllProducts();
        int chosenProduct = -1;
        int prodID = -1;
        System.out.println("Which model do you want to buy? (Choose number 1-9 (0=cancel)");
        models = products.stream().map(m -> m.getModel()).sorted(Comparator.comparing(Model::getId)).toList();
        models.stream().map(m -> m.toString()).distinct().forEach(m -> System.out.println(m));

        int chosenModel = sc.nextInt();
        if (chosenModel == 0) {
            System.out.println("No new product has been added to your order.");
            return null;
        }
        products.stream().filter(p -> p.getModel().getId() == chosenModel && p.getBalance()>0)
                .forEachOrdered(product -> tempHolder.put(counter.getAndIncrement(), product));

        while (prodID == -1) {
            System.out.println("Please select which product you want by choosing the corresponding number. (0=cancel)");
            tempHolder.forEach((number, product) -> System.out.println(number + ". " + product));
            chosenProduct = sc.nextInt();
            if (chosenProduct == 0) {
                System.out.println("No new product has been added to your order.");
                return null;
            }
            try {
                prodID = tempHolder.get(chosenProduct).getId();
            } catch (NullPointerException e) {
                System.out.println("Product does not exist, try again.");
            }
        }

        return repo.getProductById(prodID);
    }

    public int getAmountToBuy() {
        int amount = 0;
        while (amount <= 0) {
            System.out.println("How many pairs do you want to buy?");
            amount = sc.nextInt();
            if (amount < 0) {
                System.out.println("Ordered amount must be greater than 0");
            }
        }
        return amount;
    }

}
