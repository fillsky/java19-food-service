package com.github.fillsky;

import java.time.LocalDateTime;

public class FoodGiver {

    private Manager manager;

    public void callClient(Beeper beeper) {
        System.out.println("Zapraszam po odbiór zamówienie " + beeper.getUuid());
        orderTaken(beeper, true);


    }

    private void orderTaken(Beeper beeper, boolean taken) {

        if (taken) {
            beeper.setOrderTakenAt(LocalDateTime.now().plusMinutes(15));
            manager.orderTaken(beeper);

        } else {
            System.out.println("Jedzenie nie odebrane");
            beeper.setOrderTakenAt(null);

        }


    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
