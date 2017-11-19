package Model;

import Database.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RechnungDAO {

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
    public void updateRechnung( Rechnung rechnung) {
        try {
            PreparedStatement myStmt = Database.getInstance ().getConnection ().prepareStatement ("UPDATE rechnung set id = ?, description = ?, value = ?, state = ? where ID = ?");

            myStmt.setInt ( 1, rechnung.getId () );
            myStmt.setString ( 2, rechnung.getDescription () );
            myStmt.setDouble ( 3, rechnung.getValue () );
            myStmt.setString ( 4, rechnung.getStateStr () );
            myStmt.setInt ( 5, rechnung.getId () );


            myStmt.executeUpdate ();

//            Statement myStmt = myConn.createStatement ();
//            String sql = "insert into invoice (datum, description, wert, paid ) values (datum, description, wert, paid)";
//            myStmt.executeUpdate (sql);

//            System.out.println ("Update Data complete!");

        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }
}
