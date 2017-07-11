package chapter2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Q3 {
    
    public static void main(String[] args) throws IOException {
        
        String contens = new String(Files.readAllBytes(Paths.get("war-and-peace.txt")), StandardCharsets.UTF_8);
        List<String> words =Arrays.asList(contens.split("[\\P{L}]+"));
        long start1 = System.nanoTime();
        long count1 = words.stream().filter(s->s.length() > 12).count();
        long time1 = (System.nanoTime() - start1);


        long start2 = System.nanoTime();
        long count2 = words.parallelStream().filter(s->s.length() > 12).count();
        long time2  = (System.nanoTime() - start2);
        System.out.printf("              stream(): time=%9d\n", time1);
        System.out.printf("parallelStreamstream(): time=%9d\n", time2);
    }

}
