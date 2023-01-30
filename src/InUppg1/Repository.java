package InUppg1;

import InUppg1.POJOs.Customer;
import InUppg1.POJOs.Orders;
import InUppg1.POJOs.Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Repository {

    Properties p = new Properties();

    public Repository() {
        try {
            p.load(new FileInputStream("src/InUppg1/settings.properties"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




    public String callAddToCart(Customer customer, Product product, int amount) {
        return null;
    }


    public Customer getCustomerByLogIn(String name, String password) {
        String query = "Select * from customer where name = ? and password = ?";

        Customer customer=new Customer();
        int foundMatch = 0;
        String confirmation = "";
        try (Connection c = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"), p.getProperty("password"));
             PreparedStatement pstmt = c.prepareStatement(query);
        ) {
            pstmt.setString(1, name);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                customer = new Customer(rs.getInt("id"),
                        rs.getString("name"), rs.getString("socialSecurityNumber"),
                        rs.getString("address"), rs.getString("password"));
                foundMatch++;
            }
            if (foundMatch == 0){
                confirmation = "No customer matched the input name and password";
            }
            if (foundMatch > 1){
                confirmation = "Multiple customers matched input name and password";
            }
            if (confirmation.equalsIgnoreCase("")){
                confirmation = "Customer verified. Continue with your order.";

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(confirmation);
        return customer;
    }


    public List<Customer> getAllCustomers (){
        List<Customer> customers = new ArrayList<>();
        List<Integer> allCustomerIds = new ArrayList<>();

        String query = "Select id from customer";

        try (Connection c = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"), p.getProperty("password"));
             PreparedStatement pstmt = c.prepareStatement(query);
        ) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                allCustomerIds.add(rs.getInt("id"));
            }

            customers = allCustomerIds.stream().map(i -> getCustomerById(i)).toList();

        } catch (Exception e) {
            e.printStackTrace();

        }

        return customers;
    }

    public Customer getCustomerById (int id){
        Customer customer = new Customer();
        List<Orders> orders = getListOfOrdersByCustomerId(id);

        String query = "select * from Customer where id = ?";
        try (Connection c = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"), p.getProperty("password"));
             PreparedStatement pstmt = c.prepareStatement(query);
        ) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                customer = new Customer(id, rs.getString("name"),rs.getString("socialSecurityNumber"),
                        rs.getString("address"),rs.getString("password"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customer;
    }

    public List<Orders> getListOfOrdersByCustomerId(int customerId) {
        List<Orders> orders = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        String query = "Select * from orders inner join customer on orders.customerid = customer.id " +
                "where delivered = false and customer.Id = ?";

        try (Connection c = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"), p.getProperty("password"));
             PreparedStatement pstmt = c.prepareStatement(query);
        ) {
            pstmt.setInt(1, customerId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
             //  orders.add(new Orders(rs.getInt("order.id"), ))

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }


    public List<Product> getProductsByOrderId (int orderId){
        List<Product> products = new ArrayList<>();
        List<Integer> modelIds = new ArrayList<>();
        String query = "select orders.id as orderID, delivered, orderedAmount,  " +
                "model.id as modelId, color.color, shoesize.shoesize " +
                "from orders inner join cartcontent on orders.id = cartcontent.orderid " +
                "inner join product on cartcontent.productid = product.id " +
                "inner join model on product.modelId = model.id inner join color on product.colorid = color.id " +
                "inner join shoesize on product.shoesizeid = shoesize.id where orderID = ?";

        try (Connection c = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"), p.getProperty("password"));
             PreparedStatement pstmt = c.prepareStatement(query);
        ) {
            pstmt.setInt(1, orderId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){//product(id, model, color, size, orderedAmount)
             //   products.add(new Product(rs.getInt("product.id"),rs.))

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products;
    }
}
