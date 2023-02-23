package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import model.*;
import view.Menu;

public class Zoo {
    Scanner sc = new Scanner(System.in);
    List<Animal> animalList = new LinkedList<>();

    public Zoo() {
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }
    
    public void add() {
        Integer id = Validation.getInt("Enter id number: ", "Please enter a number");
        String name = Validation.getString("Enter name: ", "Please enter a string");
        Double weight = Validation.getDouble("Enter weight: ", "Please enter a number");
        Integer leg = Validation.getLegs("Enter leg number: ", "Please enter a number");
        if(leg.equals(0)) {
            String color = Validation.getString("Enter color: ", "Please enter a string");
            String characteristic = Validation.getString("Enter characteristic: ", "Please enter a string");
            animalList.add(new NonleggedAnimal(id, name, weight, leg, color, characteristic));
        } else if(leg.equals(2)) {
            String color = Validation.getString("Enter color: ", "Please enter a string");
            Integer wings = Validation.getInt("Enter wings number: ", "Please enter a number");
            String canFly = Validation.getYesNo("Can they fly(Yes/No): ", "Please enter yes or no");
            if(canFly.equalsIgnoreCase("yes")) {
                animalList.add(new BipedalAndFlyingAnimal(id, name, weight, leg, color, wings, canFly));
            }
            else {
                String canSound = Validation.getYesNo("Can they make sound(Yes/No): ", "Please enter yes or no");
                animalList.add(new BipedalAndFlightlessAnimal(id, name, weight, leg, color, wings, canFly, canSound));
            }
        }
        else if(leg.equals(4)) {
            String color = Validation.getString("Enter color: ", "Please enter a string");
            String isdangerous = Validation.getYesNo("Are they dangerous(Yes/No): ", "Please enter yes or no");
            String canRun = Validation.getYesNo("Can they run(Yes/No): ", "Please enter yes or no");
            String typeFood = Validation.getString("Enter type food: ", "Please enter a string");
            animalList.add(new FourLeggingAnimal(id, name, weight, leg, color, isdangerous, canRun, typeFood));
        }
    }
    
