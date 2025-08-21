package test.java.arrayDSA;

import java.util.Arrays;
public class FindingSubArrayWithSumEquals2IntegerK {
    //arr = [1, 12, 20, 3, 10, 5]  AND sum K = 33
    //Brute Force Approach
    public static int [] findSubArraySumEqualsK(int [] arr, int k){
     int len = arr.length;
     for(int start= 0; start<len; start++) {
          int sum =0;
         for(int end = start; end<len; end++){
              int val = arr[end];
              sum= sum+val;
              while(sum==k){
            System.out.println("Condition met");
             System.out.println("Start Index is :"+ start);
                  System.out.println("End Index is :"+ end);
              return Arrays.copyOfRange(arr, start, end+1);
              }
         }


     }

   return null;
    }

    public static void main(String[] args) {
        int [] arr ={1, 12, 20, 3, 10, 5};
        int result[]=findSubArraySumEqualsK(arr, 33);
        System.out.println(Arrays.toString(result));
    }

}
