package test.java.CorePractice;

import java.sql.SQLOutput;

public class TestString {

    static int i;
    String s;
    boolean b;

    public static void main(String[] args) {
  /// https://www.youtube.com/watch?v=4PtaheVYGEE&t=975s
      TestString ts = new TestString();
        System.out.println(ts.s);
        System.out.println(ts.b);
        // Some operation on int variabale
        int k = i+6;
        System.out.println(i);
        System.out.println(k);
        String s1= "10";
       Integer num = 10;
       String s2= num.toString();
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));


    }


}
