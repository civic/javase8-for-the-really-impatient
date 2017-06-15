package chapter1;

import java.util.Arrays;
import java.util.Comparator;

public class Q1 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        Arrays.sort(new Integer[]{5, 3, 4, 2, 4}, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(Thread.currentThread().getName());

                return o2 - o1;
            }
        });
    }
}
