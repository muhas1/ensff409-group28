//GROUP 28
//Jason Pang
//Arush Sanghal
//Muhammad Shah


package edu.ucalgary.ensf409;

import java.util.ArrayList;

public class Application {
    
    Hamper actualHamper;

    public void applicationClass(People[] newF) {
        database myInventory = new database("jdbc:mysql://localhost/food_inventory");
        myInventory.createConnection();
        myInventory.fillClientNeeds();
        myInventory.fillFoodList();
        Food newItem = myInventory.returnFoodItem(1);
        ArrayList<Food> newList = myInventory.getFoodItems();

        Food[] emptyFoodList = new Food[1];
        emptyFoodList[0] = newItem;

        Hamper newHamper = new Hamper(newF, emptyFoodList);
        CaloricCalc newCalculator = new CaloricCalc(newList, newHamper);

        Hamper finalHamper = new Hamper(newF, newCalculator.calculateOptimalHamper());
        this.actualHamper = finalHamper;
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
        orderForm newOrder = new orderForm();
        newOrder.printToText(this.actualHamper);
    }

    public Hamper returnHamper() {
        return this.actualHamper;
    }
}   
 
