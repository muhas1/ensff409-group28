package edu.ucalgary.ensf409;

public class People {
	private final int ID = 0;
	private final String AGE = null;
	private final NutrionalInfo NEEDS = null;
	
	
	public People(int id, String age, NutrionalInfo needs) {
		this.ID = id;
		this.AGE = age;
		this.NEEDS = needs;
		
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
