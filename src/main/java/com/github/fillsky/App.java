package com.github.fillsky;


import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {

        Kitchen kitchen = new Kitchen();
        FoodGiver foodGiver = new FoodGiver();
        CashDesk cashDesk = new CashDesk();

        Manager manager = new Manager(kitchen, foodGiver, cashDesk);

        kitchen.setManager(manager);
        foodGiver.setManager(manager);
        cashDesk.setManager(manager);

        System.in.read();

        manager.newOrder("Burger");


    }
}

