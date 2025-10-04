package test.java.arrayDSA;

import java.sql.SQLOutput;

public class FrequencyOfEachElm {
  //https://www.youtube.com/watch?v=TSq1rx4edXA
    public static void main(String[] args) {

        int [] arr =  {1, 2, 2, 3, 1, 4, 2};
        int n = arr.length;
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++){
           if(visited[i]== true){
               System.out.println(arr[i] + " : " + "is already visited");
                continue; // Skip if already visited
            }
           int count=1;
            for(int j=i+1; j<n; j++){
                if(arr[i] == arr[j] ){
                    visited[j] = true;
                     count ++;
                        }
                    }
                    System.out.println(arr[i] + " : " + count);
                }
            }
        }
