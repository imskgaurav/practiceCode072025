package main.java.recursion;
public class ReverseString {
    static void reverseString(String s, int i) {
        if (i < 0) {
            return;
        }
        reverseString(s, i - 1);
        System.out.print(s.charAt(i));
    }

    public static void main(String[] args) {
        reverseString("java", "java".length() - 1);
        System.out.println();
    }
}