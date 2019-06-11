package com.github.fillsky;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Manager {

    private Kitchen kitchen;
    private FoodGiver foodGiver;
    private CashDesk cashDesk;
    protected static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyy, HH:mm:ss");
    private List<Beeper> beepers = new ArrayList<>();
    private FileOperator fileOperator = new FileOperator();


    public Manager(Kitchen kitchen, FoodGiver foodGiver, CashDesk cashDesk) {
        this.kitchen = kitchen;
        this.foodGiver = foodGiver;
        this.cashDesk = cashDesk;
    }

    public void newOrder(String string) {
        System.out.println("Utworzono nowe zamówienie ");
        cashDesk.createOrder(string);
    }

    public void createOrder(String orderName) {

        Beeper beeper = new Beeper(orderName);
        beepers.add(beeper);
        kitchen.makeOrder(beeper);

    }


    public void giveFinishedOrder(Beeper beeper) {

        foodGiver.callClient(beeper);

    }

    public void orderTaken(Beeper beeper) {
        System.out.println("Jedzenie odebrane " + beeper.getUuid());
        System.out.println("Nazwa " + beeper.getFoodType());
        System.out.println("Godzna przyjęcia zamówienia " + beeper.getOrderedAt().format(dateTimeFormatter));
        System.out.println("Godznia przygotowania " + beeper.getOrderReadyAt().format(dateTimeFormatter));
        System.out.println("Godzina wydania " + beeper.getOrderTakenAt().format(dateTimeFormatter));

    }




    public void openBeepersFromFile() throws IOException {
        this.beepers = fileOperator.openFile();
    }

    public void saveBeepersToFile() throws IOException{
        fileOperator.saveFile(beepers);
    }

    public List<Beeper> getBeepers() {
        return beepers;
    }
}
