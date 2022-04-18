package edu.ucalgary.ensf409;

import java.util.ArrayList;

public class Application {
    

    public void applicationClass(People[] newF) {
        database myInventory = new database("jdbc:mysql://localhost/food_inventory");
        myInventory.createConnection();
        myInventory.fillClientNeeds();
        myInventory.fillFoodList();
        Food newItem = myInventory.returnFoodItem(1);
        ArrayList<Food> newList = myInventory.getFoodItems();
        Food[] newFoodList = new Food[10];
        for(int i = 0; i < newFoodList.length; i++) {
            newFoodList[i] = myInventory.returnFoodItem(i+1);
        }

        Food[] emptyFoodList = new Food[1];
        emptyFoodList[0] = newItem;

        Hamper newHamper = new Hamper(newF, emptyFoodList);
        CaloricCalc newCalculator = new CaloricCalc(newList, newHamper);

        Hamper finalHamper = new Hamper(newF, newCalculator.calculateOptimalHamper());
        System.out.println("# FAMILY LIST: ");
        finalHamper.returnFamilyDetails();
        System.out.println("# CALORIES # ");
        System.out.println("Required: " + finalHamper.getRequiredNutrition().getCalories());
        System.out.println("Actual: " + finalHamper.getActualNutrition().getCalories());
        System.out.println("# Grains #");
        System.out.println("Required: " + finalHamper.getRequiredNutrition().getGrains());
        System.out.println("Actual: " + finalHamper.getActualNutrition().getGrains());
        System.out.println("# Protein #");
        System.out.println("Required: " + finalHamper.getRequiredNutrition().getProtein());
        System.out.println("Actual: " + finalHamper.getActualNutrition().getProtein());
        System.out.println("# FruitVeggies #");
        System.out.println("Required: " + finalHamper.getRequiredNutrition().getFV());
        System.out.println("Actual: " + finalHamper.getActualNutrition().getFV());
        System.out.println("# Other #");
        System.out.println("Required: " + finalHamper.getRequiredNutrition().getOther());
        System.out.println("Actual: " + finalHamper.getActualNutrition().getOther());
        System.out.println("# FOOD LIST #");
        finalHamper.returnFoodName();
    }
}   
 