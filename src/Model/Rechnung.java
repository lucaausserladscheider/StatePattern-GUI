package Model;

/**
 * Klasse Rechnung haltet wichtige Datenfelder für die Speicherung in der Datenbank.
 *
 * @author Luca Ausserladscheider
 */
public class Rechnung {

    private int id;
    private String description;
    private double value;
    private String stateStr;

    private RechnungsStatus state;

    /**
     * Konstruktor, der eine Instanz richtig instanziert
     * @param id
     * @param description
     * @param value
     * @param stateStr
     */
    public Rechnung(int id, String  description, double value, String stateStr) {

        this.id = id;
        this.description = description;
        this.value = value;
        this.stateStr = stateStr;
        this.state = strToState ( stateStr );
    }


    public int getId () {
        return id;
    }

    public String getDescription () {
        return description;
    }

    public double getValue () {
        return value;
    }


    public String getStateStr () {
        return stateStr;
    }

    public RechnungsStatus strToState(String strStatus) {
        if (strStatus.equals ( "offen" )) {
            return new StatusOffen ();
        } else if (strStatus.equals ( "bezahlt" )) {
            return new StatusBezahlt ();
        } else if (strStatus.equals ( "gemahnt" )) {
            return new StatusGemahnt ();
        } else if (strStatus.equals ( "geschlossen" )) {
            return new StatusGeschlossen ();
        } else {
            return null;
        }
    }
}
