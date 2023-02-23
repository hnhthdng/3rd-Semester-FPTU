package model;

public class BipedalAndFlyingAnimal extends Animal {
    private Integer wings;
    private String canFly;

    public BipedalAndFlyingAnimal() {
    }

    public BipedalAndFlyingAnimal(Integer id, String name, Double weight, Integer legNumber, String color, Integer wings, String canFly) {
        super(id, name, weight, legNumber, color);
        this.wings = wings;
        this.canFly = canFly;
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
    
    @Override
    public void showInfo() {
        System.out.println("ID: " + this.getId());
        System.out.println("Name: " + this.getName());
        System.out.println("Weight: " + this.getWeight()+"kg");
        System.out.println("Legs: " + this.getLegs());
        System.out.println("Color: " + this.getColor());
        System.out.println("Wings: " + this.getWings());
        System.out.println("Can Fly: " + this.getCanFly());
        System.out.println("----------------------");
    }

    @Override
    public String toString() {
        return super.toString() + wings + ", " + canFly + "\n";
    }
    
    
}
