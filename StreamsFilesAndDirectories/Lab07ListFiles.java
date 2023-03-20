package StreamsFilesAndDirectories;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Lab07ListFiles {
    public static void main(String[] args) {

        File file = new File("D:\\Documents\\SoftUniJavaAdvanced\\" +
                "Лекции, упражнения, лабове\\04.Files-and-Streams\\Files-and-Streams");

        if(file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File file1 : files) {
                    if (!file1.isDirectory())
                        System.out.printf("%s: [%s]%n", file1.getName(), file1.length());
                }
            }
        }

    }
}
