package test.java.CorePractice;

public class MainMethodOverLoading {

    public static void main(String[] args) {
        System.out.println("Main method with String Arguments");
    }

    public static void main(int [] args) {
        System.out.println("Over loaded Main method with INT argument");
    }
}
