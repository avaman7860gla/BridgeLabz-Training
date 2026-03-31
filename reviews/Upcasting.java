class Parent {
    static void show() {
        System.out.println("Parent static show");
    }
}

class Child extends Parent {
    static void show() {
        System.out.println("Child static show");
    }
}


public class Upcasting {
    public static void main(String[] args) {
      
        // Parent.show();  
        // Child.show();   

        Parent p = new Child();  
        p.show();                

        // Child c = new Child();
        // c.show();                
    }
}
