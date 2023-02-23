package model;

public class NonleggedAnimal extends Animal{
    private String characteristic;

    public NonleggedAnimal() {
    }

    public NonleggedAnimal(Integer id, String name, Double weight, Integer legNumber, String color, String characteristic) {
        super(id, name, weight, legNumber, color);
        this.characteristic = characteristic;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }


    @Override
    public void showInfo() {
        System.out.println("ID: " + this.getId());
        System.out.println("Name: " + this.getName());
        System.out.println("Weight: " + this.getWeight()+"kg");
        System.out.println("Legs: " + this.getLegs());
        System.out.println("Color: " + this.getColor());
        System.out.println("Characteristic: " + this.getCharacteristic());
        System.out.println("----------------------");
    }
    
    @Override
    public String toString() {
        return super.toString() + characteristic+ "\n";
    }
    

}
