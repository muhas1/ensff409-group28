//GROUP 28
//Jason Pang
//Arush Sanghal
//Muhammad Shah

package edu.ucalgary.ensf409;

import java.util.ArrayList;

//Class is used to find the best combination of food for a hamper containing a specified amount of people
//Uses an algorithm to compare items in a database and stores those items in an array and returns them afterwards

public class CaloricCalc {
    
    private double caloriesNeeded = 0;			//initialize variables
    private double grainsNeeded = 0;
    private double proteinNeeded = 0;
    private double fruitveggiesNeeded = 0;
    private double otherNeeded = 0;
    private ArrayList<Food> foodHamper = new ArrayList<Food>();
    private Hamper newHamperStorage;

    public CaloricCalc(ArrayList<Food> inventory, Hamper newHamper) {	//constructor for CaloricCalc
        this.foodHamper = inventory;
        this.newHamperStorage = newHamper;
        this.caloriesNeeded = newHamper.getRequiredNutrition().getCalories();
        this.grainsNeeded = newHamper.getRequiredNutrition().getGrains();
        this.proteinNeeded = newHamper.getRequiredNutrition().getProtein();
        this.fruitveggiesNeeded = newHamper.getRequiredNutrition().getFV();
        this.otherNeeded = newHamper.getRequiredNutrition().getOther();
    }

    public Food[] calculateOptimalHamper() {					//used to find the optimal hamper for the number of people using it
        ArrayList<Food> temporaryHamper = new ArrayList<>();
        ArrayList<Food> newFamilyHamper = calculateAttribute(0, this.caloriesNeeded, temporaryHamper, 0);
        
        Food[] tempFood = newFamilyHamper.toArray(new Food[0]);
        return tempFood;
    }   

    public ArrayList<Food> calculateAttribute(double actual, double needed, ArrayList<Food> inventory, int index) {		//algorithm used to find which items from the database function for the purpose
        ArrayList<Food> attributeBasket = inventory;
        double newA = actual;
        double percent = newA/needed;
        database newData = new database("jdbc:mysql://localhost/food_inventory");
        newData.createConnection();
        int i = 0;
        while (( percent < 0.8 || percent > 1.2) && (i < this.foodHamper.size())) {

            if ((this.foodHamper.get(i).getNutritionInfo().getNutArray()[index] != 0) && (i < this.foodHamper.size())) {
                attributeBasket.add(this.foodHamper.get(i));
                this.foodHamper.remove(i);
                newData.deleteFoodList(i);
                newA += this.foodHamper.get(i).getNutritionInfo().getNutArray()[index];
                percent = newA/needed;
            }
            i++;
        }
        return attributeBasket;
    }

}
