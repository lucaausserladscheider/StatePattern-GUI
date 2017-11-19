package Model;

public class Rechnung {

    private int id;
    private String description;
    private double value;
    private String stateStr;

    private RechnungsStatus state;

    public Rechnung(int id, String  description, double value, String stateStr) {

        this.id = id;
        this.description = description;
        this.value = value;
        this.stateStr = stateStr;
        this.state = strToState ( stateStr );
    }
//    public Rechnung(int id, String  description, double value, RechnungsStatus status) {
//        this.id = id;
//        this.value = value;
//        this.description = description;
//        this.state = status;
//    }


    public void setState ( RechnungsStatus status) {
        this.state = status;
    }

    public RechnungsStatus getState () {
        return state;
    }

    public int getId () {
        return id;
    }

    public void setId ( int id ) {
        this.id = id;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription ( String description ) {
        this.description = description;
    }

    public double getValue () {
        return value;
    }

    public void setValue ( double value ) {
        this.value = value;
    }


    public String getStateStr () {
        return stateStr;
    }

    public void setStateStr ( String stateStr ) {
        this.stateStr = stateStr;
    }

    public RechnungsStatus strToState(String strStatus) {
        if (strStatus.equals ( "offen" )) {
            return new StatusOffen ();
        } else if (strStatus.equals ( "bezahlt" )) {
            return new StatusBezahlt ();
        } else if (strStatus.equals ( "gemahnt" )) {
            return new StatusGemahnt ();
        } else if (strStatus.equals ( "geschlossen" )) {
            return new StatusGeschlossen ();
        } else {
            return null;
        }
    }
}
