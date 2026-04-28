package test.java.arrayDSA;

import java.util.*;

//https://leetcode.com/problems/contains-duplicate/
public class LeetCode217 {

    public static void main(String[] args) {
        int []nums = {1,2,3,7,9,3,2};
       boolean val= containsDuplicate(nums);
        System.out.println("res is >> :"+val);
    }

    static  boolean containsDuplicate(int[] nums){
         Set<Integer>  set = new HashSet<>();
         for(int i=0;i< nums.length; i++){
             set.add(nums[i]);
         }
        System.out.println("set size is :"+set.size());
        System.out.println("duplicate count is: :"+ (nums.length-set.size()));
          return  set.size() <nums.length;
    }
}