    public void update() {
        while (true) {            
            Integer id = Validation.getInt("Enter id number: ", "Please enter a number");
            for (Animal animal : animalList) {
                if(!animal.getId().equals(id)) {
                    System.out.println("Animal does not exist !");
                }else {
                    String temp;
                    animal.showInfo();

                    //change new ID
                    while (true) {                        
                        System.out.println("Enter new ID : ");
                        temp = sc.nextLine();
                        if (temp=="" && temp.isBlank()) {
                            System.out.println("ID have no change");
                            break;
                        }
                        else if(temp.matches(".*\\d+.*")) {
                            for (Animal animal1 : animalList) {
                                if (animal1.getId().equals(Integer.parseInt(temp))) {
                                    System.out.println("ID exist");
                                } else {
                                    animal.setId(Integer.parseInt(temp));
                                }
                            }
                            break;
                        }
                        else {
                            System.out.println("Please enter a number !");
                        }
                    }

                    //change new name
                    while (true) {                        
                        System.out.println("Enter new name : ");
                        temp = sc.nextLine();
                        if (temp=="" && temp.isBlank()) {
                            System.out.println("Name have no change");
                            break;
                        }else if(temp.matches(".*\\d+.*")) {
                            System.out.println("Please enter a string");
                        }
                        else {
                            animal.setName(temp);
                            break;
                        }
                    }

                    //change new weight
                    while (true) {                        
                        System.out.println("Enter new weight: ");
                        temp = sc.nextLine();
                        if (temp=="" && temp.isBlank()) {
                            System.out.println("Weight have no change");
                            break;
                        }
                        else if(temp.matches(".*\\d+.*")) {
                            animal.setWeight(Double.parseDouble(temp));
                            break;
                        }
                        else {
                        System.out.println("Please enter a number");
                        } 
                    }

                    //change new legs
                    while (true) {                        
                        System.out.println("Enter new legs: ");
                        temp = sc.nextLine();
                        if (temp=="" && temp.isBlank()) {
                            System.out.println("Legs have no change");
                            break;
                        }
                        else if(temp.matches("0") || temp.matches("2") || temp.matches("4")){
                            animal.setLegs(Integer.parseInt(temp));
                            break;
                        }
                        else{
                            System.out.println("Please enter number 0, 2 or 4 !");
                        }
                    }

                    //change new color
                    while (true) {                        
                        System.out.println("Enter new color : ");
                        temp = sc.nextLine();
                        if (temp=="" && temp.isBlank()) {
                            System.out.println("Color have no change");
                            break;
                        }
                        else if(temp.matches(".*\\d+.*")) {
                            System.out.println("Please enter string");
                        }
                        else {
                            animal.setColor(temp);
                            break;
                        }
                    }

                    if (animal instanceof NonleggedAnimal) {
                        //change new characteristic
                        while (true) {                            
                            System.out.println("Enter new characteristic : ");
                            temp = sc.nextLine();
                            if (temp=="" && temp.isBlank()) {
                                System.out.println("Characteristic have no change");
                                break;
                            }
                            else if(!temp.matches(".*\\d+.*")){
                                ((NonleggedAnimal) animal).setCharacteristic(temp);
                                break;
                            }
                            else {
                                System.out.println("Please enter a string");
                            }
                        }
                    }

                    if(animal instanceof BipedalAndFlightlessAnimal || animal instanceof BipedalAndFlyingAnimal) {
                        //change new wings
                        while (true) {                            
                            System.out.println("Enter new wings number: ");
                            temp = sc.nextLine();
                            if (temp=="" && temp.isBlank()) {
                            System.out.println("Wings have no change");
                            break;
                            }
                            else if(temp.matches(".*\\d+.*")) {
                                if(animal instanceof BipedalAndFlightlessAnimal) {
                                    ((BipedalAndFlightlessAnimal) animal).setWings(Integer.parseInt(temp));
                                }
                                else {
                                    ((BipedalAndFlyingAnimal) animal).setWings(Integer.parseInt(temp));
                                }
                                break;
                            }
                            else {
                                System.out.println("PLease enter a number");
                            }
                        }
                        
                        //change new canFly
                        while (true) {                            
                            System.out.println("Can they fly ? (Yes/No) ");
                            temp = sc.nextLine();
                            if (temp=="" && temp.isBlank()) {
                            System.out.println("canFly have no change");
                            break;
                            }
                            else if(!temp.matches(".*\\d+.*")) {
                                if(temp.equalsIgnoreCase("yes") || temp.equalsIgnoreCase("no")) {
                                    if(animal instanceof BipedalAndFlightlessAnimal) {
                                        ((BipedalAndFlightlessAnimal) animal).setCanFly(temp);
                                    }
                                    else {
                                        ((BipedalAndFlyingAnimal) animal).setCanFly(temp);
                                    }
                                    break;
                                }
                                else {
                                    System.out.println("Please enter Yes or No !");
                                }
                            }
                            else {
                                System.out.println("PLease enter a string");
                            }
                        }
                        if(animal instanceof BipedalAndFlightlessAnimal) {
                            //change canMakeSound
                            while (true) {                            
                                System.out.println("Can they make sound ? (Yes/No) ");
                                temp = sc.nextLine();
                                if (temp=="" && temp.isBlank()) {
                                System.out.println("canMakeSound have no change");
                                break;
                                }
                                else if(!temp.matches(".*\\d+.*")) {
                                    if(temp.equalsIgnoreCase("yes") || temp.equalsIgnoreCase("no")) {
                                        ((BipedalAndFlightlessAnimal) animal).setCanMakeSound(temp);
                                        break;
                                    }
                                    else {
                                        System.out.println("Please enter Yes or No !");
                                    }
                                }
                                else {
                                    System.out.println("PLease enter a string");
                                }
                            }
                        }
                        
                    }
                    if(animal instanceof FourLeggingAnimal) {
                        //change isDangerous
                        while (true) {                            
                            System.out.println("Are they dangerous ? (Yes/No) ");
                            temp = sc.nextLine();
                            if (temp=="" && temp.isBlank()) {
                            System.out.println("isDangerous have no change");
                            break;
                            }
                            else if(!temp.matches(".*\\d+.*")) {
                                if(temp.equalsIgnoreCase("yes") || temp.equalsIgnoreCase("no")) {
                                    ((FourLeggingAnimal) animal).setIsDangerous(temp);
                                    break;
                                }
                                else {
                                    System.out.println("Please enter Yes or No !");
                                }
                            }
                            else {
                                System.out.println("PLease enter a string");
                            }
                        }
                        
                        //change canRun
                        while (true) {                            
                            System.out.println("Can they run ? (Yes/No) ");
                            temp = sc.nextLine();
                            if (temp=="" && temp.isBlank()) {
                            System.out.println("canRun have no change");
                            break;
                            }
                            else if(!temp.matches(".*\\d+.*")) {
                                if(temp.equalsIgnoreCase("yes") || temp.equalsIgnoreCase("no")) {
                                    ((FourLeggingAnimal) animal).setCanRun(temp);
                                    break;
                                }
                                else {
                                    System.out.println("Please enter Yes or No !");
                                }
                            }
                            else {
                                System.out.println("PLease enter a string");
                            }
                        }
                        
                        //change type food
                        while (true) {                            
                            System.out.println("What type food ?");
                            temp = sc.nextLine();
                            if (temp=="" && temp.isBlank()) {
                            System.out.println("Type food have no change");
                            break;
                            }
                            else if(!temp.matches(".*\\d+.*")) {
                                ((FourLeggingAnimal) animal).setTypeFood(temp);
                                break;
                            }
                            else {
                                System.out.println("PLease enter a string");
                            }
                        }
                    }
                }
            }
            
            String choose = Validation.getYesNo("Do you want to change another animal (Yes/No) ?", "Please enter Yes or No");
            if(!choose.equalsIgnoreCase("yes")) {
                break;
            }
            
        }
    } 
    
