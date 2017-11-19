package Model;

public class StatusOffen implements RechnungsStatus {
    @Override
    public void setState ( Rechnung rechnung) {
        rechnung.setState ( this );
    }

    public StatusOffen getState () {
        return this;
    }

    public String toString() {
        return "offen";
    }
    @Override
    public String getName () {
        return "offen";
    }
}
