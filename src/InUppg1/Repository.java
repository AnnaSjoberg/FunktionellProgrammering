package InUppg1;

import InUppg1.POJOs.Customer;
import InUppg1.POJOs.Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Properties;

public class Repository implements RepoInterface {

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

    //metoder från interface

    @Override
    public String verifyCustomer(String name, String password) {
        String query = "Select * from customer where name = ? and password = ?";
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
        return confirmation;
    }

    @Override
    public Customer getCustomerByNameAndPassword(String name, String password) {
        return null;
    }

    @Override
    public List<Product> getProductsByModelName(String model) {
        return null;
    }

    @Override
    public Product getSpecificProduct(String model, String color, int size) {
        return null;
    }


}