    public void delete() {
        System.out.println("Enter ID animal you want to delete: ");
        Integer id = Integer.parseInt(sc.nextLine());
        for (Animal animal : animalList) {
            if(animal.getId().equals(id)) {
                animal.showInfo();
                String choose = Validation.getYesNo("Are you sure you want to delete this animal(Yes/No) ? ", "Please enter yes or no");
                if(choose.equalsIgnoreCase("Yes")) {
                    animalList.remove(animal);
                    System.out.println("Delete success !");
                }
                else {
                    System.out.println("Cancel delete");
                }
            }
            else {
                System.out.println("ID doesn't exist !");
            }
        }
    }
    
    public void search() {
        /*
        mode 1: search by name
        mode 2: search by type
        */
        while (true) { 
            System.out.println("1. Search by name or weight");
            System.out.println("2. Search by type");
            try {
                Integer mode = Integer.parseInt(sc.nextLine());
                if(mode == 1 || mode == 2) {
                    if(mode == 1) {
                        while (true) {                            
                            System.out.println("1. Search by name");
                            System.out.println("2. Search by weight ");
                            try {
                                Integer choose = Integer.parseInt(sc.nextLine());
                                if(choose == 1) {
                                    System.out.println("Enter name you want to search: ");
                                    String name = sc.nextLine();
                                    for (Animal animal : animalList) {
                                        if(animal.getName().equalsIgnoreCase(name)) {
                                            animal.showInfo();
                                            break;
                                        }
                                        else {
                                            System.out.println("Animal doesn't exist");
                                        }
                                    }
                                    break;
                                }
                                else if(choose == 2) {
                                    System.out.println("Enter upper and lower	bound of the desired weight ");
                                    System.out.println("Enter upper bound");
                                    Integer upper = Integer.parseInt(sc.nextLine());
                                    System.out.println("Enter lower bound");
                                    Integer lower = Integer.parseInt(sc.nextLine());
                                    for (Animal animal : animalList) {
                                        if(animal.getWeight() >= lower && animal.getWeight() <= upper) animal.showInfo();
                                        else System.out.println("Animal doesn't exsit");
                                    }
                                    break;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Please enter enter a number");
                            }
                        }
                        
                    }
                    else {
                        while (true) {  
                            System.out.println("1. Non legging Animal");
                            System.out.println("2. Bipedal and Flightless Animal");
                            System.out.println("3. Bipedal and Flying Animal");
                            System.out.println("4. Four legging Animal");
                            try {
                                Integer choose = Integer.parseInt(sc.nextLine());
                                if (choose == 1) {
                                    for (Animal animal : animalList) {
                                        if(animal instanceof NonleggedAnimal) animal.showInfo();
                                        else System.out.println("Animal does not exist");
                                    }
                                    break;
                                }
                                else if(choose == 2) {
                                    for (Animal animal : animalList) {
                                        if(animal instanceof BipedalAndFlightlessAnimal) animal.showInfo();
                                        else System.out.println("Animal does not exist");
                                    }
                                    break;
                                }
                                else if(choose == 3) {
                                    for (Animal animal : animalList) {
                                        if(animal instanceof BipedalAndFlyingAnimal) animal.showInfo();
                                        else System.out.println("Animal does not exist");
                                    }
                                    break;
                                }
                                else if(choose == 4) {
                                    for (Animal animal : animalList) {
                                        if(animal instanceof FourLeggingAnimal) animal.showInfo();
                                        else System.out.println("Animal does not exist");
                                    }
                                    break;
                                }
                                else {
                                    System.out.println("Please enter between 1 to 4 !");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Please enter a number");
                            }
                        }
                    }
                    break;
                }
                else {
                    System.out.println("Please enter 1 or 2");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            }
        }
        
    }
    
    public void show() {
        /*
        mode 1: show all 
        mode 2: show by type
        */
        try {
            System.out.println("1. Show all");
            System.out.println("2. Show by type");
            while (true) {                
                Integer mode = Integer.parseInt(sc.nextLine());
                if(mode == 1) {
                    for (Animal animal : animalList) {
                        animal.showInfo();
                    }
                    break;
                }
                else if(mode == 2) {
                    while (true) {                        
                        System.out.println("1. Non legging Animal");
                        System.out.println("2. Bipedal and Flightless Animal");
                        System.out.println("3. Bipedal and Flying Animal");
                        System.out.println("4. Four legging Animal");
                        
                        try {
                            Integer choose = Integer.parseInt(sc.nextLine());
                            if(choose == 1) {
                                for (Animal animal : animalList) {
                                    if(!(animal instanceof NonleggedAnimal)){
                                    }
                                    else animal.showInfo();
                                }
                                break;
                            }
                            else if(choose == 2) {
                                    for (Animal animal : animalList) {
                                        if(!(animal instanceof BipedalAndFlightlessAnimal)){
                                            
                                        }
                                        else animal.showInfo();
                                    }
                                    break;
                                }
                            else if(choose == 3) {
                                for (Animal animal : animalList) {
                                    if(!(animal instanceof BipedalAndFlyingAnimal)){
                                    }
                                    else animal.showInfo();
                                }
                                break;
                            }
                            else if(choose == 4) {
                                for (Animal animal : animalList) {
                                    if(!(animal instanceof FourLeggingAnimal)){
                                    }
                                    else animal.showInfo();
                                }
                                break;
                            }
                            else {
                                System.out.println("Please enter between 1 to 4 !");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a number");
                        }
                    }
                    break;
                }
                else {
                    System.out.println("Please enter 1 or 2");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a number");
        }
    }
    
    public void save() throws IOException {
        File f = new File("animal.dat");
        FileWriter fw = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(fw);
        for (Animal animal : animalList) {
            bw.write(animal.toString());
        }
        System.out.println("Save success !");
        bw.close();
        fw.close();
    }
    
     public void load() throws FileNotFoundException, IOException {
        File f = new File("animal.dat");
        if(!f.exists()) {
            System.out.println("NEW FILE IS CREATED");
            f.createNewFile();
        }
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        
        while(true) {
            String line = br.readLine();
            if(line == null) break;
            String[] info = line.split("[,]");
            Integer id = Integer.parseInt(info[0].trim());
            String name = info[1].trim();
            Double weight = Double.parseDouble(info[2].trim());
            Integer leg = Integer.parseInt(info[3].trim());
            if(leg == 0) {
                String color = info[4].trim();
                String characteristic = info[5].trim();
                animalList.add(new NonleggedAnimal(id, name, weight, leg, color, characteristic));
            }
            if(leg == 2) {
                String color = info[4].trim();
                Integer wings = Integer.parseInt(info[5].trim());
                String canFly = info[6].trim();
                if(canFly.equalsIgnoreCase("yes")) {
                    animalList.add(new BipedalAndFlyingAnimal(id, name, weight, leg, color, wings, canFly));
                }
                else {
                    String canMakeSound = info[7].trim();
                    animalList.add(new BipedalAndFlightlessAnimal(id, name, weight, leg, color, wings, canFly, canMakeSound));
                }
            }
            if(leg == 4) {
                String color = info[4].trim();
                String isDangerous = info[5].trim();
                String canRun = info[6].trim();
                String typeFood = info[7].trim();
                animalList.add(new FourLeggingAnimal(id, name, weight, leg, color, isDangerous, canRun, typeFood));
                
            }
        }
        System.out.println("LOAD SUCCESSFULL !");
        br.close();
        fr.close();
    }
}
