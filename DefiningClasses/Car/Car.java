package DefiningClasses.Car;

import java.util.Objects;

public class Car {
    private String brand;
    private String model;
    private int horsePower;

    public Car(String brand, String model, int horsePower) {
        this.setBrand(brand);
        this.setModel(model);
        this.setHorsePower(horsePower);
    }

    public Car(String brand){
        this(brand, "unknown", -1);
    }


    public String getBrand(){
        return this.brand;
    }
    public void setBrand(String brand){
        this.brand = brand;
    }

    public String getModel(){
        return this.model;
    }
    public  void setModel(String model){
        this.model = model;
    }

    public  int getHorsePower(){
        return this.horsePower;
    }
    public void setHorsePower(int horsePower){
        this.horsePower = horsePower;
    }

    @Override
    public String toString(){
        return String.format("The car is: %s %s - %d HP.", this.getBrand(), this.getModel(), this.getHorsePower());
    }
    public String carInfo(){
        return toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return horsePower == car.horsePower &&
                Objects.equals(brand, car.brand) &&
                Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, horsePower);
    }

   /* @Override
    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        if(this == obj){
            return true;
        }
        if(obj instanceof Car){
            Car other = (Car)obj;
            return this.brand.equals(other.brand) &&
                   this.model.equals(other.model) &&
                    this.horsePower == other.horsePower;
        }
        return false;
    } */


}
