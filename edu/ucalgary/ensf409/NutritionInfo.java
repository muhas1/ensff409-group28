package edu.ucalgary.ensf409;



public class NutritionInfo {
    

    private int FRUITVEGGIES;
    private int CALORIES;
    private int GRAINS;
    private int PROTEIN;
    private int OTHER;
    private int[] nutritionArray; 

    public NutritionInfo(int fV, int cals, int grain, int prot, int other) {

        this.FRUITVEGGIES = fV;
        this.CALORIES = cals;
        this.GRAINS = grain;
        this.PROTEIN = prot;
        this.OTHER = other;

    }

    public int getFV() {

        return this.FRUITVEGGIES;

    }

    public int getGrains() {

        return this.GRAINS;

    }

    public int getProtein() {

        return this.PROTEIN;

    }

    public int getCalories() {

        return this.CALORIES;

    }

    public int getOther() {

        return this.OTHER;

    }

    public int[] getNutArray() {

        return this.nutritionArray;

    }




}
