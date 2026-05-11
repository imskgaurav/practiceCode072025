package test.java.arrayDSA;

public class SortingAscOrder1 {

    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 1, 3};

        // Sort the array in ascending order
        for (int i = 0; i < arr.length - 1; i++) {
           for(int j=i+1;j<arr.length;j++){
               if(arr[i]>arr[j]){
                   int temp;
                   temp= arr[i];
                   arr[i]=arr[j];
                   arr[j]=temp;

               }
           }
        }

        // Print the sorted array
        System.out.println("Sorted array in ascending order:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
