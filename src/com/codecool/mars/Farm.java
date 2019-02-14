package com.codecool.mars;

import java.util.ArrayList;

public class Farm {
    private int totalFood;
    private boolean somethingIsRotten;
    private ArrayList<Plant> existingPlants = new ArrayList<>();


    public void incrementTotalFoodBy(int amount) {
        if (!somethingIsRotten) totalFood += amount;

    }

    protected void setSomethingIsRotten(boolean somethingIsRotten) {
        this.somethingIsRotten = somethingIsRotten;
    }

    public void plantPlants() {
        for (int i = 0; i < 2 ; i++) {
            Spruce spruce = new Spruce();
            Juniper juniper = new Juniper();
            Almond almond = new Almond();

            existingPlants.add(existingPlants.size(), spruce);
            existingPlants.add(existingPlants.size(), juniper);
            existingPlants.add(existingPlants.size(), almond);
        }
    }

    public void simulateOneMonth(Farm farm) {
        somethingIsRotten = false;
        for (Plant plant: existingPlants) {
            plant.passOneMonth(farm);
            System.out.println("Total food is now: " + totalFood);
        }
    }
}
