//GROUP 28
//Jason Pang
//Arush Sanghal
//Muhammad Shah

package edu.ucalgary.ensf409;

import java.util.ArrayList;

//this class is used in order to create a hamper in which items will be stored for a family 

public class Hamper {
    private ArrayList<Food> foodContents = new ArrayList<Food>();		//initializes variables 
    private ArrayList<People> family = new ArrayList<People>();
    private NutritionInfo requiredNutrition;
    private NutritionInfo actualNutrition;

    public Hamper(People[] newFamily, Food[] newFood) throws IllegalArgumentException {				//works as the constructor for the hamper class

        for(int i = 0; i < newFamily.length; i++) {
            this.family.add(newFamily[i]);
        }

        for(int j = 0; j < newFood.length; j++) {
            this.foodContents.add(newFood[j]);
        }
        
        double temporaryCalories = 0 ,temporaryGrains = 0 ,temporaryFV = 0 ,temporaryProtein = 0 ,temporaryOther = 0;
        for(int b = 0; b < newFood.length; b++) {
            temporaryCalories += newFood[b].getCalories();
            temporaryGrains += newFood[b].getGrains();
            temporaryFV += newFood[b].getFruitsVeggies();
            temporaryProtein += newFood[b].getProtein();
            temporaryOther += newFood[b].getOther();
        }
        actualNutrition = new NutritionInfo(temporaryFV, temporaryCalories, temporaryGrains, temporaryProtein, temporaryOther);

        double temporaryCalories2 = 0 ,temporaryGrains2 = 0 ,temporaryFV2 = 0 ,temporaryProtein2 = 0 ,temporaryOther2 = 0;
        for(int b = 0; b < newFamily.length; b++) {
            temporaryCalories2 += newFamily[b].returnNeeds().getCalories();
            temporaryGrains2 += newFamily[b].returnNeeds().getGrains();
            temporaryFV2 += newFamily[b].returnNeeds().getFV();
            temporaryProtein2 += newFamily[b].returnNeeds().getProtein();
            temporaryOther2 += newFamily[b].returnNeeds().getOther();
        }
        requiredNutrition = new NutritionInfo(temporaryFV2, temporaryCalories2, temporaryGrains2, temporaryProtein2, temporaryOther2);
    }

    public NutritionInfo getActualNutrition() {		//returns the values of nutritions stored in the hamper

        return this.actualNutrition;
    }

    public NutritionInfo getRequiredNutrition() {		//returns the values of needed nutritions for the hamper

        return this.requiredNutrition;
    }

    public void setFoodHamperContents(Food[] newFood) {			//fills the hamper with food content
        double temporaryCalories = 0 ,temporaryGrains = 0 ,temporaryFV = 0 ,temporaryProtein = 0 ,temporaryOther = 0;
        for(int b = 0; b < newFood.length; b++) {
            temporaryCalories += newFood[b].getCalories();
            temporaryGrains += newFood[b].getGrains();
            temporaryFV += newFood[b].getFruitsVeggies();
            temporaryProtein += newFood[b].getProtein();
            temporaryOther += newFood[b].getOther();
        }
        actualNutrition = new NutritionInfo(temporaryFV, temporaryCalories, temporaryGrains, temporaryProtein, temporaryOther);
    }

    public void addFoodItem(Food item) {			//adds items to the hamper
        this.foodContents.add(item);
        double temporaryCalories = 0 ,temporaryGrains = 0 ,temporaryFV = 0 ,temporaryProtein = 0 ,temporaryOther = 0;
        for(int i = 0; i < this.foodContents.size(); i++) {
            temporaryCalories += this.foodContents.get(i).getCalories();
            temporaryGrains += this.foodContents.get(i).getGrains();
            temporaryFV += this.foodContents.get(i).getFruitsVeggies();
            temporaryProtein += this.foodContents.get(i).getProtein();
            temporaryOther += this.foodContents.get(i).getOther();
        }
        actualNutrition = new NutritionInfo(temporaryFV, temporaryCalories, temporaryGrains, temporaryProtein, temporaryOther);
    }

    public void returnFoodName() {				//returns the name of foods being stored in the hamper
        for (int i =0 ; i < this.foodContents.size(); i++) {
            System.out.println(this.foodContents.get(i).getFoodName());
        }
    }

    public String returnFoodString() {			//creates a string of food contents in the hamper
        String temp = "Contents: " + "\n";
        for (int i =0 ; i < this.foodContents.size(); i++) {
            temp += (this.foodContents.get(i).getFoodName()) + '\n';
        }
        return temp;
    }

    public People[] getPeopleArray() {			//creates an array of the the family the hamper is being ordered for
        People[] tempFamily = this.family.toArray(new People[0]);
        return tempFamily;
    }

    public void returnFamilyDetails() {			//returns information on the family
        int m=0,f=0,co = 0 ,cu =0;
        for (int i = 0; i < this.family.size(); i++) {
            if (this.family.get(i).returnID() == 1) {
                m++;
            }
            if (this.family.get(i).returnID() == 2) {
                f++;
            }
            if (this.family.get(i).returnID() == 3) {
                co++;
            }
            if (this.family.get(i).returnID() == 4) {
                cu++;
            }
        }
        System.out.println("Adult Males: " + m);
        System.out.println("Adult Females: " + f);
        System.out.println("Children Under 8: " + co);
        System.out.println("Children Over 8: " + cu);
    }

    public String stringFamilyDetails() {			//stores the information on the family as a string
        int m=0,f=0,co = 0 ,cu =0;
        for (int i = 0; i < this.family.size(); i++) {
            if (this.family.get(i).returnID() == 1) {
                m++;
            }
            if (this.family.get(i).returnID() == 2) {
                f++;
            }
            if (this.family.get(i).returnID() == 3) {
                co++;
            }
            if (this.family.get(i).returnID() == 4) {
                cu++;
            }
        }
        String temp = "";
        temp += "Clients: " + "\n";
        temp += "AdultM: " + m + "\n";
        temp += "AdultF: " + f + "\n";
        temp += "Children Under 8: " + cu + "\n";
        temp += "Children Over 8: " + co + "\n";
        temp += "\n";
        return temp;
    }
}
