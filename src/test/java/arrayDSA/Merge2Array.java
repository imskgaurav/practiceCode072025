package test.java.arrayDSA;

import java.util.Arrays;

public class Merge2Array {

    public static void main(String[] args) {
        // The two original arrays
        int[] array1 = {1, 2, 3};
        int[] array2 = {4, 5, 6};
        int [] mergeArray = new int[array1.length+array2.length];
        for(int i=0; i<array1.length; i++){
                mergeArray[i] = array1[i];
            }
        //copy ARRAY 2
        for(int j =0; j<array2.length;j++){

            mergeArray[array1.length+j]= array2[j];
        }
       Arrays.stream(mergeArray).forEach(System.out::println);

    }
}
