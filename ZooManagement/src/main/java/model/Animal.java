package model;

public abstract class Animal {
    private Integer id;
    private String name;
    private Double weight;
    private Integer legs;
    private String color;

    public Animal() {
    }
    
    public Animal(Integer id, String name, Double weight, Integer legNumber, String color) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.legs = legNumber;
        this.color = color;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getLegs() {
        return legs;
    }

    public void setLegs(Integer legs) {
        this.legs = legs;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public abstract void showInfo();

    @Override
    public String toString() {
        return id + ", " + name + ", " + weight + ", " + legs + ", " + color + ", ";
    }
    
    
    
}
