package Model;

/**
 * Status Offen der von RechnungsStatus implementiert
 */
public class StatusOffen implements RechnungsStatus {

    /**
     * überschreibt dit toString des Interface RechnungsStatus
     * @return String
     */
    @Override
    public String toString() {
        return "offen";
    }
}
