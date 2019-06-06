package com.github.fillsky;

public class CashDesk {

    private Manager manager;

    public void createOrder(String foodName) {

        System.out.println("Zamównie przyjęte ");
        manager.createOrder(foodName);


    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
