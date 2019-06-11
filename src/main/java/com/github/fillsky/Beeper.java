package com.github.fillsky;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Beeper {

    private String uuid = UUID.randomUUID().toString();
    private LocalDateTime orderedAt;
    private LocalDateTime orderReadyAt;
    private LocalDateTime orderTakenAt;
    //private String orderName;
    private FoodType foodType;

    public Beeper() {

    }

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

    @Override
    public String toString() {
        return uuid + ";" +
                orderedAt.format(Manager.dateTimeFormatter) + ";" +
                orderReadyAt.format(Manager.dateTimeFormatter) + ";" +
                orderTakenAt.format(Manager.dateTimeFormatter)+ ";" +
                foodType + ";";
    }

    public Beeper fromString(String string){

        String [] s = string.split(";");
        Beeper beeper = new Beeper(s[4]);
        beeper.setOrderTakenAt(LocalDateTime.parse(s[3], Manager.dateTimeFormatter));
        beeper.setOrderReadyAt(LocalDateTime.parse(s[2], Manager.dateTimeFormatter));
        beeper.setOrderedAt(LocalDateTime.parse(s[1], Manager.dateTimeFormatter));
        beeper.setUuid(s[0]);
        return beeper;

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

    public void setOrderedAt(LocalDateTime orderedAt) {
        this.orderedAt = orderedAt;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

}
