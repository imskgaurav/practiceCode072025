package test.java.arrayDSA;

public class ArraySumWithoutForLoop {
    public static void main(String[] args) {
    }
    public static int sumArray(int arr[], int n){
        if(n<0){return  0;
        }
        return sumArray(arr, n-1)+arr[n-1];
    }

}
