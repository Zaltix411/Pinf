package BinomischeBaeume.Parse;

import java.util.ArrayList;

public class TermParser2 {

    String[] arr;

    private final String input;
    private ArrayList<Character> output = new ArrayList<>();
    private ArrayList<Character> stack = new ArrayList<>();
    public TermParser2(String input){
        this.input = input;
    }

    private boolean test = true;


    public String[] parse() {

        String temp = input;
        temp = temp.replaceAll("[\\s|\\u00A0]+", "");
        temp = temp.replace(",", ".");


        for(int i = 0; i< input.length(); i++){
            if( CharacterLists.NUMBERS.contains(temp.charAt(i)) && temp.charAt(i) == '.' ){
                output.add(temp.charAt(i));
            }

            if(CharacterLists.OPERATORS.contains(temp.charAt(i))){
                stack.add(temp.charAt(i));
            }

           if(CharacterLists.CHARACTERS.contains(temp.charAt(i))){
               do{
                   test = false;
                   if(stack.size() > 0 && CharacterLists.CHARACTERS.contains(stack.get(stack.size()-1)) && temp.charAt(i) ) {
                       output.add(stack.get(stack.size() - 1));
                       test = true;
                   }
               }while(test == true);
               stack.add(temp.charAt(i));
           }

           if(temp.charAt(i) == '('){
               stack.add(temp.charAt(i));
           }
           if(temp.charAt(i) == ')'){
               if()
           }
        }




        return arr;
    }
}
