package JDBC.övn3b;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

    public void dropElfByName(String name) {
        String query = "Delete from elf where name = ?";
        String message = "Elf has been summarily sacked!";

        try (Connection c = DriverManager.getConnection(p.getProperty("connectionString"),
                            p.getProperty("name"), p.getProperty("password"));
             PreparedStatement pstmt = c.prepareStatement(query);
        ) {
            pstmt.setString(1,name);
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows==0){
                message ="Elf does not exist on record";
            }
            if (affectedRows>1){
                message ="Oops! More than one elf was deleted from record";
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println(message);
    }


}
