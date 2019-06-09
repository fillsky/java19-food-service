package com.github.fillsky;

public enum FoodType {
    BURGER(30000), FRYTKI(10000), ZIALSKO(5000), NACHOSY(3000), SERUS(20000);

    private int preparationDurationMilis;

    FoodType(int preparationDurationMilis) {
        this.preparationDurationMilis = preparationDurationMilis;
    }

    public int getPreparationDurationMilis() {
        return preparationDurationMilis;
    }
}
