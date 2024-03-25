abstract class High{
    double a=10.45;
   abstract void call();
   void callMe(){
        System.out.println("High");
    }
}
class A extends High{
    int a=10;
    void call(){
        //super.callMe();
        System.out.println("A");
    }
}
class B extends A{
    String a=" Hello";
void callMe(){
    super.callMe();
    System.out.println("B");

}
}
public class Main {
    public static void main(String[] args) {
        B b=new B();
        High high= new High() {
            @Override
            void call() {
                System.out.println("Abcd");
            }
        };
//        b.callMe();
//        System.out.println(b.a);
//        b.call();
        high.call();
        System.out.println(high.a);
    }
}