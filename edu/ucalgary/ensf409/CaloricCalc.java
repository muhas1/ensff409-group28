package edu.ucalgary.ensf409;

import java.util.ArrayList;

public class CaloricCalc {
    
    public Food[] calculateOptimalHamper(Hamper newHamper, ArrayList<Food> inventory) {
        ArrayList<Food> foodHamper = new ArrayList<Food>();
        foodHamper = inventory;
        double caloriesNeeded = newHamper.getRequiredNutrition().getCalories();
        double grainsNeeded = newHamper.getRequiredNutrition().getGrains();
        double proteinNeeded = newHamper.getRequiredNutrition().getProtein();
        double fruitveggiesNeeded = newHamper.getRequiredNutrition().getFV();
        double otherNeeded = newHamper.getRequiredNutrition().getOther();

        Food[] newFood = new Food[1];
        newFood[0] = foodHamper.get(1);
        return newFood;
    }
}
