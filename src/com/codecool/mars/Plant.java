package com.codecool.mars;

public abstract class Plant {
    protected int productionPerMonth;
    protected int productionGrowth;
    protected int age;
    protected static final int defaultProductionGrowth = 4;

    protected Plant(int productionPerMonth) {
        this.productionPerMonth = productionPerMonth;
        this.productionGrowth = defaultProductionGrowth;
        age = 0;
    }

    public int getProductionPerMonth() {
        return productionPerMonth;
    }

    public abstract void passOneMonth();

    public abstract boolean isRotten();

    protected void prepareForNextMonth() {
        productionPerMonth += productionGrowth;
        age++;
    }
}
