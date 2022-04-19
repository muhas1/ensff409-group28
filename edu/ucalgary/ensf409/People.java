//GROUP 28
//Jason Pang
//Arush Sanghal
//Muhammad Shah

package edu.ucalgary.ensf409;

//Gets the different values related to a persons age and id, and gathers the needs for that age group

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
