package Database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Sinleton Pattern Klasse zur Verbindung zur Datenbank
 */
public class Database {
    Connection conn;
    private static Database base = new Database();

    /**
     * Konstruktor erzeugt eine Connection
     */
    private Database() {
        try {
            conn = setConnection ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }

    /**
     * Hier wird die Verbindung zur Datenbank hergestellt
     *
     * @return Connection
     * @throws SQLException
     */
    private Connection setConnection() throws SQLException {
        try {
            return DriverManager.getConnection ( "jdbc:mysql://localhost:3306/state_pattern", "root", "" );
        } catch (SQLException e) {
            e.printStackTrace ();
            return null;
        }
    }

    /**
     * Gibt eine DatenbakInstanz der eigenen Klasse zurück
     * @return Database
     */
    public static Database getInstance() {
        return base;
    }

    /**
     * gibt die Connection zurück
     * @return Connection
     */
    public Connection getConnection () {
        return conn;
    }
}
