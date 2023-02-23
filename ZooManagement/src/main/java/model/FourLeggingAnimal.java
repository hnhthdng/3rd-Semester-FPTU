package model;

public class FourLeggingAnimal extends Animal{
    private String isDangerous;
    private String canRun;
    private String typeFood;

    public FourLeggingAnimal() {
    }

    public FourLeggingAnimal(Integer id, String name, Double weight, Integer legNumber, String color, String isDangerous, String canRun, String typeFood) {
        super(id, name, weight, legNumber, color);
        this.isDangerous = isDangerous;
        this.canRun = canRun;
        this.typeFood = typeFood;
    }

    public String getIsDangerous() {
        return isDangerous;
    }

    public void setIsDangerous(String isDangerous) {
        this.isDangerous = isDangerous;
    }

    public String getCanRun() {
        return canRun;
    }

    public void setCanRun(String canRun) {
        this.canRun = canRun;
    }

    public String getTypeFood() {
        return typeFood;
    }

    public void setTypeFood(String typeFood) {
        this.typeFood = typeFood;
    }
    
    @Override
    public void showInfo() {
        System.out.println("ID: " + this.getId());
        System.out.println("Name: " + this.getName());
        System.out.println("Weight: " + this.getWeight()+"kg");
        System.out.println("Legs: " + this.getLegs());
        System.out.println("Color: " + this.getColor());
        System.out.println("Dangerous: " + this.getIsDangerous());
        System.out.println("Can Run: " + this.getCanRun());
        System.out.println("Type Food: " + this.getTypeFood());
        System.out.println("----------------------");
    }

    @Override
    public String toString() {
        return super.toString() + isDangerous + ", " + canRun + ", " + typeFood+ "\n";
    }

    
    
    
}
