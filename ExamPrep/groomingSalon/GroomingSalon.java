package ExamPrep.groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    public List<Pet> data;
    public int capacity;

    public GroomingSalon(int capacity){
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public int getCapacity() {
        return capacity;
    }

    public void add(Pet pet){
        if(data.size() < this.capacity){
            data.add(pet);
        }
    }

    public boolean remove(String name){
        for (Pet pet : data) {
            if(pet.getName().equals(name)){
                data.remove(pet);
                return true;
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner){
        for (Pet pet : data) {
            if(pet.getName().equals(name) && pet.getOwner().equals(owner)){
                return pet;
            }
        }
        return null;
    }

    public int getCount(){
        return data.size();
    }

    public String getStatistics(){
        StringBuilder builder = new StringBuilder();
        builder.append("The grooming salon has the following clients:").append(System.lineSeparator());
        for (Pet pet : data) {
            String dataPet = String.format("%s %s", pet.getName(), pet.getOwner());
            builder.append(dataPet).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
