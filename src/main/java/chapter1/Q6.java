package chapter1;

public class Q6 {
    public static void main(String[] args) {
        new Thread(uncheck(()->{
            System.out.println("Zzz");
            Thread.sleep(1000);
        })).start();
    }

    public static Runnable uncheck(UncheckRunnable s){
        return () ->{
            try {
                s.run();
            } catch (Exception e){
                throw new RuntimeException(e);
            }
        };
    }

    public interface UncheckRunnable{
        void run() throws Exception;

    };
}
