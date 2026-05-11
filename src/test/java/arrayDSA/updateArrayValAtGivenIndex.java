package test.java.arrayDSA;

import java.util.Arrays;

public class updateArrayValAtGivenIndex {

public static  void  updateArray(int a[] , int index, int newVal){
    if(index==a.length){
        System.out.print(Arrays.toString(a));
        return;
    }
    a[index] = newVal;
   System.out.println(a[index]);
    updateArray(a, index+1, newVal+1);
    // Work after recursive call => non-tail recursion
    //System.out.println("Backtracking index " + index + " value " + a[index]);
    a[index] = a[index] -2;
}
    public static void main(String[] args) {
        int a [] = new int[5];
        System.out.println(a);
        System.out.println(Arrays.toString(a));
        updateArray(a,0,11);
        System.out.println(Arrays.toString(a));

    }
}
