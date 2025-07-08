package test.java.CorePractice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class CountOfOccurrencesOfEachChar_usingHashMap {

    public static void main(String[] args) {
        String input = "Programming";
        Map<Character, Integer> map1 = new HashMap<>();
        char[] ch = input.toCharArray();

        for (char c : ch) {
            if (map1.containsKey(c)) {
                map1.put(c, map1.get(c) + 1);
            } else {
                map1.put(c, 1);
            }
        }
        System.out.println(map1);
        // Iterate using Entry Set //

        for( Map.Entry<Character, Integer> c  : map1.entrySet()){
            System.out.println("Key is :"+c.getKey());
            System.out.println("value is :"+c.getValue());
            if(c.getValue()>=2){
                System.out.println("Duplicate char is Found:"+c.getKey());
            }
        }
  // Iterate using KeySet
        Set keys =map1.keySet();
        Iterator<Character> it = keys.iterator();
        System.out.println("Using KeySet and Iterator");
        while(it.hasNext()){
            char c= it.next();
            System.out.println("key is :"+c);
            System.out.println("Value is:" +map1.get(c));

        }


    }
}