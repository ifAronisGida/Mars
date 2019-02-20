package com.codecool.mars;

import java.util.Random;

public class Almond extends Plant implements SpecialPlant{

    private boolean belowLimit;
    private String name;
    private static int counter = 0;

    private static final int startingProduction = 50;
    Random random = new Random();

    public Almond() {
        super(startingProduction);
        name = "Almond" + ++counter;
        if (this.productionPerMonth < 40) {
            belowLimit = true;
        } else {
            belowLimit = false;
        }

    }

    @Override
    public void growShroom() {
        if (random.nextDouble() <= 0.08) {
            productionGrowth += 10;
            System.out.println(name + ": grew some shrooms!");
        }
    }

    @Override
    public boolean isRotten() {
        boolean isRotting = false;
        if (random.nextDouble() <= 0.13) {
            productionGrowth -= 18;
            System.out.println(name + ": is now rotting!!");
            isRotting = true;
        }
        return isRotting;
    }

    @Override
    public void passOneMonth() {
        productionGrowth = defaultProductionGrowth;
        growShroom();
        prepareForNextMonth();
    }
}
