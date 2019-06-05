package com.github.fillsky;

public abstract class Manager {

    //private Kitchen kitchen = new Kitchen();
    //private FoodGiver foodGiver = new FoodGiver();
    //private CashDesk cashDesk = new CashDesk();

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
        System.out.println("Godzna odebrania " + beeper.getOrderedAt());
        System.out.println("Godznia przygotowania " + beeper.getOrderReadyAt());
        System.out.println("Godzina wydania " + beeper.getOrderTakenAt());
    }

}
