package com.codecool.mars;

public class Main {

    public static void main(String[] args) {

        Farm farm = new Farm();
        farm.plantPlants();
        for (int i = 0; i < 80; i++) {
            farm.simulateOneMonth();
        }
    }
}
