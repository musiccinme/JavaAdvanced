package StreamsFilesAndDirectories;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Deque;

public class Lab08NestedFolders {
    public static void main(String[] args) {
        String rootPath = "D:\\Documents\\SoftUniJavaAdvanced\\Лекции, упражнения, лабове\\" +
                "04.Files-and-Streams\\Files-and-Streams";

        File root = new File(rootPath);

        Deque<File> dirs = new ArrayDeque<>();
        dirs.offer(root);
        int count = 0;

        while (!dirs.isEmpty()) {
            File current = dirs.poll();
            File[] nestedFiles = current.listFiles();
            //assert nestedFiles != null;
            for (File file : nestedFiles) {
                if (file.isDirectory()) {
                    dirs.offer(file);
                }
            }
            count++;
            System.out.println(current.getName());
        }
        System.out.println(count + " folders");
    }
}
