package com.github.fillsky;

import java.time.format.DateTimeFormatter;

public abstract class Manager {

    //private Kitchen kitchen = new Kitchen();
    //private FoodGiver foodGiver = new FoodGiver();
    //private CashDesk cashDesk = new CashDesk();
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyy, HH:mm:ss");

    public static void newOrder(String string) {
        CashDesk cashDesk = new CashDesk();
        System.out.println("Utworzono nowe zamówienie ");
        cashDesk.createOrder(string);
    }

    public static void createOrder(String orderName) {

        Beeper beeper = new Beeper(orderName);
        Kitchen kitchen = new Kitchen();
        kitchen.makeOrder(beeper);

    }

    public static void giveFinishedOrder(Beeper beeper) {

        FoodGiver foodGiver = new FoodGiver();
        foodGiver.callClient(beeper);

    }

    public static void orderTaken(Beeper beeper) {
        System.out.println("Jedzenie odebrane " + beeper.getUuid());
        System.out.println("Nazwa " + beeper.getOrderName());
        System.out.println("Godzna przyjęcia zamówienia " + beeper.getOrderedAt().format(dateTimeFormatter));
        System.out.println("Godznia przygotowania " + beeper.getOrderReadyAt().format(dateTimeFormatter));
        System.out.println("Godzina wydania " + beeper.getOrderTakenAt().format(dateTimeFormatter));
    }

}
