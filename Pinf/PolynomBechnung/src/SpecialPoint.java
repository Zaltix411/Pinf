public abstract class SpecialPoint {
    double xvalue;
    double yvalue;

    public SpecialPoint(double xvalue, double yvalue){
        this.xvalue = xvalue;
        this.yvalue = yvalue;
    }



    public double getXvalue() {
        return xvalue;
    }

    public void setXvalue(double xvalue) {
        this.xvalue = xvalue;
    }

    public double getYvalue() {
        return yvalue;
    }

    public void setYvalue(double yvalue) {
        this.yvalue = yvalue;
    }
}
