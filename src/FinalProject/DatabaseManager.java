package FinalProject;

import java.sql.*;

// The code used in DBSetup - GPT recommends a separate class and I think that is sound advice
public class DatabaseManager {

    private static final String URL = "jdbc:sqlite:player_database.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void createTables() {
        String playerTable = """
            CREATE TABLE IF NOT EXISTS player_state (
                id INTEGER PRIMARY KEY,
                front_door_key INTEGER,
                ingredient_cupboard_key INTEGER,
                gloves INTEGER,
                objective_complete INTEGER,
                death_cap INTEGER,
                current_room TEXT
            );
        """;

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(playerTable);
            System.out.println("Tables created or already exist.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /* 
     * Now the code to actually send the player state to the DB
     * Mostly GPT but I feel I have a good grasp of what's going on
     * Also I got to use my getters to actually get the data, hell yea - that's like, their purpose
    */
    public static void savePlayer(Player player) {
    	// Empty prepared statement
        String sql = """
            INSERT OR REPLACE INTO player_state
            (id, front_door_key, ingredient_cupboard_key, gloves, objective_complete, death_cap, current_room)
            VALUES (?, ?, ?, ?, ?, ?, ?);
        """;

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

        	// prepared statement prepared programmatically
            pstmt.setInt(1, 1); // ID - necessary in SQL
            pstmt.setBoolean(2, player.hasFrontDoorKey());
            pstmt.setBoolean(3, player.hasIngredientCupboardKey());
            pstmt.setBoolean(4, player.hasGloves());
            pstmt.setBoolean(5, player.hasObjectiveComplete());
            pstmt.setBoolean(6, player.hasDeathCap());
            pstmt.setString(7, player.getCurrentRoom());

            pstmt.executeUpdate();
            System.out.println("Player saved successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Now the reverse - grabbing the player state from the DB and returning it so it can be shoved into a player object
    public static Player loadPlayer() {

        String sql = "SELECT * FROM player_state WHERE id = 1";  // ID will always be one due to INSERT INTO OR REPLACE prepared statement

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            if (rs.next()) {

                Player player = new Player();
                
                // Useful methods I've never seen before, thanks GPT
                // Also thanks SQLite - this is truly a powerful tool for quick projects
                player.setFrontDoorKey(rs.getBoolean("front_door_key"));
                player.setIngredientCupboardKey(rs.getBoolean("ingredient_cupboard_key"));
                player.setGloves(rs.getBoolean("gloves"));
                player.setObjectiveComplete(rs.getBoolean("objective_complete"));
                player.setDeathCap(rs.getBoolean("death_cap"));
                player.setCurrentRoom(rs.getString("current_room"));

                System.out.println("Player loaded successfully.");
                return player;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // no save found
    }
}