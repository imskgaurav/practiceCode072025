package main.java.pageEvnts;

public class TestJava2 {
    public static void main(String[] args) {
        String s1 = "shashi_134";
       String res= s1.substring(s1.indexOf("_")+1, s1.length());

        System.out.println(res);

        String res1 = "";

        char ch[]=s1.toCharArray();
          int i=0;
        for (char c : ch){
            i++;
            System.out.println(c);
            if( 97<c && c<125){

                res1 =res1 + c;
            }
        }

        System.out.println("Integer is :"+res1);
    }
}
