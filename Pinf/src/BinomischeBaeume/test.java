package BinomischeBaeume;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        Value leftValue = new Value(4);
        Value rightValue = new Value(5);
        ArrayList<Node> input = new ArrayList<>();
        Operator operator = new Operator(leftValue,rightValue,OperatorType.ADD);
        input.add(operator);
        TermParser.Parse(input);
    }
}
