package BinomischeBaeume.Parse;

import java.util.ArrayList;

public class TermParser2 {

    String[] arr;

    private final String input;
    private String output;
    private  ArrayList<String> stack = new ArrayList<>();
    public TermParser2(String input){
        this.input = input;
    }


    public String[] parse() {

        String temp = input;
        temp = temp.replaceAll("[\\s|\\u00A0]+", "");
        temp = temp.replace(",", ".");


        for(int i = 0; i< input.length(); i++){
            if( CharacterLists.NUMBERS.contains(temp.charAt(i)) && temp.charAt(i) == '.' ){
                output += temp.charAt(i);
            }

            if(CharacterLists.OPERATORS.contains(temp.charAt(i))){
                stack.add(String.valueOf(temp.charAt(i)));
            }

           if(CharacterLists.CHARACTERS.contains(temp.charAt(i))){
               while(stack != null && CharacterLists.CHARACTERS.contains(stack.get(0)) ){

               }
           }
        }




        return arr;
    }
}
