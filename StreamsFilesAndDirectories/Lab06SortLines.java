package StreamsFilesAndDirectories;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lab06SortLines {
    public static void main(String[] args) {
        String inputPath = "D:\\Documents\\SoftUniJavaAdvanced\\Лекции, упражнения, лабове\\04.Files-and-Streams\\input.txt";
        String outputPath = "D:\\Documents\\SoftUniJavaAdvanced\\Лекции, упражнения, лабове\\04.Files-and-Streams\\06.SortLinesOutput.txt";

        Path input = Paths.get(inputPath);
        Path output = Paths.get(outputPath);

        try {
            List<String> lines = Files.readAllLines(input);
            lines = lines.stream().filter(l -> !l.isBlank()).collect(Collectors.toList());
            Collections.sort(lines);
            Files.write(output, lines);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
