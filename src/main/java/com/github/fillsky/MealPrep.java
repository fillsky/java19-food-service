package com.github.fillsky;


import java.util.TimerTask;

public class MealPrep extends TimerTask {

    private Beeper beeper;
    public MealPrep(Beeper beeper) {
        this.beeper = beeper;
    }

    @Override
    public void run() {
        System.out.println("Przygotowano... ");
        new Kitchen().finishedOrder(beeper);

    }
}
