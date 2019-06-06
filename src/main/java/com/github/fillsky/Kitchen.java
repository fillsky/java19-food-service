package com.github.fillsky;


import java.time.LocalDateTime;
import java.util.Timer;


public class Kitchen {

    private Manager manager;
    private Timer timer = new Timer();

    public void makeOrder(Beeper beeper){

        System.out.println("Przygotowanie w toku... " + beeper.getUuid());
        MealPrep mealPrep = new MealPrep(beeper, this);
        timer.schedule(mealPrep, 5000);
        //finishedOrder(beeper);


    }

    public void finishedOrder (Beeper beeper){

        beeper.setOrderReadyAt(LocalDateTime.now().plusHours(1)); // dodjae godzine zeby sprawdzić
        manager.giveFinishedOrder(beeper);

    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
