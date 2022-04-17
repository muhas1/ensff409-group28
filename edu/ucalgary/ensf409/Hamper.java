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

        double temporaryCalories2 = 0 ,temporaryGrains2 = 0 ,temporaryFV2 = 0 ,temporaryProtein2 = 0 ,temporaryOther2 = 0;
        for(int b = 0; b < newFamily.length; b++) {
            temporaryCalories2 += newFamily[b].returnNeeds().getCalories();
            temporaryGrains2 += newFamily[b].returnNeeds().getGrains();
            temporaryFV2 += newFamily[b].returnNeeds().getFV();
            temporaryProtein2 += newFamily[b].returnNeeds().getProtein();
            temporaryOther2 += newFamily[b].returnNeeds().getOther();
        }
        requiredNutrition = new NutritionInfo(temporaryFV2, temporaryCalories2, temporaryGrains2, temporaryProtein2, temporaryOther2);
    }

    public NutritionInfo getActualNutrition() {
        return this.actualNutrition;
    }

    public NutritionInfo getRequiredNutrition() {
        return this.requiredNutrition;
    }

    public void setFoodHamperContents(Food[] newFood) {
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
}
