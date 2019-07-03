package com.github.fillsky;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FoodGiver {

    private Manager manager;
    private boolean isAnyFoodWaiting;
    private List<Beeper> orders = new ArrayList();

    public void callClient(Beeper beeper) {
        System.out.println("Zapraszam po odbiór zamówienie " + beeper.getUuid());
        orders.add(beeper);
        orderTaken(beeper, true);


    }

    private void orderTaken(Beeper beeper, boolean taken) {

        if (taken) {
            beeper.setOrderTakenAt(LocalDateTime.now().plusMinutes(15));
            orders.remove(beeper);
            manager.orderTaken(beeper);

        } else {
            System.out.println("Jedzenie nie odebrane");
            beeper.setOrderTakenAt(null);

        }

        if (orders.isEmpty()){
            isAnyFoodWaiting = false;
        } else {
            isAnyFoodWaiting = true;
        }
    }

    public boolean isAnyFoodWaiting() {
        return isAnyFoodWaiting;
    }

    public void setAnyFoodWaiting(boolean anyFoodWaiting) {
        isAnyFoodWaiting = anyFoodWaiting;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
