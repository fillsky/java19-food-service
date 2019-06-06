package com.github.fillsky;


import java.util.TimerTask;

public class MealPrep extends TimerTask {

    private Beeper beeper;
    private Kitchen kitchen;
    public MealPrep(Beeper beeper, Kitchen kitchen) {
        this.beeper = beeper;
        this.kitchen = kitchen;
    }

    @Override
    public void run() {
        System.out.println("Przygotowano... ");
        kitchen.finishedOrder(beeper);

    }
}
