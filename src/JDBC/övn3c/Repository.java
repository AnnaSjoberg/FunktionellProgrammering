package JDBC.övn3c;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class Repository {
    Properties p = new Properties();

    public Repository() {
        try {
            p.load(new FileInputStream("src/JDBC/settings.properties"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String AddPresent(String name, int makerElfId) {
        String query = "Insert into present (name, accountableMakerElfId) values (?,?)";
        String message = "";

        try (Connection c = DriverManager.getConnection(p.getProperty("connectionString"),
                            p.getProperty("name"), p.getProperty("password"));
             PreparedStatement pstmt = c.prepareStatement(query);
        ) {
            pstmt.setString(1,name);
            pstmt.setInt(2,makerElfId);
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows==0){
                message ="Item could not be added to the list of presents";
            }
            if (affectedRows>1){
                message ="Item was added several times to list";
            }
            if (message.equalsIgnoreCase("")){
                message = name + " was added to list of presents";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Something went wrong. Could not add " + name;
        }

        return message;
    }


}
