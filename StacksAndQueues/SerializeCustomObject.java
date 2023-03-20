package StacksAndQueues;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeCustomObject {
    static class Cube implements Serializable{
        String color;
        double height;
        double width;
        double depth;
    }

    public static void main(String[] args) {
        Cube cube = new Cube();
        cube.color = "green";
        cube.width = 15.3d;
        cube.height = 12.4d;
        cube.depth = 3d;

        String path = "D:\\Documents\\SoftUniJavaAdvanced\\Лекции, упражнения, лабове" +
                "\\04.Files-and-Streams\\save.txt";

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))){
            oos.writeObject(cube);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
