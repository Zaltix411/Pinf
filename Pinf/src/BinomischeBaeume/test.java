package BinomischeBaeume;

public class test {
    public static void main(String[] args) {
        Value leftValue = new Value(10);
        Value rightValue = new Value(5);

       Operator operator = new Operator(leftValue, rightValue, OperatorType.ADD);

        System.out.println(operator.toString());
    }
}
