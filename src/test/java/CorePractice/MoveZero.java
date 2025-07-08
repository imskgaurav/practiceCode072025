package test.java.CorePractice;

import java.util.Arrays;

public class MoveZero {


    public static void main(String[] args) {

        int[] nums = {0, 1, 0, 3, 12};
        MoveAllZeroAtEndOfArray(nums);
        moveAllZeroAtBeginning(nums);
    }

    static void MoveAllZeroAtEndOfArray(int nums[]) {
        int nonZeroInd = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroInd] = nums[i];
                nonZeroInd++;
            }
        }
        System.out.print("After Putting all Noz Zero in same Order");
        System.out.print(Arrays.toString(nums));

        while (nonZeroInd < nums.length) {
            nums[nonZeroInd] = 0;
            nonZeroInd++;

        }
        System.out.println("All zero ath End ");
        System.out.println();
        System.out.print(Arrays.toString(nums));
    }

    static void moveAllZeroAtBeginning(int[] arr) {
        System.out.println("Logic for Zero At Begining");
       int count = arr.length-1;
       int size= arr.length-1;

       // Iterate e Arrays in Reverse direction//

        for(int i =size-1; i>=0; i--){

            if(arr[i]!=0) {
                arr[count]=arr[i];
                count--;
            }
        }

        while(count>=0){

            arr[count]= 0;
            count--;
        }



        System.out.print("After Moving All Zero At the  Beginning" + Arrays.toString(arr));
    }
}
