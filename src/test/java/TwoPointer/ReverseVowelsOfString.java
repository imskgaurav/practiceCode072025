package test.java.TwoPointer;
 //https://leetcode.com/problems/reverse-vowels-of-a-string/description/
public class ReverseVowelsOfString {

     public static void main(String[] args) {
            String s = "IceCreAm";
            ReverseVowelsOfString obj = new ReverseVowelsOfString();
            String rev= obj.reverseVowels(s);
            System.out.println( "Reversed Vowels String is : " + rev);
     }

     public String reverseVowels(String s) {
         String vowels= "aeiouAEIOU";
         char [] ch = s.toCharArray();
         int left =0;
         int right = ch.length-1;
         char temp;
         while(left<right){
             if((vowels.indexOf(ch[left])!=-1) && (vowels.indexOf(ch[right])!=-1)){
                 System.out.println("left vowel: " + ch[left] + " right vowel: " + ch[right]);
                 temp = ch[left];
                 ch[left] = ch[right];
                 ch[right] = temp;
             }
             left++;
             right--;

         }

         return new String(ch);
     }
 }

