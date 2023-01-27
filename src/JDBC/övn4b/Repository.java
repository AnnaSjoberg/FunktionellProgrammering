package JDBC.övn4b;


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
    public List<Present> getAllPresents (){
        List<Present> presents = new ArrayList<>();
        List<Integer> allPresentIDs = new ArrayList<>();
        String query = "select id from present";

        try (Connection c = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"), p.getProperty("password"));
             PreparedStatement pstmt = c.prepareStatement(query);
        ) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                allPresentIDs.add(rs.getInt("id"));
            }

            presents = allPresentIDs.stream().map(i -> getPresentById(i)).toList();

        } catch (Exception e) {
            e.printStackTrace();

        }

        return presents;
    }

    public Present getPresentById (int id){
        Present present = new Present();
        List<Child> wantedBy = getWishingChildrenByPresentID(id);
        List<Child> giftedTo = getReceivingChildrenByPresentID(id);

        String query = "select name from present where id = ?";

        try (Connection c = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"), p.getProperty("password"));
             PreparedStatement pstmt = c.prepareStatement(query);
        ) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                present = new Present(id, rs.getString("name"),wantedBy,giftedTo);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return present;
    }

    public List<Child> getWishingChildrenByPresentID(int id){
        List<Child> wantedBy = new ArrayList<>();
        String query = "select child.id as childId, child.name as name, child.address, " +
                "present.id from child inner join wishes on child.id = wishes.childId " +
                "inner join present on wishes.presentId = present.id where present.id = ?";

        try (Connection c = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"), p.getProperty("password"));
             PreparedStatement pstmt = c.prepareStatement(query);
        ) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                wantedBy.add(new Child(rs.getInt("childId"),
                        rs.getString("name"),rs.getString("address")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return wantedBy;
    }
    public List<Child> getReceivingChildrenByPresentID(int id){
        List<Child> giftedTo = new ArrayList<>();
        String query = "select child.id as childId, child.name as name, child.address, " +
                "present.id from child inner join gets on child.id = gets.childId " +
                "inner join present on gets.presentId = present.id where present.id = ?";

        try (Connection c = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"), p.getProperty("password"));
             PreparedStatement pstmt = c.prepareStatement(query);
        ) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                giftedTo.add(new Child(rs.getInt("childId"),
                        rs.getString("name"),rs.getString("address")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return giftedTo;
    }
}
/*
Skriv ett program som skriver ut en present och sedan namnet på de barn som har önskat den
presenten och de barn som fått den presenten.
 */