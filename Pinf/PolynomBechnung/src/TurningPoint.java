package Pinf.PolynomBechnung.src;

public class TurningPoint extends SpecialPoint {

    boolean isGlobal;
    double xValue;
    double yValue;

    public TurningPoint(boolean isGlobal, double xValue, double yValue) {
        super(xValue, yValue);
        this.isGlobal = isGlobal;
    }
}
