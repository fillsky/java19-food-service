package com.github.fillsky;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Beeper {

    private final String uuid = UUID.randomUUID().toString();
    private LocalDateTime orderedAt;
    private LocalDateTime orderReadyAt;
    private LocalDateTime orderTakenAt;
    //private String orderName;
    private FoodType foodType;


    public Beeper(String orderName) {

        try {
            foodType = FoodType.valueOf(orderName);
        } catch (IllegalArgumentException e){
            System.out.println("Niepoprawny argument");
            throw  new RuntimeException("Invalid enum: "+e.getMessage() + " : " +orderName );
        }

        orderedAt = LocalDateTime.now();

    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.uuid);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Beeper) {
            Beeper that = (Beeper) obj;
            return Objects.equals(this.uuid, that.uuid);
        }
        return false;
        //return super.equals(obj);
    }


    public void setOrderReadyAt(LocalDateTime orderReadyAt) {
        this.orderReadyAt = orderReadyAt;
    }

    public void setOrderTakenAt(LocalDateTime orderTakenAt) {
        this.orderTakenAt = orderTakenAt;
    }

    public LocalDateTime getOrderedAt() {
        return orderedAt;
    }

    public LocalDateTime getOrderReadyAt() {
        return orderReadyAt;
    }

    public LocalDateTime getOrderTakenAt() {
        return orderTakenAt;
    }

    public FoodType getFoodType() {
        return foodType;
    }
}
