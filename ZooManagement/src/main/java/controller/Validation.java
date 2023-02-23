package controller;

import java.util.Scanner;

public class Validation {
    static Scanner sc = new Scanner(System.in);
    public static String getString(String msg, String err) {
        String str;
        while (true) {            
            System.out.println(msg);
            str = sc.nextLine();
            if(str.matches(".*\\d+.*")) {
                System.out.println(err);
            }else {
                return str;
            }
        }
    }
    public static Double getDouble(String msg, String err) {
        Double db;
        while (true) {            
            try {
                System.out.println(msg);
                db = Double.parseDouble(sc.nextLine());
                return db;
            } catch (NumberFormatException e) {
                System.out.println(err);
            }
        }
    }
    
    public static Integer getInt(String msg, String err) {
        Integer integer;
        while (true) {            
            try {
                System.out.println(msg);
                integer = Integer.parseInt(sc.nextLine());
                return integer;
            } catch (NumberFormatException e) {
                System.out.println(err);
            }
        }
    }
    
    public static Integer getLegs(String msg, String err) {
        Integer integer;
        while (true) {            
            try {
                System.out.println(msg);
                integer = Integer.parseInt(sc.nextLine());
                if(integer.equals(0) || integer.equals(2) || integer.equals(4)) {
                    return integer;
                }else {
                    System.out.println("Leg number just be 0, 2 or 4 !");
                }
            } catch (NumberFormatException e) {
                System.out.println(err);
            }
        }
    }
    
    public static String getYesNo(String msg, String err) {
        String choose;
        while (true) {  
            System.out.println(msg);
            choose = sc.nextLine();
            if(choose.equalsIgnoreCase("yes") || choose.equalsIgnoreCase("no")) {
                return choose;
            }
            else {
                System.out.println(err);
            }
        }
    }
}
