package Model;

/**
 * Status Bezahlt der von RechnungsStatus implementiert
 */
public class StatusBezahlt implements RechnungsStatus {

    /**
     * überschreibt dit toString des Interface RechnungsStatus
     * @return String
     */
    @Override
    public String toString() {
        return "bezahlt";
    }

}
