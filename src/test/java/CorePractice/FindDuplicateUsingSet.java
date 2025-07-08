package test.java.CorePractice;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicateUsingSet {
    public static void main(String[] args) {
        String arr [] =	new String[] {"Tom","Megan", "Melissa", "Tom", "John", "Megan", "Melissa"};

         Set<String> set = new HashSet<>();
        for (int i =0; i<arr.length; i++){

            if(!set.add(arr[i])){
                System.out.println("Duplicate Element is :"+arr[i]);
            }


        }

    }
}
