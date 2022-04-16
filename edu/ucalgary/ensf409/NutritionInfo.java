package edu.ucalgary.ensf409;



public class NutritionInfo {
    

    private double FRUITVEGGIES;
    private double CALORIES;
    private double GRAINS;
    private double PROTEIN;
    private double OTHER;
    private double[] nutritionArray = new double[5]; 

    public NutritionInfo(String fV, String cals, String grain, String prot, String other) {
        this.CALORIES = Integer.parseInt(cals);
        this.FRUITVEGGIES = Integer.parseInt(fV);
        this.GRAINS = Integer.parseInt(grain);
        this.PROTEIN = Integer.parseInt(prot);
        this.OTHER = Integer.parseInt(other);

    }

    public double getFV() {

        return (this.CALORIES * this.FRUITVEGGIES/100);

    }

    public double getGrains() {

        return (this.CALORIES * this.GRAINS/100);

    }

    public double getProtein() {

        return (this.CALORIES * this.PROTEIN/100);

    }

    public double getCalories() {

        return this.CALORIES;

    }

    public double getOther() {

        return (this.CALORIES * this.OTHER/100);

    }

    public double[] getNutArray() {

        return this.nutritionArray;

    }




}
