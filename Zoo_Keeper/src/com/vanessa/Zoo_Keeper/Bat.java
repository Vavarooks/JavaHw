package com.vanessa.Zoo_Keeper;

public class Bat extends Mammal {
	public int healthBat(){
	//Create a Bat class that can fly(), eatHumans(), and attackTown() and has a default energy level of 300.		
	this.energyLevel = 300;
	return energyLevel;
	}
	public String fly() {
		this.healthBat();
		if(energyLevel >= 100) {
			
			energyLevel -= 50;
			return "Woosh!";
		}
		return "Not enough energy";
	//For the fly() method, print the sound of a bat taking off and decrease its energy by 50.
	//
	}
	public String eatHumans() {
		this.healthBat();
		energyLevel += 25;
		return "*Crunch*";
	//For the eatHumans() method, print the so- well, never mind, just increase its energy by 25.
	//
	}
	public String attackTown() {
		this.healthBat();
		if(energyLevel >= 100) {
			
			energyLevel -= 100;
			return "*Screams*";
		}
		return "Not enough energy.";
	//For the attackTown() method, print the sound of a town on fire and decrease its energy by 100.	
	}

}
