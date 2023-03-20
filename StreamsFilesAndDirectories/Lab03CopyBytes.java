package StreamsFilesAndDirectories;


import java.io.*;

public class Lab03CopyBytes {
    public static void main(String[] args) {
        String inputPath = "D:\\Documents\\SoftUniJavaAdvanced\\Лекции, упражнения, лабове\\04.Files-and-Streams\\input.txt";
        String outputPath = "D:\\Documents\\SoftUniJavaAdvanced\\Лекции, упражнения, лабове\\04.Files-and-Streams\\03.CopyBytesOutput.txt";

        int oneByte = 0;

        try(InputStream in = new FileInputStream(inputPath);
            OutputStream out = new FileOutputStream(outputPath)){
            while ((oneByte = in.read()) >= 0){
                if(oneByte == 10 || oneByte == 32){
                    out.write(oneByte);
                }else {
                    String digits = String.valueOf(oneByte);
                    for(int i = 0; i < digits.length(); i++){
                        out.write(digits.charAt(i));
                    }
                }
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
