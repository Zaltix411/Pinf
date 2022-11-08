package BinomischeBaeume;

public class ParseException extends Exception{

    public ParseException() {}

    @Override
    public String getMessage(){
        return "false Argument found";
    }
}
