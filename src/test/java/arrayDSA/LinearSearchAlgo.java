package test.java.arrayDSA;

public class LinearSearchAlgo {

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        int index=  linearSearchAlgo(numbers, 40);
        if(index>0){
            System.out.println("Element is found at Index :"+index);
        }


    }

    static int  linearSearchAlgo(int arr[], int target){
        for(int x=0; x<arr.length; x++){
            if(target==arr[x]){

             return x;
            }


        }
     return -1;
    }
}
