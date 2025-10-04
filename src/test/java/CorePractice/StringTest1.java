package test.java.CorePractice;

public class StringTest1 {

    public static void main(String[] args) {
        /*Interview Takeaway:
isEmpty() → checks only length.
isBlank() → checks length and whitespace (added in Java 11).*/
        String s2= null;
        String s1= "";
        System.out.println("Type Of String:"+s1.isBlank());
        System.out.println("Type Of String:"+s1.isEmpty());
        //System.out.print("Type Of String"+s2.isBlank());
        String s3= " ";
        System.out.println("String with a WhiteSpace Test");
        System.out.println("Blank Function :"+s3.isBlank());
        System.out.println("Empty Function :"+s3.isEmpty());
        System.out.println("lenght of String is :"+s3.length());
        String s4 = "\n";

        System.out.println(s4.length());
        System.out.println(s4.isEmpty());
        System.out.println(s4.isBlank());





    }
}
