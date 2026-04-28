package main.java.leetCodePractice;

public class LC09_PalindromeNumber {

    public static void main(String[] args) {
        System.out.println("Numbee is PalinDrome:"+isPalindrome(12347321));

    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x > 0) {
            String str = Integer.toString(x);
            char ch[] = str.toCharArray();
            int left = 0;
            int right = str.length() - 1;
            for (char c : ch) {
                while (left < right) {
                    if (ch[left] != ch[right]) {
                        return false;
                    }
                    left++;
                    right--;

                }

            }

        }


        return true;
    }
}
