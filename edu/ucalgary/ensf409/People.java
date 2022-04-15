package edu.ucalgary.ensf409;

public class People {
	private int ID = 0;
	private String AGE = null;
	private NutritionInfo NEEDS = null;
	
	
	public People(int id, String age, NutritionInfo needs) {
		this.ID = id;
		this.AGE = age;
		this.NEEDS = needs;
		
	}
	
	public int returnID() {
		return this.ID;
	}
	
	public NutritionInfo returnNeeds() {
		return this.NEEDS;
	}
	
	public String returnAge() {
		return this.AGE;
	}

}
