package edu.ucalgary.ensf409;



public class NutritionInfo {
    

    private double FRUITVEGGIES;
    private double CALORIES;
    private double GRAINS;
    private double PROTEIN;
    private double OTHER;
    private double[] nutritionArray = new double[5]; 

    public NutritionInfo(String fV, String cals, String grain, String prot, String other) {
        double tempcals = Integer.parseInt(cals);
        double temporaryFV = Integer.parseInt(fV);
        double tempgrains= Integer.parseInt(grain);
        double tempprotein = Integer.parseInt(prot);
        double tempother = Integer.parseInt(other);

        this.FRUITVEGGIES = (tempcals * (temporaryFV/100));
        this.CALORIES = tempcals;
        this.GRAINS = (tempcals * (tempgrains/100));
        this.PROTEIN = (tempcals * (tempprotein/100));
        this.OTHER = (tempcals * (tempother/100));

    }

    public NutritionInfo(Double fV, Double cals, Double grain, Double prot, Double other) {
        this.CALORIES = cals;
        this.FRUITVEGGIES = fV;
        this.GRAINS = grain;
        this.PROTEIN = prot;
        this.OTHER = other;
    }

    public double getFV() {
        
        return this.FRUITVEGGIES;

    }

    public double getGrains() {

        return this.GRAINS;

    }

    public double getProtein() {

        return this.PROTEIN;

    }

    public double getCalories() {

        return this.CALORIES;

    }

    public double getOther() {

        return this.OTHER;

    }

    public double[] getNutArray() {

        return this.nutritionArray;

    }

}
