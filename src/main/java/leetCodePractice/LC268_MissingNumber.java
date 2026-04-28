package main.java.leetCodePractice;

public class LC268_MissingNumber {
    public static void main(String[] args) {
        int []arr = {3,0,1};
        missingNumber(arr);


    }
    static void missingNumber(int nums []){
      for(int i=0; i<nums.length; i++){
          for(int j=0; j<nums.length-1; j++){
            if(i==nums[j]){
                System.out.println("Number found ");
            }
            else{
                System.out.println("Missing is"+i);

          }
          }
      }

    }
}

