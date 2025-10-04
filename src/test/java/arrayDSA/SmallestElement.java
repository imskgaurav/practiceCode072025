package test.java.arrayDSA;

public class SmallestElement {

    public static void main(String[] args) {
        int nums[] = {20, 90, 2,77, 3};
     int res=   findSmallestNumber(nums);
        System.out.println(res);
    }

    static  int findSmallestNumber(int arr[]){
        int minVal=Integer.MAX_VALUE;
        //int minVal = arr[0];
        for (int i=0; i<arr.length; i++){
            if(minVal>arr[i]){
                minVal=arr[i];
            }

        }

        return minVal;
    }
}
