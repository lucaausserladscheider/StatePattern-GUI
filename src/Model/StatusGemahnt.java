package Model;

public class StatusGemahnt implements RechnungsStatus {
    @Override
    public void setState ( Rechnung rechnung) {
        rechnung.setState ( this );
    }
    public StatusGemahnt getState () {
        return this;
    }

    public String toString() {
        return "gemahnt";
    }
    @Override
    public String getName () {
        return "gemahnt";
    }
}
