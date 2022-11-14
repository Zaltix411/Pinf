package BinomischeBaeume.Parse;

import BinomischeBaeume.Operator.Node;

public class Value implements Node {
    private double value;

    public Value(double value){

        this.value = value;
    }

    @Override
    public double getValue() {
        return value;
    }
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
