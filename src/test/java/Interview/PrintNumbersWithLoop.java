package test.java.Interview;

public class PrintNumbersWithLoop {
    public static void main(String[] args) {
        print(1);
    }
    // Using Recursion method with paramete
    static void print(int n){
        if(n<=5){
            System.out.println(n);
            n++;
            print(n);
        }
    }


}
