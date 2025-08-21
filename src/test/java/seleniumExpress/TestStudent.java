package test.java.seleniumExpress;

import java.sql.SQLOutput;

public class TestStudent {
    public static void main(String[] args) {

        Student s1= new Student(1, "ABHI");
        Student s2= new Student(1, "ABHI");
        System.out.println(s1);
        System.out.println(s1.getName());
        System.out.println("Compare 2 Student:"+s1.equals(s2));
        System.out.println(s1==s2);

    }
}
