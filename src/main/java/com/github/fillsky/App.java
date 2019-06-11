package com.github.fillsky;


import javax.swing.*;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {

        String input = "1";
        Kitchen kitchen = new Kitchen();
        FoodGiver foodGiver = new FoodGiver();
        CashDesk cashDesk = new CashDesk();

        Manager manager = new Manager(kitchen, foodGiver, cashDesk);

        kitchen.setManager(manager);
        foodGiver.setManager(manager);
        cashDesk.setManager(manager);

        FoodType frytki = FoodType.FRYTKI;
        System.out.println(frytki.getPreparationDurationMilis());
        FoodType burger = FoodType.BURGER;

        for (FoodType value : FoodType.values()) {
            System.out.println(value);

        }

        manager.openBeepersFromFile();
        System.out.println(manager.getBeepers());
        for (int i = 0; i < 10; i++) {
            input = JOptionPane.showInputDialog("Order Name: ");

            try {
                FoodType food = FoodType.fromStringIgnoreCase(input);
                manager.newOrder(food.toString());

            } catch (IllegalFoodException e) {
                e.printStackTrace();
            }

            System.out.println("Press Enter to send new order");
            //System.in.read();

        }

        manager.saveBeepersToFile();

//        System.in.read();
//        manager.saveToFile();
//        System.out.println(manager.getBeepers().toString());


    }
}

