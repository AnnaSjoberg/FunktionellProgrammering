package InUppg1.take2;

import InUppg1.take2.POJOs.Customer;
import InUppg1.take2.POJOs.Order;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class EmployeeRepository {
    Properties p = new Properties();

    public EmployeeRepository() {
        try {
            p.load(new FileInputStream("src/InUppg1/settings.properties"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Customer> getCustomersThatBoughtProductsMatchingInput (String input){
        return null;
    }

    public List<Order> getOrdersPerCustomer (){
        return null;
    }


}
/*

1. En rapport som listar alla kunder, med namn och adress, som har handlat varor i en viss
storlek, av en viss färg eller av ett visst märke.
2. En rapport som listar alla kunder och hur många ordrar varje kund har lagt. Skriv ut namn
och sammanlagda antalet ordrar för varje kund.
3. En rapport som listar alla kunder och hur mycket pengar varje kund, sammanlagt, har
beställt för. Skriv ut varje kunds namn och summa.
4. En rapport som listar beställningsvärde per ort. Skriv ut orternas namn och summa.
5. En topplista över de mest sålda produkterna som listar varje modell och hur många ex som
har sålts av den modellen. Skriv ut namn på modellen och hur många ex som sålts
 */