package chapter1;

import java.util.ArrayList;
import java.util.List;

public class Q8 {
    public static void main(String[] args) {
        String[] names = {"Peter", "Paul", "Mary"};

        List<Runnable> runners = new ArrayList<>();
        for (String name: names){
            runners.add(() -> System.out.println(name));
        }

        runners.stream().forEach(Runnable::run);
        
        List<Runnable> runners2 = new ArrayList<>();
        for (int i = 0 ; i < names.length; i++){
            int captured_i = i;
            runners2.add(() -> System.out.println(names[captured_i]));
        }
        runners2.stream().forEach(Runnable::run);
    }
}
