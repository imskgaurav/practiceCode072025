package test.java.Interview;

import java.util.stream.IntStream;

public class PrintNumbersWithLoop2 {
   static int x=1;

    public static void main(String[] args) {
        printNum();
        printNumWithStream();
    }

    static void printNum(){
     if(x<=10){
         System.out.println(x++);
         printNum();
     }
    }

    static void printNumWithStream(){
        System.out.println("Stream API");
        IntStream.rangeClosed(11,20).forEach(System.out::println);
    }
}
