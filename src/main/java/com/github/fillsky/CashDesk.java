package com.github.fillsky;

public class CashDesk {

    //private Manager manager = new Manager();

    public void createOrder(String foodName){

        System.out.println("Zamównie przyjęte ");
        Manager.createOrder(foodName);


    }
}
