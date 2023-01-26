package JDBC.övn3a;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Repository {
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

    public String updateElfName(String newName, String deadName) {
        String errorMessage ="";

        try (Connection con = DriverManager.getConnection(prop.getProperty("connectionString"),
                prop.getProperty("name"), prop.getProperty("password"));
             PreparedStatement ps = con.prepareStatement("update elf set name = ? where name = ?");

        ) {
            ps.setString(1, newName);
            ps.setString(2,deadName);
            int updatedRows = ps.executeUpdate();

            if (updatedRows==0){
                errorMessage = "There was no elf called " + deadName + " on record";
            }
            if (updatedRows>1){
                errorMessage = "Oops! "+ updatedRows + " elves got their " +
                        "names changed from " +deadName +" to "+newName;
            }
            if (!errorMessage.equals("")){
                return errorMessage;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return "We will henceforth only refer to you as " + newName + " and not your deadname";

    }


}
