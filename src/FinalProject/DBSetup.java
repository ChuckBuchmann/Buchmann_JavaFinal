package FinalProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * I've worked with SQLite before and I think it'll be perfect for prototyping this application
 * That being said, I'm relying entirely on AI to help actually write the code to create my .db file
 * ty GPT
*/
public class DBSetup {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:player_database.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("Database created / connected successfully!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}