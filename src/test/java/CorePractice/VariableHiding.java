package test.java.CorePractice;

public class VariableHiding {
    public static void main(String[] args) {
       B obj1= new B();
        obj1.m1();
        obj1.m2();
    }
}
class A{
    int x =10;
     void m1(){
         System.out.println("class A ;"+x);
     }
}

class B extends  A{
 int x =22;
 void m2(){
     System.out.println("Class B:"+x);
 }


}
