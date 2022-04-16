package edu.ucalgary.ensf409;

import java.util.ArrayList;

public class Hamper {
    private ArrayList<Food> foodContents = new ArrayList<Food>();
    private ArrayList<People> family = new ArrayList<People>();
    private NutritionInfo requiredNutrition;
    private NutritionInfo actualNutrition;

    public Hamper(People[] newFamily, Food[] newFood) {

        for(int i = 0; i < newFamily.length; i++) {
            this.family.add(newFamily[i]);
        }

        for(int j = 0; j < newFood.length; j++) {
            this.foodContents.add(newFood[j]);
        }

        double temporaryCalories = 0 ,temporaryGrains = 0 ,temporaryFV = 0 ,temporaryProtein = 0 ,temporaryOther = 0;
        for(int b = 0; b < newFood.length; b++) {
            temporaryCalories += newFood[b].getCalories();
            temporaryGrains += newFood[b].getGrains();
            temporaryFV += newFood[b].getFruitsVeggies();
            temporaryProtein += newFood[b].getProtein();
            temporaryOther += newFood[b].getOther();
        }
        actualNutrition = new NutritionInfo(temporaryFV, temporaryCalories, temporaryGrains, temporaryProtein, temporaryOther);
    }

    public NutritionInfo getActualNutrition() {
        return this.actualNutrition;
    }
}
