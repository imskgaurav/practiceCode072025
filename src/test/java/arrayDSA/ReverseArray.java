package test.java.arrayDSA;

import java.util.Arrays;

public class ReverseArray {

    public static void main(String[] args) {

     int arr[] =  {1, 2, 3, 4, 5, 6, 7};
      int reverseArr[] =  reverseArray(arr, 0,6 );
        Arrays.stream(reverseArr).forEach(System.out::println);
    }
   public  static int [] reverseArray(int [] arr, int start, int end){
        while(start<end){
          // Step1:
            int temp = arr[start];
          // Step2 :
            arr[start] = arr[end];
          //Step 3:
            arr[end] = temp;
            start++;
            end--;

        }
   return arr;

    }


}
