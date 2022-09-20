package BinomischeBaeume;

public class test {
    public static void main(String[] args) {
        Value leftValue = new Value(10);
        Value rightvalue = new Value(5);

       Operator operator = new Operator(leftValue, rightvalue, OperatorType.ADD);

        System.out.println(operator.toString());
    }
}
