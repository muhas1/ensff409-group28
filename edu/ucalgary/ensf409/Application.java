package edu.ucalgary.ensf409;

import java.util.ArrayList;

public class Application {
    
    public static void main(String[] args) {
        database myInventory = new database("jdbc:mysql://localhost/food_inventory");
        myInventory.createConnection();
        myInventory.fillClientNeeds();
        myInventory.fillFoodList();
        Food newItem = myInventory.returnFoodItem(154);
        System.out.println(newItem.getFruitsVeggies());
    }
}   
 