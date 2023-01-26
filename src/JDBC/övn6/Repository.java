package JDBC.övn6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
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

    public void callHireMakerElf(String name) {

        try (Connection c = DriverManager.getConnection(p.getProperty("connectionString"),
                            p.getProperty("name"), p.getProperty("password"));
             CallableStatement cstmt = c.prepareCall("call HireMakerElf(?)");
        ) {
            cstmt.setString(1,name);
            cstmt.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());;

        }

    }


}
