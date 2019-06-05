package com.github.fillsky;

import java.time.LocalDateTime;

public class FoodGiver {

    //Manager manager = new Manager();

    public void callClient(Beeper beeper) {
        System.out.println("Zapraszam po odbiór zamówienie " + beeper.getUuid());
        orderTaken(beeper, true);


    }

    private void orderTaken(Beeper beeper, boolean taken) {

        if (taken) {
            beeper.setOrderTakenAt(LocalDateTime.now().plusMinutes(15));
            Manager.orderTaken(beeper);

        } else {
            System.out.println("Jedzenie nie odebrane");
            beeper.setTaken(false);

        }

    }
}
