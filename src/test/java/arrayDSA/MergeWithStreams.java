package test.java.arrayDSA;

import net.bytebuddy.implementation.bytecode.collection.ArrayAccess;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeWithStreams {
    public static void main(String[] args) {
        int[] array1 = {10, 20, 30};
        int[] array2 = {40, 50};
        IntStream stm1= Arrays.stream(array1);
        IntStream stm2= Arrays.stream(array2);
        int mergeArr[] = IntStream.concat(stm1,stm2).toArray();
        System.out.println( Arrays.toString(mergeArr));
    }
}
