package Database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    Connection conn;
    private static Database base = new Database();

    private Database() {
        try {
            conn = setConnection ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }

    private Connection setConnection() throws SQLException {
        try {
            return DriverManager.getConnection ( "jdbc:mysql://localhost:3306/state_pattern", "root", "" );
        } catch (SQLException e) {
            e.printStackTrace ();
            return null;
        }
    }

    public static Database getInstance() {
        return base;
    }

    public Connection getConnection () {
        return conn;
    }
}
