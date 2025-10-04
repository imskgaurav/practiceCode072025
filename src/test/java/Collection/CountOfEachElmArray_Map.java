package test.java.Collection;

import java.util.HashMap;
import java.util.Map;

public class CountOfEachElmArray_Map {


    public static  void countFreq(int [] arr){

        Map<Integer, Integer> map1= new HashMap<>();
        for(int i =0; i<arr.length; i++){
            System.out.println("Iterating Element in Array");
            //Create a HashMap, To Put key value pair:value :count//

            if(map1.containsKey(arr[i])){
                map1.put(arr[i], map1.get(arr[i])+1);
            }
            else{
                map1.put(arr[i], 1);
            }

        }
        //Iterate Map

     for( Map.Entry<Integer, Integer> entry : map1.entrySet()){
         System.out.println("Count of Int"+entry.getKey() +"is :"+entry.getValue());

     }

    }

    public static void main(String[] args) {

        int [] arr =  {1, 2, 2, 3, 1, 1, 2};
        countFreq(arr);
    }
}
