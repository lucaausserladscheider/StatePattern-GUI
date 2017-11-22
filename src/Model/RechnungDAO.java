package Model;

import Database.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * RechnungDAO ist meine Data Access Object Class und ist verantwortlich für den Daten
 * austausch mit der Datenbank
 *
 * @author Luca Ausserladscheider
 */
public class RechnungDAO {

    /**
     * Gibt alle Rechnung die in der Datenbank gespeichert sind zurück
     *
     * @return ArrayList<Rechnung>
     */
    public ArrayList<Rechnung> getAllInvoices() {

        try {
            Statement myStmt = Database.getInstance().getConnection ().createStatement ();
            String sql = "Select * from Rechnung";
            ResultSet rs = myStmt.executeQuery ( sql );
            ArrayList<Rechnung> all = new ArrayList<> (  );
            while (rs.next ()) {
                all.add ( new Rechnung(rs.getInt ( "id" ), rs.getString ( "description" ), rs.getDouble ( "value" ), rs.getString ( "state" )) );
            }

            return all;

        } catch (SQLException e) {
            e.printStackTrace ();
            return null;
        }
    }

    /**
     * Methode um geänderte Werte zu speichern
     */
    public void updateRechnung( Rechnung rechnung) {
        try {
            PreparedStatement myStmt = Database.getInstance ().getConnection ().prepareStatement ("UPDATE rechnung set id = ?, description = ?, value = ?, state = ? where ID = ?");

            myStmt.setInt ( 1, rechnung.getId () );
            myStmt.setString ( 2, rechnung.getDescription () );
            myStmt.setDouble ( 3, rechnung.getValue () );
            myStmt.setString ( 4, rechnung.getState ().toString () );
            myStmt.setInt ( 5, rechnung.getId () );


            myStmt.executeUpdate ();

        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }
}
