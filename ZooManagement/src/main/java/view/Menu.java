package view;

import controller.Zoo;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    private static String[] ops  = {
        "Load data from file",
        "Add new animal",
        "Update animal",
        "Delete animal",
        "Search animal",
        "Show animal list",
        "Save data to file",
        "Exit"
    };
    
    private static int getChoice() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < ops.length; i++) {
            System.out.println((i+1)+". "+ops[i]);
        }
        System.out.println("Enter your choice: ");
        while (true) {
                Integer choice = Integer.parseInt(sc.nextLine());
            if((choice > ops.length)) {
                System.out.println("Enter from 1 to 8");
            }else{
                return choice;
            }
        }
    }
    
    public static void display() throws IOException {
        Zoo zoo = new Zoo();
        Integer choice;
        do {            
            System.out.println("==========Zoo Management==========");
            choice = getChoice();
            switch (choice) {
                case 1:
                    zoo.load();
                    break;
                case 2:
                    zoo.add();
                    break;
                case 3:
                    zoo.update();
                    break;
                case 4:
                    zoo.delete();
                    break;
                case 5:
                    zoo.search();
                    break;
                case 6:
                    zoo.show();
                    break;
                case 7:
                    zoo.save();
                    break;
                case 8:
                    System.out.println("HAVE A GOOD DAY !");
                    break;
            }
        } while (choice != 8 );
    }
}
