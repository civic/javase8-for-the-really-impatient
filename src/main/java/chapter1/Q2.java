package chapter1;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q2 {
    public static void main(String[] args) {

        for (File d: listAllSubDirectory(".")){
            System.out.println(d);
        }


    }

    public static List<File> listAllSubDirectory(String path){
        List<File> directories = new ArrayList<>();

        List<File> subDirs = Arrays.asList(new File(path).listFiles(f -> f.isDirectory()));
        subDirs.stream().sorted().forEach((d) -> {
            directories.add(d);
            directories.addAll(listAllSubDirectory(d.getPath()));
        });

        return directories;
    }
    public static List<File> listAllSubDirectory2(String path){
        List<File> directories = new ArrayList<>();

        List<File> subDirs = Arrays.asList(new File(path).listFiles(File::isDirectory));
        subDirs.stream().sorted().forEach((d) -> {
            directories.add(d);
            directories.addAll(listAllSubDirectory2(d.getPath()));
        });

        return directories;
    }
}
