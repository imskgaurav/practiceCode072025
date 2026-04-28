package test.java.TwoPointer;

public class FindPairSum_SortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 6, 8, 10};
        int target = 10;
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                System.out.println("Pair found: " + arr[left] + ", " + arr[right]);
                return;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println("No pair found.");
    }
}
