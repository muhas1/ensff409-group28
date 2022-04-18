package edu.ucalgary.ensf409;

import java.util.ArrayList;

public class Application {
    
    private int adultM;
    private int adultF;
    private int childO;
    private int childU;

    public static void main(String[] args) {
        database myInventory = new database("jdbc:mysql://localhost/food_inventory");
        myInventory.createConnection();
        myInventory.fillClientNeeds();
        myInventory.fillFoodList();
        Food newItem = myInventory.returnFoodItem(1);
        ArrayList<Food> newList = myInventory.getFoodItems();
        //System.out.println(newItem.getFruitsVeggies());
        People newPerson = new People(2, "AdultF", myInventory.getClient(1));
        People newPerson2 = new People(3, "AdultF", myInventory.getClient(0));
        //System.out.println(newPerson.returnNeeds().getGrains());
        Food[] newFoodList = new Food[10];
        for(int i = 0; i < newFoodList.length; i++) {
            newFoodList[i] = myInventory.returnFoodItem(i+1);
        }
        People[] newF = new People[4];
        newF[0] = newPerson;
        newF[1] = newPerson2;
        newF[2] = newPerson2;
        newF[3] = newPerson2;

        Food[] emptyFoodList = new Food[1];
        emptyFoodList[0] = newItem;

        Hamper newHamper = new Hamper(newF, emptyFoodList);
        CaloricCalc newCalculator = new CaloricCalc(newList, newHamper);

        Hamper finalHamper = new Hamper(newF, newCalculator.calculateOptimalHamper());
        System.out.println(finalHamper.getRequiredNutrition().getCalories());
        System.out.println(finalHamper.getActualNutrition().getCalories());
        System.out.println("# Grains #");
        System.out.println(finalHamper.getRequiredNutrition().getGrains());
        System.out.println(finalHamper.getActualNutrition().getGrains());
        System.out.println("# Protein #");
        System.out.println(finalHamper.getRequiredNutrition().getProtein());
        System.out.println(finalHamper.getActualNutrition().getProtein());
        System.out.println("# FruitVeggies #");
        System.out.println(finalHamper.getRequiredNutrition().getFV());
        System.out.println(finalHamper.getActualNutrition().getFV());
        System.out.println("# Other #");
        System.out.println(finalHamper.getRequiredNutrition().getOther());
        System.out.println(finalHamper.getActualNutrition().getOther());

    }
}   
 