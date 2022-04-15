package edu.ucalgary.ensf409;



public class NutritionInfo {
    

    private int FRUITVEGGIES;
    private int CALORIES;
    private int GRAINS;
    private int PROTEIN;
    private int OTHER;
    private int[] nutritionArray; 

    public NutritionInfo(String fV, String cals, String grain, String prot, String other) {

        this.FRUITVEGGIES = Integer.parseInt(fV);
        this.CALORIES = Integer.parseInt(cals);
        this.GRAINS = Integer.parseInt(grain);
        this.PROTEIN = Integer.parseInt(prot);
        this.OTHER = Integer.parseInt(other);

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
