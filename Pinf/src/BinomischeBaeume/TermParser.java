package BinomischeBaeume;


import BinomischeBaeume.Exceptions.IllegalCharacterAfterNumberException;
import BinomischeBaeume.Exceptions.IllegalCharacterException;
import BinomischeBaeume.Exceptions.TwoCharactersInARowException;
import BinomischeBaeume.Exceptions.WrongBracketsException;

import java.util.ArrayList;
import java.util.Arrays;
public class TermParser {
    private String[] arr;
    private final String input;
    private final CharacterLists characterLists = new CharacterLists();
    private int amountOfOpeningBracketsWithoutClosingBrackets;
    private StringBuilder allCharacters;

    public TermParser(String input){
        this.input = input;
    }

    public String[] parse(String s) throws WrongBracketsException, IllegalCharacterException, IllegalCharacterAfterNumberException, TwoCharactersInARowException {


            String temp = input;

            temp = temp.replaceAll("[\\s|\\u00A0]+", "");

            for (int i = 0; i < input.length(); i++) {
                if(input.charAt(i) == '-' && CharacterLists.NUMBERS.contains(input.charAt(i+1))) {

                    if (input.charAt(0) == '-' || CharacterLists.OPERATORS.contains(input.charAt(i-1))) {
                            i++;
                        }
                    }
                // If current char is an operator or a bracket
                if(CharacterLists.OPERATORS.contains(input.charAt(i)) || input.charAt(i) == '(' || input.charAt(i) == ')'){
                    // Extend operator with two whitespaces around it
                    temp = temp.replace(String.valueOf(input.charAt(i)), " " + input.charAt(i)+ " ");
                }
            }

            temp = temp.replace(",", ".");
            arr = temp.split(" ");

            ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));

            list.removeIf(s -> s.equals(""));

            arr = list.toArray(new String[0]);

            illegalInput();





        return arr;
    }

    public void illegalInput() throws IllegalCharacterException, IllegalCharacterAfterNumberException, TwoCharactersInARowException, WrongBracketsException {
        amountOfOpeningBracketsWithoutClosingBrackets = 0;
        allCharacters = new StringBuilder();

        try{
            for(String s: arr){
                illegalCharacter(s);
                illegalBrackets(s);
                illegalCharactersAfterNumber(s);
            }
            if (amountOfOpeningBracketsWithoutClosingBrackets != 0) {
                throw new WrongBracketsException(1);
            }
            checkForTwoCharacterInARow();
        }catch (IllegalCharacterException | IllegalCharacterAfterNumberException | TwoCharactersInARowException | WrongBracketsException e) {
            arr = new String[] {e.getMessage()};
        }
    }



    public void illegalCharacter(String s) throws IllegalCharacterException {

        for (int i = 0; i < s.length(); i++){
            allCharacters.append(s.charAt(i));

            if(!CharacterLists.CHARACTERS.contains(s.charAt(i)) && !CharacterLists.OPERATORS.contains(s.charAt(i)) && !CharacterLists.NUMBERS.contains(s.charAt(i))){
                throw new IllegalCharacterException(allCharacters);
            }

        }
    }

    public void illegalBrackets(String s) throws IllegalCharacterAfterNumberException{
        if(s.charAt(s.length() - 1) == '.' || s.charAt(s.length() - 1) == ','){
            throw new IllegalCharacterAfterNumberException(allCharacters);
        }
    }


   public void illegalCharactersAfterNumber(String s) throws IllegalCharacterAfterNumberException {
        if(s.charAt(s.length()-1) == ',' || s.charAt(s.length()-1) == '.'){
            throw new IllegalCharacterAfterNumberException(allCharacters);
        }
   }


    public void checkForTwoCharacterInARow() throws TwoCharactersInARowException{
        allCharacters = new StringBuilder();

        for (int i = 0; i < arr.length; i++){


            if(arr[i].length() == 1 && i + 1 != arr.length && CharacterLists.OPERATORSANDCHARACTERS.contains(arr[i].charAt(0)) && CharacterLists.OPERATORSANDCHARACTERS.contains(arr[i + 1].charAt(0)) && arr[i + 1].charAt(0) != '(' && arr[i + 1].charAt(0) != ')') {
                allCharacters.append(arr[i]);{

                }
                if(arr[i+ 1].length() == 1 || CharacterLists.CHARACTERS.contains(arr[i + 1].charAt(0))){
                    allCharacters.append(arr[i + 1].charAt(0));
                    throw new TwoCharactersInARowException(allCharacters);
                }
                else{

                    for (int j = 0; j < arr[i].length(); i++){
                        // If two same chars are after one another in the same string
                        if(j + 1 != arr[i].length() && CharacterLists.CHARACTERS.contains(arr[i].charAt(j)) && CharacterLists.OPERATORSANDCHARACTERS.contains(arr[i].charAt(j + 1))){
                            throw new TwoCharactersInARowException(allCharacters);
                        }

                    }
                }
            }


        }
    }

    @Override
    public String toString() {
        if (arr == null) return "The array is null";

        StringBuilder stringBuilder = new StringBuilder();
        for (String s : arr) {
            if (arr.length != 1) {
                stringBuilder.append("[").append(s).append("]");
            } else {
                stringBuilder.append(s);
            }
        }
        return stringBuilder.toString();
    }

}
