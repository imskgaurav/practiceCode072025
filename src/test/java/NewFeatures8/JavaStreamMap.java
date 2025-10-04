package test.java.NewFeatures8;


import  java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStreamMap {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("rahul", "rakesh");
        list.stream().map(String::length).forEach(System.out::println);

        //Convert a List of String to Uppercase

        List<String> names = Arrays.asList("alice", "bob", "charlie");
        //printing the name
        names.stream().map(String::toUpperCase).forEach(System.out::println);
        //Change to a new List with Uppercase

        List<String> uppernames= names.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("List with UpperCase:"+uppernames);

    }
}
