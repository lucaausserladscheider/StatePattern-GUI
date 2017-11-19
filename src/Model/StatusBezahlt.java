package Model;

public class StatusBezahlt implements RechnungsStatus {
    @Override
    public void setState ( Rechnung rechnung) {
        rechnung.setState ( this );
    }

    @Override
    public StatusBezahlt getState () {
        return this;
    }

    public String toString() {
        return "bezahlt";
    }

    @Override
    public String getName () {
        return "bezahlt";
    }
}
