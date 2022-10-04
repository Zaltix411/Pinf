package BinomischeBaeume;

public class TermParser {

    static final String OPERATORS = "+-*/^()";
    public static void parse(String input) {

        for (int i = 0; i < input.length(); i++){
            System.out.println(OPERATORS.contains(String.valueOf(input.charAt(i))));
        }

    }
}
