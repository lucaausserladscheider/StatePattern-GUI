package Model;

/**
 * Status Gemahnt der von RechnungsStatus implementiert
 */
public class StatusGemahnt implements RechnungsStatus {

    /**
     * überschreibt dit toString des Interface RechnungsStatus
     * @return String
     */
    @Override
    public String toString() {
        return "gemahnt";
    }

}
