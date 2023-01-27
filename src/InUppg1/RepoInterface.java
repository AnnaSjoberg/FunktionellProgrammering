package InUppg1;

import InUppg1.POJOs.Customer;
import InUppg1.POJOs.Order;
import InUppg1.POJOs.Product;

import java.util.List;

public interface RepoInterface {

    String callAddToCart (Customer customer, Product product, int amount);
    String verifyCustomer (String name, String password);

    List<Order> getListOfOrdersByCustomerName (String customerName);

 //   Customer getCustomerByNameAndPassword (String name, String password);
   // List<Product> getProductsByModelName (String model);
    //Product getSpecificProduct (String model, String color, int size);



}
