package com.github.fillsky;

import java.time.format.DateTimeFormatter;

public class Manager {

    public Manager(Kitchen kitchen, FoodGiver foodGiver, CashDesk cashDesk) {
        this.kitchen = kitchen;
        this.foodGiver = foodGiver;
        this.cashDesk = cashDesk;
    }

    private Kitchen kitchen;
    private FoodGiver foodGiver;
    private CashDesk cashDesk;
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyy, HH:mm:ss");

    public void newOrder(String string) {
        System.out.println("Utworzono nowe zamówienie ");
        cashDesk.createOrder(string);
    }

    public void createOrder(String orderName) {

        Beeper beeper = new Beeper(orderName);
        kitchen.makeOrder(beeper);

    }

    public void giveFinishedOrder(Beeper beeper) {

        foodGiver.callClient(beeper);

    }

    public void orderTaken(Beeper beeper) {
        System.out.println("Jedzenie odebrane " + beeper.getUuid());
        System.out.println("Nazwa " + beeper.getOrderName());
        System.out.println("Godzna przyjęcia zamówienia " + beeper.getOrderedAt().format(dateTimeFormatter));
        System.out.println("Godznia przygotowania " + beeper.getOrderReadyAt().format(dateTimeFormatter));
        System.out.println("Godzina wydania " + beeper.getOrderTakenAt().format(dateTimeFormatter));
    }

}
