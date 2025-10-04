package test.java.stringProgram;

public class FindDuplicateCharFromString_NoMap {

    public static void main(String[] args) {
        String str1= "online academic";
      StringBuilder sb = new StringBuilder(str1);
      for(int i=0; i< str1.length(); i++){
            char c = str1.charAt(i);
          if(sb.indexOf(String.valueOf(c))==-1){
              sb.append(c);
          }
          else{
              System.out.println("Duplicate Char is :"+c);
          }

      }
        System.out.println("No Duplicate Char is :"+sb);

    }
}
