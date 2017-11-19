package Model;

public class StatusGeschlossen implements RechnungsStatus {
    @Override
    public void setState ( Rechnung rechnung) {
        rechnung.setState ( this );
    }
    public StatusGeschlossen getState () {
        return this;
    }

    public String toString() {
        return "geschlossen";
    }
    @Override
    public String getName () {
        return "geschlossen";
    }
}
