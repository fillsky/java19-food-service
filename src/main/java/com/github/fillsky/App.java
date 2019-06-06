package com.github.fillsky;


import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

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

        while (input != null) {
            input = JOptionPane.showInputDialog("Order Name: ");
            manager.newOrder(input);
            System.out.println("Press Enter to send new order");
            //System.in.read();

        }


    }
}

