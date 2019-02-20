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

            existingPlants.add(spruce);
            existingPlants.add(juniper);
            existingPlants.add(almond);
        }
    }

    private boolean isSomethingIsRotten() {
        somethingIsRotten = false;
        for (Plant plant: existingPlants) {
            if (plant.isRotten()) somethingIsRotten = true;
        }
        return somethingIsRotten;
    }

    public void simulateOneMonth() {
        somethingIsRotten = isSomethingIsRotten();
        for (Plant plant: existingPlants) {
            if (plant.isRotten()) somethingIsRotten = true;
            incrementTotalFoodBy(plant.getProductionPerMonth());
            plant.passOneMonth();
            System.out.println("Total food is now: " + totalFood);
        }
    }
}
