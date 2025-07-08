package main.java.pageEvnts;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TestJava {

    public static void main(String[] args) {

        String name = "shashikant";

        Map<Character, Integer> map1 = new HashMap<>();

           for(char c : name.toCharArray()){
               if(map1.containsKey(c)) {
                   map1.put(c,map1.get(c)+1 );
               }
               else{
                   map1.put(c,1);

               }
           }


           Iterator<Character> it= map1.keySet().iterator();

           while(it.hasNext()){
             char c= it.next();
               //System.out.println(c);
               if(c=='s'){

                 int  count=  map1.get(c);
                   System.out.println(count);
               }
           }

    }
}
