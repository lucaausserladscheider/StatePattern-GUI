package Controller;

import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * Die Controller Klasse der sample.fxml View
 * @author Luca Ausserladscheider
 */
public class Controller implements Initializable {

    ObservableList<String> stateList = FXCollections.observableArrayList (
            new StatusOffen ().toString (), new StatusBezahlt ().toString (), new StatusGemahnt ().toString (), new StatusGeschlossen ().toString () );

    @FXML
    private TableView<Rechnung> table;
    @FXML
    private TableColumn<Rechnung, Integer> ColID;
    @FXML
    private TableColumn<Rechnung, String> ColDesc;
    @FXML
    private TableColumn<Rechnung, Double> ColValue;
    @FXML
    private TableColumn<Rechnung, String> ColState;
    @FXML
    private TextField desc;
    @FXML
    private TextField id;
    @FXML
    private TextField value;
    @FXML
    private ChoiceBox<String> choiceBox;

    /**
     * überschreibt die initialize des Interface Initializeable
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize ( URL location, ResourceBundle resources ) {
        try {
            setCol ();

        } catch (Exception e) {
            e.printStackTrace ();
        }
    }

    /**
     * Ruft zuerst die Controller.initial Methode auf um die TableView Columns zu initialisieren und anschließend
     * werden die items auf die Tableview ausgegeben, je nach Status wird die Farbe der Zeile geändert (könnte man
     * auslagern in eine eigen Funktion)
     *
     * @throws Exception
     */
    private void setCol () throws Exception {
        initial ();

        Model.RechnungDAO dao = new Model.RechnungDAO ();
        ObservableList<Rechnung> list = FXCollections.observableArrayList ( dao.getAllInvoices () );

        table.setItems ( list );

        table.setRowFactory ( param -> new TableRow<Rechnung> () {
            @Override
            protected void updateItem ( Rechnung item, boolean empty ) {
                super.updateItem ( item, empty );

                if (item == null) {
                    setStyle ( "" );
                } else if (item.getStateStr ().equals ( "offen" )) {
                    setStyle ( "-fx-background-color: lightcyan;" );
                } else if (item.getStateStr ().equals ( "bezahlt" )) {
                    setStyle ( "-fx-background-color: lightgreen;" );
                }else if (item.getStateStr ().equals ( "gemahnt" )) {
                    setStyle ( "-fx-background-color: lightcoral;" );
                }else if (item.getStateStr ().equals ( "geschlossen" )) {
                    setStyle ( "-fx-background-color: lightblue;" );
                }else {
                    System.out.println ( "Else" );
                    setStyle ( "" );
                }
            }
        });

    }

    /**
     * initial wird aufgerufen um die Zeilen zu initialisieren
     *
     * @throws Exception
     */
    private void initial () throws Exception{
        ColID.setCellValueFactory ( new PropertyValueFactory<> ( "id" ) );
        ColDesc.setCellValueFactory ( new PropertyValueFactory<> ( "description" ) );
        ColValue.setCellValueFactory ( new PropertyValueFactory<> ( "value" ) );
        ColState.setCellValueFactory ( new PropertyValueFactory<> ( "stateStr" ) );
        choiceBox.setItems ( stateList );
    }

    /**
     * Wird aufgerufen, wenn eine Zeile in der TabelView angeklckt wird
     *
     * @throws Exception
     */
    public void tableClick () throws Exception {
        ObservableList list = table.getSelectionModel ().getSelectedItems ();
        Rechnung rechnung = (Rechnung) list.get ( 0 );

        desc.setText ( rechnung.getDescription () );
        id.setText ( Integer.toString ( rechnung.getId () ) );
        value.setText ( Double.toString ( rechnung.getValue () ) );
        choiceBox.setValue ( rechnung.getStateStr () );
    }

    /**
     * Wird aufgerufen, wenn auf der GUI der Button "aktualisieren" gedrückt wird
     *
     * @throws Exception
     */
    public void setChanges () throws Exception {
        int idEnd = Integer.parseInt ( id.getText () );
        String descEnd = desc.getText ();
        double valueEnd = Double.parseDouble ( value.getText () );
        RechnungsStatus state;
        if (choiceBox.getValue ().equals ( "offen" )) {
            state = new StatusOffen ();
        } else if (choiceBox.getValue ().equals ( "bezahlt" )) {
            state = new StatusBezahlt ();
        } else if (choiceBox.getValue ().equals ( "gemahnt" )) {
            state = new StatusGemahnt ();
        } else if (choiceBox.getValue ().equals ( "geschlossen" )) {
            state = new StatusGeschlossen ();
        } else {
            state = new StatusOffen ();
        }

        RechnungDAO dao = new RechnungDAO ();
        Rechnung rechnung = new Rechnung ( idEnd, descEnd, valueEnd, state.toString () );
        dao.updateRechnung ( rechnung );

        setCol ();

    }

}
