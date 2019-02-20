package com.codecool.mars;

import java.util.Random;

public class Spruce extends Plant implements Evergreen, SpecialPlant {

    private String name;
    private static int counter = 0;
    private static final int startingProduction = 26;
    Random random = new Random();

    public Spruce() {
        super(startingProduction);
        name = "Spruce " + ++counter;
    }

    @Override
    public void growLeaves() {
        if (age % 5 == 0) {
            if (age != 0) productionGrowth += 8;
            System.out.println(name + ": grew some leaves!");
        }
    }

    @Override
    public void growShroom() {
        if (random.nextDouble() <= 0.05) {
            productionGrowth += 15;
            System.out.println(name + ": grew some shrooms!");
        }
    }

    @Override
    public boolean isRotten() {
        boolean isRotting = false;
        if (random.nextDouble() <= 0.04) {
            productionGrowth -= 20;
            System.out.println(name + ": is now rotting!!");
            isRotting = true;
        }
        return isRotting;
    }

    @Override
    public void checkForMax() {
        if (productionPerMonth >= 70) {
            System.out.println(name + " at full production!");
            productionGrowth = 0;
            productionPerMonth = 70;
        }
    }

    @Override
    public void passOneMonth() {
        productionGrowth = defaultProductionGrowth;
        growShroom();
        growLeaves();
        checkForMax();
    }
}
