package Model;

public interface RechnungsStatus {

    public void setState( Rechnung rechnung);
    public RechnungsStatus getState();
    public String toString();
    public String getName();

}
