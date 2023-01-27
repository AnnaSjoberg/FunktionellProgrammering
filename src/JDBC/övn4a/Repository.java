package JDBC.övn4a;

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
            p.load(new FileInputStream("src/JDBC/settings.properties"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Child> getAllChildren() {
        String query = "select id from child";
        List<Child> children = new ArrayList<>();
        List<Integer> allChildIDs = new ArrayList<>();

        try (Connection c = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"), p.getProperty("password"));
             PreparedStatement pstmt = c.prepareStatement(query);
        ) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                allChildIDs.add(rs.getInt("id"));
            }

            children = allChildIDs.stream().map(i -> getChildById(i)).toList();

        } catch (Exception e) {
            e.printStackTrace();

        }

        return children;
    }

    public Child getChildById(int id) {
        Child child = new Child();
        Country country = getCountryByChildId(id);
        List<Present> wishList = getWishlistbyChildId(id);
        List<Present> giftList = getGiftListbyChildId(id);

        String query = "select child.id, child.name, child.address from child " +
                "inner join country on child.countryid = country.id where child.id = ?";

        try (Connection c = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"), p.getProperty("password"));
             PreparedStatement pstmt = c.prepareStatement(query);
        ) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                child = new Child(rs.getInt("id"), rs.getString("name"),
                        rs.getString("address"), country, wishList,giftList);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return child;
    }
    public Country getCountryByChildId(int id){
        Country country = new Country();
        String query = "select country.id, country.name from country inner join child" +
                " on child.countryid = country.id where child.id = ?";

        try (Connection c = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"), p.getProperty("password"));
             PreparedStatement pstmt = c.prepareStatement(query);
        ) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                country = new Country(rs.getInt("id"),rs.getString("name"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return country;
    }

    public List<Present> getWishlistbyChildId (int id){
        List<Present> wishList = new ArrayList<>();
        String query = "select present.id as pId, present.name, child.id from present " +
                "inner join wishes on present.id = wishes.presentid " +
                "inner join child on wishes.childid = child.id where child.id = ?";

        try (Connection c = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"), p.getProperty("password"));
             PreparedStatement pstmt = c.prepareStatement(query);
        ) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                wishList.add(new Present(rs.getInt("pId"),
                        rs.getString("name")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return wishList;
    }

    public List<Present> getGiftListbyChildId (int id){
        List<Present> giftList = new ArrayList<>();
        String query = "select present.id as pID, present.name, child.id from present " +
                "inner join gets on present.id = gets.presentid " +
                "inner join child on gets.childid = child.id where child.id = ?";

        try (Connection c = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"), p.getProperty("password"));
             PreparedStatement pstmt = c.prepareStatement(query);
        ) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                giftList.add(new Present(rs.getInt("pID"),
                        rs.getString("name")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return giftList;
    }
}
