package edu.ucalgary.ensf409;

import java.util.ArrayList;

public class Hamper {
    private ArrayList<Food> foodContents = new ArrayList<Food>();
    private ArrayList<People> family = new ArrayList<People>();
    private NutritionInfo requiredNutrition;
    private NutritionInfo actualNutrition;

    public Hamper(People[] newFamily, Food[] newFood) {

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

    public NutritionInfo getActualNutrition() {

        return this.actualNutrition;
    }

    public NutritionInfo getRequiredNutrition() {

        return this.requiredNutrition;
    }

    public void setFoodHamperContents(Food[] newFood) {
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

    public void addFoodItem(Food item) {
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

    public void returnFoodName() {
        for (int i =0 ; i < this.foodContents.size(); i++) {
            System.out.println(this.foodContents.get(i).getFoodName());
        }
    }

    public People[] getPeopleArray() {
        People[] tempFamily = this.family.toArray(new People[0]);
        return tempFamily;
    }

    public void returnFamilyDetails() {
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
}
