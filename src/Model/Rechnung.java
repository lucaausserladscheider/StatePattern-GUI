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
        this.state = RechnungsStatus.strToState ( stateStr );
    }

    /**
     * gibt die ID zurück
     * @return int
     */
    public int getId () {
        return id;
    }

    /**
     * gibt die description zurück
     * @return String
     */
    public String getDescription () {
        return description;
    }

    /**
     * gibt den Wert zurück
     * @return double
     */
    public double getValue () {
        return value;
    }

    /**
     * wandelt einen String von der Datenbank oder Choicebox in einen gültigen Status
     * @param strStatus
     * @return RechnungsStatus
     */

    /**
     * setzt den Status in den übergebenen State
     * @param state
     */
    public void setState(RechnungsStatus state) {
        this.state = state;
    }

    /**
     * gibt den aktuellen RechnungsStatus zurück
     * @return
     */
    public RechnungsStatus getState() {
        return this.state;
    }
}
