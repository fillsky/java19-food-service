package com.github.fillsky;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;


public class Kitchen {

    private Manager manager;
    private Timer timer = new Timer();
    private List<Beeper> beepers = new ArrayList<>();

    public void makeOrder(Beeper beeper) {

        System.out.println("Przygotowanie w toku... " + beeper.getUuid());
        MealPrep mealPrep = new MealPrep(beeper, this);

        beepers.add(beeper);
        int que = beepers.size();
        int delay = beeper.getFoodType().getPreparationDurationMilis()/10;

        if (que > 3) {
            System.out.println("W kolejce jest " + que + " posiłków");
            System.out.println("Czas oczekiwania to " + (delay/1000) + " sekund");
            timer.schedule(mealPrep, delay);

        } else {
            timer.schedule(mealPrep, 300);
        }


    }

    public void finishedOrder(Beeper beeper) {

        beeper.setOrderReadyAt(LocalDateTime.now().plusHours(1)); // dodjae godzine zeby sprawdzić
        beepers.remove(beeper);
        System.out.println("Kolejka po wydaniu " + beepers.size());
        manager.giveFinishedOrder(beeper);

    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
