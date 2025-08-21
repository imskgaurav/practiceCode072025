package test.java.CorePractice;


class Parent {
    static void display() {
        System.out.println("Parent static method");
    }
}

class Child extends Parent {
    static void display() { // Method hiding
        System.out.println("Child static method");
    }
}

public class MethodHiding {
    public static void main(String[] args) {
        Parent obj1 = new Child();
        Child obj2 = new Child();

        obj1.display(); // Parent static method
        obj2.display(); // Child static method
    }
}
