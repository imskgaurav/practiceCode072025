package test.java.stringProgram;

public class FindCommonCharFrom3String {
    //https://www.youtube.com/shorts/GDw-PpcIWuE
    public static void main(String[] args) {

        String s1 = "abcde";
        String s2 = "bchkj";
        String s3= "yuibc";
      commonCharinStrings(s1,s2,s3);


    }

    static void commonCharinStrings(String s1, String s2,String s3){
        StringBuilder sb = new StringBuilder("");
        for(char c: s1.toCharArray()){
             if(!(s2.indexOf(c)==-1)&&!(s3.indexOf(c)==-1)){
                 System.out.println("Common Char :"+c);
                 sb.append(c);
             }
             else{
                 System.out.println("Condition not met :"+c);

             }

        }
        System.out.println("Common Char String:"+sb);
    }
}
