package chapter2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q2 {
    

    public static void main(String[] args) throws IOException {
        String contens = new String(Files.readAllBytes(Paths.get("alice.txt")), StandardCharsets.UTF_8);
        List<String> words =Arrays.asList(contens.split("[\\P{L}]+"));

        List<String> longWords = words.stream()
                .filter(s -> {
                    System.out.println(s);
                    return s.length() > 5;
                })
                .limit(5)
                .collect(Collectors.toList());

        System.out.println(longWords);
    }
}
