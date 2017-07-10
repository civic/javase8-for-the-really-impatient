package chapter2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Q1 {
    public static void main(String[] args) throws IOException, InterruptedException {
        String contens = new String(Files.readAllBytes(Paths.get("alice.txt")), StandardCharsets.UTF_8);
        List<String> words =Arrays.asList(contens.split("[\\P{L}]+"));

        System.out.println(countsSingleThread(words));
        System.out.println(countsMultiThread(words));
        /*
        各スレッドで単一のカウンターを共有すると、競合が起きないように
        カウンターをスレッドセーフに更新する必要があり、カウンターのインクリメントが
        並行に実行できなくなるため。
        */


    }

    public static int countsSingleThread(List<String>words){
        

        int count = 0;
        for (String w : words) {
            if (w.length() >12) {
                count++;
            }
        }
        return count;
    }

    public static int countsMultiThread(List<String>words) throws InterruptedException{
        int segments = Math.min(100, words.size());

        Thread[] threads = new Thread[segments];
        int[] counter = new int[segments];
        int segmentSize =  words.size() / segments;

        for (int i = 0; i < threads.length; i++){
            int s = segmentSize * i;
            int e = i < threads.length -1 ? segmentSize * (i + 1) : words.size();
            int index = i;

            threads[i] = new Thread(()->{
                int count = 0;
                for (String w : words.subList(s, e)) {
                    if (w.length() >12) {
                        count++;
                    }
                }
                counter[index] = count;
            });
            threads[i].start();
        }
        int totalCount = 0;
        for (int i = 0; i < threads.length; i++){
            threads[i].join();
            totalCount += counter[i];
        }

        return totalCount;
    }
}
