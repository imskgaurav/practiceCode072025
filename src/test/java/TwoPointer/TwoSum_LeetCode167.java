package test.java.TwoPointer;

import io.reactivex.rxjava3.core.SingleOnSubscribe;

import java.util.Arrays;

// InPUT Array is sorted in non-decreasing order,
// find two numbers such that they add up to a specific target number
public class TwoSum_LeetCode167 {

    public static void main(String[] args) {
        int [] numbers = {2,7,11,15};
   // Find Target 9//
        System.out.println(Arrays.toString( twoSum(numbers, 20)));
    }

    static int [] twoSum(int num[],int target ) {
        int left = 0;
        int right = num.length - 1;
        while (left<right) {
            if (num[left] + num[right] == target) {
                return new int[]{left, right};
            }
            if (num[left] + num[right] > target) {
                right--;
            }
            if (num[left] + num[right] < target) {
                left++;
            }



        }
        return new int[]{-1, -1};
    }

}
