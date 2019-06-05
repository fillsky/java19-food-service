package com.github.fillsky;

import java.time.LocalDateTime;

public class Kitchen {

    //private Manager manager = new Manager();

    public void makeOrder(Beeper beeper){

        System.out.println("jedzenie jest w przygotowaniu " + beeper.getUuid());
        finishedOrder(beeper);


    }

    public void finishedOrder (Beeper beeper){

        beeper.setOrderReadyAt(LocalDateTime.now().plusHours(1)); // dodjae godzine zeby sprawdzić
        Manager.giveFinishedOrder(beeper);

    }
}
