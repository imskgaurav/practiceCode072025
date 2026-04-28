package main.java.leetCodePractice;

import java.util.*;


//https://leetcode.com/problems/contains-duplicate/description/
public class LC127_ContainsDuplicate {

    public static void main(String[] args) {

        int arr []= {1,2,3,6};
        System.out.println("Contains Duplicate:"+ containsDuplicate(arr));

    }
    static boolean containsDuplicate(int [] nums){
        Set<Integer> set1 = new HashSet<>();
        for(int var : nums){
            set1.add(var);
        }
        if(set1.size()< nums.length){
          return  true;
        }
        else{
            return false;
        }


    }
}
