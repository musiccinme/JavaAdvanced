package StreamsFilesAndDirectories;

import java.io.*;
import java.util.Scanner;

public class Lab04ExtractIntegers {
    public static void main(String[] args) throws IOException {
        String inputPath = "D:\\Documents\\SoftUniJavaAdvanced\\Лекции, упражнения, лабове\\04.Files-and-Streams\\input.txt";
        String outputPath = "D:\\Documents\\SoftUniJavaAdvanced\\Лекции, упражнения, лабове\\04.Files-and-Streams\\04.ExtractIntegersOutput.txt";

        Scanner reader = new Scanner(new FileInputStream(inputPath));

        PrintWriter writer = new PrintWriter(new FileOutputStream(outputPath));

        while (reader.hasNext()){
            if(reader.hasNextInt()){
                writer.println(reader.nextInt());
            }
            reader.next();
        }
        writer.close();
    }
}
