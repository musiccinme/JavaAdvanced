package ExamPrep.groomingSalon;

public class Pet {
    private String name;
    private int age;
    private  String owner;

    public Pet(String name, int age, String owner){
        this.setName(name);
        this.setAge(age);
        this.setOwner(owner);
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return this.age;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    public String getOwner() {
        return this.owner;
    }

    @Override
    public String toString(){
        return String.format("%s %d - (%s)", this.getName(), this.getAge(), this.getOwner());
    }
    public String petInfo(){
        return toString();
    }
}
