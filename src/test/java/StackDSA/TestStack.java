package test.java.StackDSA;

import java.sql.SQLOutput;
import java.util.Stack;
import java.util.logging.SocketHandler;

public class TestStack {
    public static void main(String[] args) {
        Stack <Integer>stack = new Stack<>();
        System.out.println("empty:::>"+stack.isEmpty());
        stack.push(89);
        stack.push(9);
        stack.push(80);
        System.out.println(stack.peek());
        System.out.println(stack.search(-9));


        // Pop Operation For Stack
        while(!stack.isEmpty()){
            int x= stack.pop();
            System.out.println("Pop Element is :"+x);
        }


    }
}
