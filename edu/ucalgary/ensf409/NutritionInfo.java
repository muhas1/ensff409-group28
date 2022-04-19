//GROUP 28
//Jason Pang
//Arush Sanghal
//Muhammad Shah

package edu.ucalgary.ensf409;

//Used to get the nutritional data for food items and specific clients

public class NutritionInfo {
    

    private double FRUITVEGGIES;        //initializes the variables
    private double CALORIES;
    private double GRAINS;
    private double PROTEIN;
    private double OTHER;
    private double[] nutritionArray = new double[5]; 

    public NutritionInfo(String fV, String cals, String grain, String prot, String other) {     //Constructor for when nutritional values are entered as a string
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

        // Setting Array
        this.nutritionArray[0] = tempcals;;
        this.nutritionArray[1] = (tempcals * (temporaryFV/100));;
        this.nutritionArray[2] = (tempcals * (tempgrains/100));
        this.nutritionArray[3] = (tempcals * (tempprotein/100));;
        this.nutritionArray[4] = (tempcals * (tempother/100));

    }

    public NutritionInfo(Double fV, Double cals, Double grain, Double prot, Double other) {     //Constructor for when nutritional values are taken from the database
        this.CALORIES = cals;
        this.FRUITVEGGIES = fV;
        this.GRAINS = grain;
        this.PROTEIN = prot;
        this.OTHER = other;
        this.nutritionArray[0] = cals;
        this.nutritionArray[1] = fV;
        this.nutritionArray[2] = grain;
        this.nutritionArray[3] = prot;
        this.nutritionArray[4] = other;
    }

    public double getFV() {         //returns the calories required for Fruits & Veggies
        
        return this.FRUITVEGGIES;

    }

    public double getGrains() {     //returns the calories required for Grains

        return this.GRAINS;

    }

    public double getProtein() {        //returns the calories required for Protein

        return this.PROTEIN;

    }

    public double getCalories() {       //returns the calories

        return this.CALORIES;

    }

    public double getOther() {      //returns the calories required for Other

        return this.OTHER;

    }

    public double[] getNutArray() {     //returns an array of required calories for each type of nutrient and over all calories

        return this.nutritionArray;

    }

}
