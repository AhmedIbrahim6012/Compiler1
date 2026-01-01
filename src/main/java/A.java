public class A {
    class  A1 extends A{
    }
    class A2 extends A1{
    }
    class A3 extends  A2{
    }
    A p(){
        A c = new A3();
        return c;
    }
    void print(){
        System.out.println(p() instanceof A3);
    }
}
