package JDBC.övn1;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Repository implements RepoInterface {
    Properties prop = new Properties();

    public Repository() {
        try {
            prop.load(new FileInputStream("src/vecka1/övn1/settings.properties"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getNumberOfChildren() {
        return getRowCount("child");
    }

    @Override
    public int getRowCount(String tableName) {
        int count = -1;
        try (Connection con = DriverManager.getConnection(prop.getProperty("connectionString"),
                prop.getProperty("name"), prop.getProperty("password"));
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select count(*) as totRows from " + tableName)
        ) {
            while (rs.next()) {
                count = rs.getInt("totRows");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return count;
    }

    @Override
    public List<Elf> getAllElves() {
        List<Elf> allElves = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(prop.getProperty("connectionString"),
                prop.getProperty("name"), prop.getProperty("password"));
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from elf")
        ) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                allElves.add(new Elf(id, name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return allElves;
    }

    @Override
    public double getNicenessAverage() {
        double avg = -1;
        try (Connection con = DriverManager.getConnection(prop.getProperty("connectionString"),
                prop.getProperty("name"), prop.getProperty("password"));
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select avg(niceNumber) as avg from report")
        ) {
            while (rs.next()) {
                avg = rs.getDouble("avg");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return avg;
    }
}
