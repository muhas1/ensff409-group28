package edu.ucalgary.ensf409;

public class People {
	private static final int ID = 0;
	private static final String AGE = null;
	private static final NutrionalInfo NEEDS = null;
	
	
	public People(int id, String age, NutrionalInfo needs) {
		ID = id;
		AGE = age;
		NEEDS = needs;
		
	}
	
	public int returnID() {
		return this.ID;
	}
	
	public NutrionalInfo returnNeeds() {
		return this.NEEDS;
	}
	
	public String returnAge() {
		return this.AGE;
	}

}
