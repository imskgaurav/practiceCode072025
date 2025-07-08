package test.java.CorePractice;

public class CountOccurrenceStringChar_Java8 {

    public static void main(String[] args) {

        String str= "Keerthana";

       int eCount= (int) str.chars().filter(ch->ch=='e').count();

        System.out.println("e Counts is :"+ eCount);

         long  aCount=  str.chars().filter(c->c=='a').count();

        System.out.println("a Counts is :"+ aCount);


    }
}
