package chapter1;

import java.io.File;

public class Q2 {
    public static void main(String[] args) {

        for (File d: listSubDirectory2(".")){
            System.out.println(d);
        }


    }

    public static File[] listSubDirectory(String path){
        return new File(path).listFiles(f -> f.isDirectory());
    }
    public static File[] listSubDirectory2(String path){
        return new File(path).listFiles(File::isDirectory);
    }
}
