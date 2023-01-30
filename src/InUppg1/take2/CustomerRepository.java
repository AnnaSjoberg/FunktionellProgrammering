package InUppg1.take2;

import InUppg1.take2.POJOs.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

// repo som hanterar produkterna
public class CustomerRepository {

    Properties p = new Properties();

    public CustomerRepository() {
        try {
            p.load(new FileInputStream("src/InUppg1/settings.properties"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Brand getBrandByModelId (int modelId){
        Brand brand = new Brand();
        String query = "select brand.id as id, brand.name as name, brand.contact as contact" +
                " from brand inner join model on model.brandid = brand.id where model.id = ?";

        try (Connection c = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"), p.getProperty("password"));
             PreparedStatement pstmt = c.prepareStatement(query);
        ) {
            pstmt.setInt(1, modelId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                brand = new Brand(rs.getInt("id"),rs.getString("name"),
                        rs.getString("contact"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return brand;
    }

    public Model getModelByProductId (int productId){
        Model model = new Model();
        Brand brand;
        String query = "select model.id as id, model.brandid as brand, model.name as name, " +
                "model.price as price from model inner join product on " +
                "model.id = product.modelid where product.id = ?";

        try (Connection c = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"), p.getProperty("password"));
             PreparedStatement pstmt = c.prepareStatement(query);
        ) {
            pstmt.setInt(1, productId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                brand = getBrandByModelId(rs.getInt("id"));
                model = new Model(rs.getInt("id"),brand,
                        rs.getString("name"), rs.getInt("price"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return model;
    }

    public Product getProductById (int id){
        Product product = new Product();
        Model model = getModelByProductId(id);
        Color color;
        int size;
        String query = "select product.id, product.modelid, color.color, shoesize.shoesize, " +
                "product.balance from product inner join model on product.modelid = model.id " +
                "inner join color on product.colorId = color.id inner join shoesize on " +
                "product.shoesizeid = shoesize.id where product.id = ?";

        try (Connection c = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"), p.getProperty("password"));
             PreparedStatement pstmt = c.prepareStatement(query);
        ) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {//int id, Model model, Color color, int size, int balance
                size = Integer.parseInt(rs.getString("shoesize"));
                color = Color.valueOf(rs.getString("color").toUpperCase());
                product = new Product(id, model, color,size, rs.getInt("balance"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



        return product;
    }

    public List<Product> getAllProducts (){
        List<Product> products = new ArrayList<>();
        List<Integer> allProductIDs = new ArrayList<>();

        String query = "Select id from product";

        try (Connection c = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"), p.getProperty("password"));
             PreparedStatement pstmt = c.prepareStatement(query);
        ) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                allProductIDs.add(rs.getInt("id"));
            }

            products = allProductIDs.stream().map(i -> getProductById(i)).toList();

        } catch (Exception e) {
            e.printStackTrace();

        }

        return products;
    }
    public Customer getVerifiedCustomer (String name, String password){
        List<Customer> customers = getAllCustomers();

        Customer customer = (Customer) customers.stream().filter(c->c.getName().equalsIgnoreCase(name)
                &&c.getPassword().equalsIgnoreCase(password));

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

    public List<Order> getAllOrders (){
        List<Order> orders = new ArrayList<>();
        List<Integer> allOrderIds = new ArrayList<>();
        String query= "Select id from orders";

        try (Connection c = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"), p.getProperty("password"));
             PreparedStatement pstmt = c.prepareStatement(query);
        ) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                allOrderIds.add(rs.getInt("id"));
            }

            orders = allOrderIds.stream().map(i -> getOrderById(i)).toList();

        } catch (Exception e) {
            e.printStackTrace();

        }

        return orders;
    }
    public Order getOrderById (int id){
        Order order = new Order();
        String query = "select * from Orders where id = ?";
        try (Connection c = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"), p.getProperty("password"));
             PreparedStatement pstmt = c.prepareStatement(query);
        ) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Customer customer = getCustomerById(rs.getInt("Customerid"));
                order = new Order(id, customer,rs.getBoolean("delivered"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return order;
    }


    public void callAddToCart (Customer customer, Product product, int amount, int orderId){
        List<Order> changeableOrders = getAllOrders().stream()
                .filter(o->!o.isDelivered()).toList();

        try (Connection c = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"), p.getProperty("password"));
             CallableStatement cstmt = c.prepareCall("call AddToCart(?,?,?,?)");
        ) {
            cstmt.setInt(1,customer.getId());
            if (changeableOrders.stream().anyMatch(o->o.getId()==orderId)){
                cstmt.setInt(2,orderId);
            }
            cstmt.setInt(3,product.getId());
            cstmt.setInt(4,amount);

            cstmt.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());;

        }

    }

}
