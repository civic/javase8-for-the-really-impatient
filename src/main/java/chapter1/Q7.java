package chapter1;

public class Q7 {
    public static void main(String[] args) {
        
        andThen(
                ()->System.out.println("Hello"), 
                ()->System.out.println("World")
        ).run();
    }
    public static Runnable andThen(Runnable a, Runnable b){
        return () -> {
            a.run(); 
            b.run();
        };
    }
}
