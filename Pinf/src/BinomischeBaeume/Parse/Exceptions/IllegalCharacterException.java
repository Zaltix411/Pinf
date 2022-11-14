package BinomischeBaeume.Parse.Exceptions;

public class IllegalCharacterException extends Exception{
    StringBuilder stringBuilder;
    public IllegalCharacterException(StringBuilder stringBuilder){
        this.stringBuilder = stringBuilder;
    }

    @Override
    public String getMessage(){
        char errorChar = stringBuilder.charAt(stringBuilder.length()-1);
        return "After characters: " + stringBuilder.deleteCharAt(stringBuilder.length()-1) + " illegal character (" + errorChar + ") found";
    }
}
