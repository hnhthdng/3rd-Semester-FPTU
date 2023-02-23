package model;

public class BipedalAndFlightlessAnimal extends Animal{
    private Integer wings;
    private String canFly;
    private String canMakeSound;


    public BipedalAndFlightlessAnimal() {
    }
    
    public BipedalAndFlightlessAnimal(Integer id, String name, Double weight, Integer legNumber, String color, Integer wings, String canFly, String canMakeSound) {
        super(id, name, weight, legNumber, color);
        this.wings = wings;
        this.canFly = canFly;
        this.canMakeSound = canMakeSound;
    }

    public Integer getWings() {
        return wings;
    }

    public void setWings(Integer wings) {
        this.wings = wings;
    }

    public String getCanFly() {
        return canFly;
    }

    public void setCanFly(String canFly) {
        this.canFly = canFly;
    }

    public String getCanMakeSound() {
        return canMakeSound;
    }

    public void setCanMakeSound(String canMakeSound) {
        this.canMakeSound = canMakeSound;
    }
    
    @Override
    public void showInfo() {
        System.out.println("ID: " + this.getId());
        System.out.println("Name: " + this.getName());
        System.out.println("Weight: " + this.getWeight() + "kg");
        System.out.println("Legs: " + this.getLegs());
        System.out.println("Color: " + this.getColor());
        System.out.println("Wings: " + this.getWings());
        System.out.println("Can Fly: " + this.getCanFly());
        System.out.println("Can Make Sound: " + this.getCanMakeSound());
        System.out.println("----------------------");
    }

    @Override
    public String toString() {
        return super.toString() + wings + ", " + canFly + ", " + canMakeSound + "\n";
    }
    
    
}
