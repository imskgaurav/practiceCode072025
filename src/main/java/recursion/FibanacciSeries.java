package main.java.recursion;

public class FibanacciSeries {
    public static void main(String[] args) {
       //int x=fibonacciSeries(7);
        //System.out.println("Result is "+x);
        for (int i=1; i<=7; i++){
            System.out.print(fibonacciSeries(i)+"  ");
        }

    }

    static int fibonacciSeries(int num) {
        if ((num == 0) || (num == 1))
            return num;
        return fibonacciSeries(num - 1) + fibonacciSeries(num - 2);
    }
}