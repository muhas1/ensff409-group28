package edu.ucalgary.ensf409;

import java.util.ArrayList;
import java.util.Random;

public class CaloricCalc {
    
    private double caloriesNeeded = 0;
    private double grainsNeeded = 0;
    private double proteinNeeded = 0;
    private double fruitveggiesNeeded = 0;
    private double otherNeeded = 0;
    private ArrayList<Food> foodHamper = new ArrayList<Food>();
    private Hamper newHamperStorage;

    public CaloricCalc(ArrayList<Food> inventory, Hamper newHamper) {
        this.foodHamper = inventory;
        this.newHamperStorage = newHamper;
        this.caloriesNeeded = newHamper.getRequiredNutrition().getCalories();
        this.grainsNeeded = newHamper.getRequiredNutrition().getGrains();
        this.proteinNeeded = newHamper.getRequiredNutrition().getProtein();
        this.fruitveggiesNeeded = newHamper.getRequiredNutrition().getFV();
        this.otherNeeded = newHamper.getRequiredNutrition().getOther();
    }

    public Food[] calculateOptimalHamper() {
        ArrayList<Food> temporaryHamper = new ArrayList<>();
        ArrayList<Food> newFamilyHamper = calculateAttribute(0, this.caloriesNeeded, temporaryHamper, 0);
        
        Food[] tempFood = new Food[newFamilyHamper.size()]; 
        for (int a = 0; a < newFamilyHamper.size(); a++) {
            tempFood[a] = newFamilyHamper.get(a);
        }

        return tempFood;
    }   

    public ArrayList<Food> calculateAttribute(double actual, double needed, ArrayList<Food> inventory, int index) {
        ArrayList<Food> attributeBasket = inventory;
        double newA = actual;
        double percent = newA/needed; 

        int i = 0;
        while (( percent < 0.8 || percent > 1.2) && (i < this.foodHamper.size())) {

            if ((this.foodHamper.get(i).getNutritionInfo().getNutArray()[index] != 0)) {
                attributeBasket.add(this.foodHamper.get(i));
                this.foodHamper.remove(i);
                newA += this.foodHamper.get(i).getNutritionInfo().getNutArray()[index];
                percent = newA/needed;
            }
            i++;
        }
        return attributeBasket;
    }

}
