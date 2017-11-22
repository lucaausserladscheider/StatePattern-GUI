package Model;

/**
 * Interface der verschiedenen Rechnungsstatuse
 */
public interface RechnungsStatus {

    /**
     * gibt einen String des gewünschten Status zurück
     * @return String
     */
    String toString();

    static RechnungsStatus strToState(String status) {
        if (status.equals ( "offen" )) {
            return new StatusOffen ();
        } else if (status.equals ( "bezahlt" )) {
            return new StatusBezahlt ();
        } else if (status.equals ( "gemahnt" )) {
            return new StatusGemahnt ();
        } else if (status.equals ( "geschlossen" )) {
            return new StatusGeschlossen ();
        } else {
            return null;
        }
    }

}
