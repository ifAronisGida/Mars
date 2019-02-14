package com.codecool.mars;

public class Juniper extends Plant implements Evergreen{

    private String name;
    private static int counter = 0;
    private static final int startingProduction = 14;

    public Juniper() {
        super(startingProduction);
        name = "Juniper " + ++counter;
    }

    @Override
    public void growLeaves() {
        if (age % 5 == 0) {
            productionGrowth += 8;
            System.out.println(name + ": grew some leaves!");
        }
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
    public void passOneMonth(Farm farm) {
        productionGrowth = defaultProductionGrowth;
        growLeaves();
        produce(farm);
        checkForMax();
        prepareForNextMonth();
    }
}
