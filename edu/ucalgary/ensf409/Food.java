public class Food {
	
	//Used in order to find and store the nutritional values of different foods in the inventory for later usage.
    
    private String[] FOODINFO = new String[2];			//initialize variables
    private NutritionInfo NUTR_INFO = new NutritionInfo("0", "0", "0", "0", "0");

    public Food(String[] info, NutritionInfo nInfo) {		//constructors for Food
        this.FOODINFO = info;
        this.NUTR_INFO = nInfo;
    }

    public String[] getFoodInfo() {					//returns FoodInfo
        return this.FOODINFO;
    }

    public NutritionInfo getNutritionInfo() {		//returns NutritionInfo
        return this.NUTR_INFO;
    }

    public String getFoodID() {				//returns FoodID
        return this.FOODINFO[0];
    }

    public String getFoodName() {			//returns FoodName
        return this.FOODINFO[1];
    }

    public double getFruitsVeggies() {		//returns FruitsVeggies calories
        return this.NUTR_INFO.getFV();
    }

    public double getCalories() {
        return this.NUTR_INFO.getCalories();	//returns calories
    }
    
    public double getProtein() {
        return this.NUTR_INFO.getProtein();		//returns protein calories
    }
    
    public double getOther() {
        return this.NUTR_INFO.getOther();		//returns other calories
    }

    public double getGrains() {
        return this.NUTR_INFO.getGrains();
    }

    
}
