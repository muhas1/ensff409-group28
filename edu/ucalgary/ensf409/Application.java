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
        // ArrayList<Food> newList = myInventory.getFoodItems();
        System.out.println(newItem.getFruitsVeggies());
        People newPerson = new People(1, "AdultF", myInventory.getClient(1));
        People newPerson2 = new People(1, "AdultF", myInventory.getClient(1));
        //System.out.println(newPerson.returnNeeds().getGrains());
        Food[] newFoodList = new Food[10];
        for(int i = 0; i < newFoodList.length; i++) {
            newFoodList[i] = myInventory.returnFoodItem(i+1);
        }
        People[] newF = new People[2];
        newF[0] = newPerson;
        newF[1] = newPerson2;

        Hamper newHamper = new Hamper(newF, newFoodList);
        System.out.println(newHamper.getActualNutrition().getCalories());
        System.out.println(newHamper.getRequiredNutrition().getCalories());
        newHamper.addFoodItem(myInventory.returnFoodItem(76));
        System.out.println(newHamper.getActualNutrition().getCalories());
    }
}   
 