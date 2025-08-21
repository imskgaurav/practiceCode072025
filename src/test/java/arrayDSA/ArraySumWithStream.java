package test.java.arrayDSA;

import java.util.Arrays;

public class ArraySumWithStream {

    public static void main(String[] args) {
        int [] arr = {9, 8, 55};
       int sum= Arrays.stream(arr).sum();
        System.out.println(sum );
    }
}
