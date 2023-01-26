package JDBC.övn2b;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Repository implements RepoInterface {
    Properties prop = new Properties();

    public Repository() {
        try {
            prop.load(new FileInputStream("src/JDBC/settings.properties"));
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
             PreparedStatement ps = con.prepareStatement("select child.id as id, child.name as name, niceNumber as nN from report inner join child on " +
                     "report.childid = child.id where child.name = ?");

        ) {
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                child = new Child(rs.getInt("id"), rs.getString("name"),
                                    rs.getInt("nN"));
            }
          //  return child;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return child;
    }


}
