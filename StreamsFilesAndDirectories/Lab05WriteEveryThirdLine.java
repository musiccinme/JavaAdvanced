package StreamsFilesAndDirectories;

import java.io.*;

public class Lab05WriteEveryThirdLine {
    public static void main(String[] args) {
        String inputPath = "D:\\Documents\\SoftUniJavaAdvanced\\Лекции, упражнения, лабове\\04.Files-and-Streams\\input.txt";
        String outputPath = "D:\\Documents\\SoftUniJavaAdvanced\\Лекции, упражнения, лабове\\04.Files-and-Streams\\05.WriteEveryThirdLineOutput.txt";

        try(BufferedReader in = new BufferedReader(new FileReader(inputPath));
            PrintWriter out = new PrintWriter(new FileWriter(outputPath))) {
            int count = 1;
            String line = in.readLine();
            while (line != null){
                if (count % 3 == 0){
                    out.println(line);
                }
                count++;
                line = in.readLine();

        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
