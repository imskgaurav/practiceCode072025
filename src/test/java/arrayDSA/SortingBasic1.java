package test.java.arrayDSA;

import java.util.Arrays;
import java.util.Random;

public class SortingBasic1 {
    public static void main(String[] args) {

        Random rand = new Random();
        int a[] = new int[10];
        for(int i=0;i<a.length;i++){
            a[i]= rand.nextInt(50);
        }
        System.out.println(a.length);
        System.out.println(Arrays.toString(a));
    }
}
