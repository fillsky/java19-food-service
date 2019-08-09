package com.github.fillsky;

import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

public abstract class UserCommands {


    public static void mainMenu() {


        Scanner scn = new Scanner(System.in);

        System.out.println("Wybierz jedną z opcji:\n start\n exit");
        String str = scn.nextLine();

        switch (str) {

            case "start":
                start();
                break;

            case "exit":
                exit();
                break;

            default: {
                System.out.println("Zły wybór");
                mainMenu();
                break;
            }

        }


    }

    private static void start() {

        System.out.println("Start placeholder");

        Kitchen kitchen = new Kitchen();
        FoodGiver foodGiver = new FoodGiver();
        CashDesk cashDesk = new CashDesk();

        Manager manager = new Manager(kitchen, foodGiver, cashDesk);

        kitchen.setManager(manager);
        foodGiver.setManager(manager);
        cashDesk.setManager(manager);

        System.out.println(manager.getBeepers()); // sprawdzam czy beepery sie zaczytaly z pliku

        while (true) {
            String input = JOptionPane.showInputDialog("Order Name: ");

            if (input.equals("exit")) {
                mainMenu();
            }

            try {
                FoodType food = FoodType.fromStringIgnoreCase(input);
                manager.newOrder(food.toString());

            } catch (IllegalFoodException e) {
                e.printStackTrace();
            }
        }
    }

    private static void openFile() {

    }

    private static void saveFile() {

    }

    private static void showBeepers() {

    }

    private static void exit() {

        System.out.println("Closing application");
        System.exit(0);
    }


}
