package BinomischeBaeume;

public class Operator implements Node{

OperatorType operator;
private double value;
private Node leftValue;
private Node rightValue;

public Operator(Node leftValue, Node rightValue, OperatorType operatorType){

    this.operator = operatorType;
    this.leftValue = leftValue;
    this.rightValue = rightValue;
    }

    @Override
    public double getValue() {
        return this.operator.getValue(this.leftValue, this.rightValue);
    }

    @Override
    public String toString() {

        return "(" +
                this.leftValue.toString() +
                "," +
                this.rightValue.toString() +
                ")" +
                this.operator.toString();
    }
}
