package edu.ucalgary.ensf409;

import java.util.ArrayList;

public class CaloricCalc {

    private ArrayList<Food> foodHamper = new ArrayList<Food>();
    
    public Food[] calculateOptimalHamper(Hamper newHamper, ArrayList<Food> inventory) {

        this.foodHamper = inventory;
        double caloriesNeeded = newHamper.getRequiredNutrition().getCalories();
        double grainsNeeded = newHamper.getRequiredNutrition().getGrains();
        double proteinNeeded = newHamper.getRequiredNutrition().getProtein();
        double fruitveggiesNeeded = newHamper.getRequiredNutrition().getFV();
        double otherNeeded = newHamper.getRequiredNutrition().getOther();

        Food[] newFood = new Food[1];
        return newFood;
    }   
}
