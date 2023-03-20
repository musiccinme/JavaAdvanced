package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.IOException;

public class Lab01ReadFile {
    public static void main(String[] args) {
        String path = "D:\\Documents\\SoftUniJavaAdvanced\\Лекции, упражнения, лабове\\04.Files-and-Streams\\input.txt";


        try(FileInputStream fileStream = new FileInputStream(path)){
            int oneBite = fileStream.read();
            while (oneBite >= 0){
                System.out.printf("%s ", Integer.toBinaryString(oneBite));
                oneBite = fileStream.read();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
