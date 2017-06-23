package chapter1;

import java.io.File;
import java.util.Arrays;

public class Q3 {
    public static void main(String[] args) {

        Arrays.stream(listFiles(".", "gradle")).forEach(System.out::println);

    }

    public static String[] listFiles(String path, String ext){
        //ext is captured
        return new File(path).list((dir, name) -> new File(dir, name).isFile() && name.endsWith("."+ext));
    }
}
