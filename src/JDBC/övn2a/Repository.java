package JDBC.övn2a;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Repository implements RepoInterface {
    Properties prop = new Properties();

    public Repository() {
        try {
            prop.load(new FileInputStream("src/vecka1/övn2a/settings.properties"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Child getChildByName(String name) {
        Child child = null;

        try (Connection con = DriverManager.getConnection(prop.getProperty("connectionString"),
                prop.getProperty("name"), prop.getProperty("password"));
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select child.id as id, child.name as name, GoodnessIndex as gI from report inner join child on " +
                     "report.childid = child.id where child.name = \'" + name + "\'")
        ) {
            while (rs.next()) {
                child = new Child(rs.getInt("id"), rs.getString("name"),
                                    rs.getInt("gI"));
            }
          //  return child;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return child;
    }


}
