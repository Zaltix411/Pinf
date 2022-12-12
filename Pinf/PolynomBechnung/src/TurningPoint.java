public class TurningPoint extends SpecialPoint{

    boolean isGlobal;
    double xvalue;
    double yvalue;

    public TurningPoint(boolean isGlobal, double xvalue,double yvalue){
        super(xvalue, yvalue);
        this.isGlobal = isGlobal;
    }
}
