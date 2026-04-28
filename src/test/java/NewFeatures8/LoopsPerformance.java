package test.java.NewFeatures8;
//https://www.youtube.com/watch?v=qe5zyOElzsU&t=439s
import java.util.ArrayList;
import java.util.List;

public class LoopsPerformance {

public static List<Integer> numbers= new ArrayList<>();
 static {
     for (int i=0; i<=50000; i++){
         numbers.add(i);
     }
 }

    public static void main(String[] args) {
      long startTime= System.currentTimeMillis();
        long resultSum =  forLoopsSum();
        System.out.println("Sum is "+ resultSum);
        long endTime =System.currentTimeMillis();
        System.out.println("Time Taken is :"+ (endTime-startTime)+"ms");
    }

    //for Loops

    public static int forLoopsSum(){
        int sum =0 ;
        for (int x : numbers){
           sum+=x;
        }

    return sum;
    }


}
