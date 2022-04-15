package edu.ucalgary.ensf409;

public class Food {
    
    private String[] FOODINFO = new String[2];
    private NutritionInfo NUTR_INFO = new NutritionInfo(0, 0, 0, 0, 0);

    public Food(String[] info, NutritionInfo nInfo) {
        this.FOODINFO = info;
        this.NUTR_INFO = nInfo;
    }

    public String[] getFoodInfo() {
        return this.FOODINFO;
    }

    public NutritionInfo getNutritionInfo() {
        return this.NUTR_INFO;
    }

    public String getFoodID() {
        return this.FOODINFO[0];
    }

    public String getFoodName() {
        return this.FOODINFO[1];
    }

    public int getFruitsVeggies() {
        return this.NUTR_INFO.getFV();
    }

    public int getCalories() {
        return this.NUTR_INFO.getCalories();
    }
    
    public int getProtein() {
        return this.NUTR_INFO.getProtein();
    }
    
    public int getOther() {
        return this.NUTR_INFO.getOther();
    }

    public int getGrains() {
        return this.NUTR_INFO.getGrains();
    }

    
}
