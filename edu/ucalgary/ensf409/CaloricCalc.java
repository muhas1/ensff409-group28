package edu.ucalgary.ensf409;

import java.util.ArrayList;
import java.util.Random;

public class CaloricCalc {
    
    private static double caloriesNeeded = 0;
    private static double grainsNeeded = 0;
    private static double proteinNeeded = 0;
    private static double fruitveggiesNeeded = 0;
    private static double otherNeeded = 0;

    public static Food[] calculateOptimalHamper(Hamper newHamper, ArrayList<Food> inventory) {

        ArrayList<Food> foodHamper = new ArrayList<Food>();
        foodHamper = inventory;
        caloriesNeeded = newHamper.getRequiredNutrition().getCalories();
        grainsNeeded = newHamper.getRequiredNutrition().getGrains();
        proteinNeeded = newHamper.getRequiredNutrition().getProtein();
        fruitveggiesNeeded = newHamper.getRequiredNutrition().getFV();
        otherNeeded = newHamper.getRequiredNutrition().getOther();

        ArrayList<Food> tempHamper = new ArrayList<Food>();
        double actualCalories = 0;
        double actualGrains = 0;
        double actualProtein = 0;
        double actualFV = 0;
        double actualOther = 0;

        
        tempHamper = returnRandomlyGenerated(caloriesNeeded,inventory);
        // Temporary Array
        Food[] tempFoodArray = new Food[tempHamper.size()];
        for (int a = 0; a < tempHamper.size(); a++) {
            tempFoodArray[a] = tempHamper.get(a);
        }
        return tempFoodArray;
    }   

    public static ArrayList<Food> returnRandomlyGenerated(double calories, ArrayList<Food> inventory) {

        ArrayList<Food> tempFood = new ArrayList<Food>();
        ArrayList<Food> tempInventory = inventory;
        double actualCals = 0;
        double actualGrains = 0;
        double actualProtein = 0;
        double actualFV = 0;
        double actualOther = 0;
        int i = 0;
        Random rand = new Random();
        int n = 0;
        while((actualCals < calories) & (n < tempInventory.size())) {
            n = rand.nextInt(tempInventory.size());
            if(tempInventory.get(n).getCalories() != 0) {
                tempFood.add(tempInventory.get(n));
                tempInventory.remove(n);
            }
            actualCals += tempFood.get(i).getCalories();
            actualGrains += tempFood.get(i).getGrains();
            actualFV += tempFood.get(i).getFruitsVeggies();
            actualProtein += tempFood.get(i).getProtein();
            actualOther += tempFood.get(i).getOther();
            i++;
        }

        return tempFood;
    }
}
