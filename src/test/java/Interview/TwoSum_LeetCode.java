package test.java.Interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum_LeetCode {
    // nums = [2,7,11,15], target = 9
    public static void main(String[] args) {
        int[] nums = {2, 11, 15, 7};
       // int[] index = findIndex(nums, 9);
        int[] index = findIndexUsingHashMap(nums, 9);
        if (index.length>1) {
            System.out.println("Indexes ARE :" + Arrays.toString(index));
        }
        else{
            System.out.println("Condition Not met");
        }
    }

    //BruteForce
    public static int[] findIndex(int arr[], int target) {
          int [] res= new int[2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                  if(arr[i]+arr[j]==target){
                      /*System.out.println("Index is "+i);
                      System.out.println(" 2nd Index is "+j);*/
                      res[0]=i;
                      res[1]=j;
                  }

            }
        }
     return  res;
    }

    static int [] findIndexUsingHashMap(int [] arr, int target){
      int [] res = new int[2];
       //Create Map and Put the Array value as key and Index as Value
        Map<Integer, Integer> map1= new HashMap<>();
        for(int i=0; i<arr.length; i++){
           map1.put(arr[i], i);
           }
        System.out.println("map is ready");
        System.out.println(""+map1.size());

        for(int i =0; i<arr.length; i++){
           int x= target-arr[i];
            System.out.println(x);
            if(map1.containsKey(x))
            {
                System.out.println("condition check");
               int index =  map1.get(target-arr[i]);
                System.out.println(index);
                res[0]= i;
                res[1]= index;
                return res;
            }

        }

return res;
    }

   //
}