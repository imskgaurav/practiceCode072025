package test.java.arrayDSA;

import java.util.Arrays;

public class SortingAscOrderWithCustomizedRange {
    public  static void SortAscCustomizedRange(int []a, int start, int end){
            for(int i=start;i<end-1;i++){
                for(int j=i+1;j<end;j++){
                    if(a[i]>a[j]){
                        int temp=a[i];
                        a[i]=a[j];
                        a[j]=temp;
                    }
                }
            }
    }

    public static void main(String[] args) {
       int arr [] = {99,8, 4, 9,3,5,1,100};
        SortAscCustomizedRange(arr,2,6);
        System.out.print("Sorted Array: ");
        System.out.println(Arrays.toString(arr));
    }
}
