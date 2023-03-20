package StreamsFilesAndDirectories;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lab02WriteToFile {
    public static void main(String[] args) {
        String inputPath = "D:\\Documents\\SoftUniJavaAdvanced\\Лекции, упражнения, лабове\\04.Files-and-Streams\\input.txt";
        String outputPath = "D:\\Documents\\SoftUniJavaAdvanced\\Лекции, упражнения, лабове\\04.Files-and-Streams\\02.WriteToFileOutput.txt";

        List<Character> symbols = new ArrayList<>();
        Collections.addAll(symbols, '.', ',', '!', '?');

        try(InputStream in = new FileInputStream(inputPath);
            OutputStream out = new FileOutputStream(outputPath))
        {
            int oneByte = 0;
            while ((oneByte = in.read()) >= 0){
                if(!symbols.contains((char)oneByte)){
                    out.write(oneByte);
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
