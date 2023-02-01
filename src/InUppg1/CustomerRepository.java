package InUppg1;

import InUppg1.POJOs.*;

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

    public Brand getBrandByModelId(int modelId) {
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
                brand = new Brand(rs.getInt("id"), rs.getString("name"),
                        rs.getString("contact"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return brand;
    }

    public Model getModelByProductId(int productId) {
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
                model = new Model(rs.getInt("id"), brand,
                        rs.getString("name"), rs.getInt("price"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return model;
    }

    public Color getColorByProductId(int productId) {
        Color color = new Color();
        String query = "select color.id as id, color.color as color from color " +
                "inner join product on color.id = product.colorid where product.id = ?";

        try (Connection c = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"), p.getProperty("password"));
             PreparedStatement pstmt = c.prepareStatement(query);
        ) {
            pstmt.setInt(1, productId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                color = new Color(rs.getInt("id"), rs.getString("color"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return color;
    }

    public Size getSizeByProductId(int productId) {
        Size size = new Size();
        String query = "select shoesize.id as id, shoesize.shoesize as shoesize from shoesize " +
                "inner join product on shoesize.id = product.shoesizeid where product.id = ?";

        try (Connection c = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"), p.getProperty("password"));
             PreparedStatement pstmt = c.prepareStatement(query);
        ) {
            pstmt.setInt(1, productId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                size = new Size(rs.getInt("id"), Integer.parseInt(rs.getString("shoesize")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return size;
    }

    public Product getProductById(int id) {
        Product product = new Product();
        Model model = getModelByProductId(id);
        Color color = getColorByProductId(id);
        Size size = getSizeByProductId(id);
        String query = "select * from product where product.id = ?";

        try (Connection c = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"), p.getProperty("password"));
             PreparedStatement pstmt = c.prepareStatement(query);
        ) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {//int id, Model model, Color color, int size, int balance
                product = new Product(id, model, color, size, rs.getInt("balance"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return product;
    }

    public List<Product> getAllProducts() {
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

    public Customer getVerifiedCustomer(String name, String password) {
        List<Customer> customers = getAllCustomers();

        Customer customer = customers.stream().filter(c -> c.getName().equalsIgnoreCase(name)
                && c.getPassword().equals(password)).findFirst().orElse(null);

        return customer;
    }

    public List<Customer> getAllCustomers() {
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

    public Customer getCustomerById(int id) {
        Customer customer = new Customer();
        String query = "select * from Customer where id = ?";
        try (Connection c = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"), p.getProperty("password"));
             PreparedStatement pstmt = c.prepareStatement(query);
        ) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                customer = new Customer(id, rs.getString("name"), rs.getString("socialSecurityNumber"),
                        rs.getString("address"), rs.getString("password"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customer;
    }

    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        List<Integer> allOrderIds = new ArrayList<>();
        String query = "Select id from orders";

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

    public Order getOrderById(int id) {
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
                order = new Order(id, customer, rs.getBoolean("delivered"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return order;
    }


    public void callAddToCart(List<Purchase> purchaseList) {
        String confirmation = "Order was placed successfully";
        List<Order> allOrders = getAllOrders();

        int orderId = allOrders.stream().filter(o -> o.getCustomer().getId() == (purchaseList.get(0).getCustomer().getId()))
                .filter(o -> o.isDelivered() == false).findFirst().map(Order::getId).orElse(-1);

        for (Purchase content : purchaseList) {

            try (Connection c = DriverManager.getConnection(p.getProperty("connectionString"),
                    p.getProperty("name"), p.getProperty("password"));
                 CallableStatement cstmt = c.prepareCall("call AddToCart(?,?,?,?)");
            ) {
                cstmt.setInt(1, content.getCustomer().getId());
                cstmt.setInt(2, orderId);
                cstmt.setInt(3, content.getProduct().getId());
                cstmt.setInt(4, content.getOrderedAmount());

                cstmt.execute();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
                confirmation = "Order could not be placed";

            } catch (Exception e) {
                System.out.println(e.getMessage());
                confirmation = "Order could not be placed";

            }
        }
        System.out.println(confirmation);
    }

}