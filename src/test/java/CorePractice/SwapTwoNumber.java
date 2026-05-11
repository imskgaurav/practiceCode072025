package test.java.CorePractice;

public class SwapTwoNumber {

    public static void swapTwoNumber(int a, int b) {
        System.out.println("Before swapping: a = " + a + ", b = " + b);
         int temp;
         temp= a;
         a=b;
         b=temp;
        System.out.println("After swapping: a = " + a + ", b = " + b);
    }

    public static void sumAllArrayElements(int[] arr) {
        int sum = 0;
        for(int x: arr){
            sum = sum+x;
        }
        System.out.println("Sum of all array elements: " + sum);
    }
    public static void main(String[] args) {

        swapTwoNumber(99,2);

    }
}
