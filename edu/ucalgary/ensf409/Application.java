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
        People newPerson2 = new People(3, "AdultF", myInventory.getClient(2));
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
        Hamper temporaryHamper = new Hamper(newF, emptyFoodList);
        double percentage = 1.20;
        double percentage2 = 1.20;
        Hamper clientsHamper = new Hamper(newF, emptyFoodList);
        while(percentage > 1.05) {
            Food[] newArray = CaloricCalc.calculateOptimalHamper(temporaryHamper, newList);
            clientsHamper = new Hamper(newF, newArray);
            System.out.println("Ratio of Calories: " + percentage);
            System.out.println("Ratio of Grains: " + percentage2);
            percentage = clientsHamper.getActualNutrition().getCalories()/clientsHamper.getRequiredNutrition().getCalories();
            percentage2 = clientsHamper.getActualNutrition().getGrains()/clientsHamper.getRequiredNutrition().getGrains();
        }

        System.out.println("# RATIOS #");
        System.out.println("Ratio of Calories: " + percentage);
        System.out.println("Ratio of Grains: " + percentage2);
        System.out.println("# CALORIES #");
        System.out.println(clientsHamper.getRequiredNutrition().getCalories());
        System.out.println(clientsHamper.getActualNutrition().getCalories());
        System.out.println("# GRAINS #");
        System.out.println(clientsHamper.getRequiredNutrition().getGrains());
        System.out.println(clientsHamper.getActualNutrition().getGrains());
        System.out.println("# FOOD LIST");
        clientsHamper.returnFoodName();
    }
}   
 