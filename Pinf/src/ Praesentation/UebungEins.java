import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.StandardSocketOptions;
import java.util.ArrayList;
import java.util.Scanner;

public class UebungEins {

    public static void main(String[] args) {

       test();
    }

    public static void world() {
        String hello = "Hello World!";
        System.out.println(hello);
    }

    public static void fragen() {
        String frage = "Wie heißen Sie";
        System.out.println(frage);

        Scanner input = new Scanner(System.in);
        String name = input.next();
        System.out.println("Hallo "+ name);

    }

    public static void matrix() {
        String aufgabe = "WHATISTHEMATRIX";
        ArrayList<String> fuellen = new ArrayList<>();

        for (int i = 0; i < aufgabe.length(); i += 3) {
            fuellen.add(aufgabe.substring(i, i + 3));
        }
        for (String s : fuellen) {
            System.out.println(s);
        }
    }

    public static double maximum(double a,double b){
        return Math.max(a,b);

    }


    public static int faculty(int pos_num){
        if (pos_num == 1){
            return pos_num;
        } else{
            return pos_num * faculty(pos_num-1);
        }
    }
/*
    public static int faculty(int a){
        int sum =1;
        for (int i=1;i<=a;i++){
            sum*=i;
        }

        return sum;
    }
*/

    public static void roeadToMillion() {
        int counter = 100000000;
        System.out.println(counter);
        for (int i = 0; i< 25;i++){
            counter += 100000000;
            System.out.println(counter);
        }
    }


    public static void test(){
        long beginn = System.currentTimeMillis();
        long end;

        for (int i =0; i<10000;i++){
            System.out.println(i);
        }
        end = System.currentTimeMillis() - beginn;
        System.out.println(end);
    }
}
