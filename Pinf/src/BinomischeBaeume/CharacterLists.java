package BinomischeBaeume;

import java.util.ArrayList;

public class CharacterLists {
    public static final ArrayList<Character> OPERATORS = fillListWithOperators();
    public static final ArrayList<Character> CHARACTERS = fillListWithCharacters();
    public static final ArrayList<Character> NUMBERS = fillListWithNumbers();
    public static final ArrayList<Character> OPERATORSANDCHARACTERS = fillListWithOperatorsAndCharacters();

    public CharacterLists(){

    }

    private static ArrayList<Character> fillListWithOperators(){
        ArrayList<Character> list = new ArrayList<>();
        list.add('+');
        list.add('-');
        list.add('*');
        list.add('/');
        list.add('^');

        return list;
    }

    private static ArrayList<Character> fillListWithCharacters(){
        ArrayList<Character> list = new ArrayList<>();
        list.add('(');
        list.add(')');
        list.add(',');
        list.add('.');

        return list;
    }

    private static ArrayList<Character> fillListWithNumbers(){
        ArrayList<Character> list = new ArrayList<>();
        list.add('0');
        list.add('1');
        list.add('2');
        list.add('3');
        list.add('4');
        list.add('5');
        list.add('6');
        list.add('7');
        list.add('8');
        list.add('9');

        return list;

    }

    private static ArrayList<Character> fillListWithOperatorsAndCharacters(){
        ArrayList<Character> list = new ArrayList<>();
        list.addAll(fillListWithCharacters());
        list.addAll(fillListWithOperators());
        return list;
    }
}
