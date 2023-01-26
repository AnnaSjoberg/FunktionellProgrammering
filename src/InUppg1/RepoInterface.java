package InUppg1;

import InUppg1.POJOs.Customer;
import InUppg1.POJOs.Product;

import java.util.List;

public interface RepoInterface {


    String verifyCustomer (String name, String password);
    Customer getCustomerByNameAndPassword (String name, String password);
    List<Product> getProductsByModelName (String model);
    Product getSpecificProduct (String model, String color, int size);


}
