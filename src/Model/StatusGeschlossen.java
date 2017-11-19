package Model;

/**
 * Status Geschlossen der von RechnungsStatus implementiert
 */
public class StatusGeschlossen implements RechnungsStatus {

    /**
     * überschreibt dit toString des Interface RechnungsStatus
     * @return String
     */
    @Override
    public String toString() {
        return "geschlossen";
    }

}
