package test.java.TwoPointer;

public class ReverseString {

    public static void main(String[] args) {
        String s = "hello";
       String rev= reverseString(s);
        System.out.println( "Reversed String is : " + rev);

    }


     static String reverseString(String s) {
         char ch[] = s.toCharArray();
         int left = 0;
         int right = ch.length-1;
         char temp;
         while(left<right){
            temp =ch[left];
            ch[left] = ch[right];
            ch[right] =  temp;
            left++;
            right--;
         }
      return new String(ch);
     }
}
