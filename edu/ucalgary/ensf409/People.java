package edu.ucalgary.ensf409;

public class People {
	private int ID = 0;				//initialize required variables
	private String AGE = null;
	private NutritionInfo NEEDS = null;
	
	
	public People(int id, String age, NutritionInfo needs) throws IllegalArgumentException {		//constructor for people class
		this.ID = id;				//stores sent values into the variables declared
		this.AGE = age;
		this.NEEDS = needs;
		
	}
	
	public int returnID() {		//getter for ID
		return this.ID;
	}
	
	public NutritionInfo returnNeeds() {		//getter for Needs
		return this.NEEDS;
	}
	
	public String returnAge() {		//getter for age
		return this.AGE;
	}

}
