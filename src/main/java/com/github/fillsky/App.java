package com.github.fillsky;


import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {


        Kitchen kitchen = new Kitchen();
        FoodGiver foodGiver = new FoodGiver();
        CashDesk cashDesk = new CashDesk();

        Manager manager = new Manager(kitchen, foodGiver, cashDesk);

        kitchen.setManager(manager);
        foodGiver.setManager(manager);
        cashDesk.setManager(manager);

        while (true) {
            System.out.println("Press Enter to send new order");
            //System.in.read();
            String input = JOptionPane.showInputDialog("Order Name: ");
            manager.newOrder(input);
        }


    }
}

