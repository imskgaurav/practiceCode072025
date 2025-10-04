package test.java.BubbleSort;

import java.util.Arrays;

public class BubbleSortExample {
    //https://www.youtube.com/watch?v=p__ETf2CKY4
    public static void main(String[] args) {
       // int[] arr = {5, 2, 8, 7, 1};
        int[] arr = { 8, 4, 1};
        int len = arr.length;
        for(int i=0; i<len-1; i++){
            System.out.println("Starting the Iteration>>:" +i);
        for (int j=0; j<len-1-i;j++)   {
               if(arr[j] >arr[j+1]){
                   System.out.println("Condition is True :Do swapping:"+j);
                   int temp =arr[j];
                   arr[j]= arr[j+1];
                   arr[j+1]= temp;
               }
            System.out.println("Iteration is completed :"+i);

        }


        }
        System.out.println("Bubble sort is Done :"+ Arrays.toString(arr));
        System.out.printf("largest element is"+arr[len-1]);
    }
}
