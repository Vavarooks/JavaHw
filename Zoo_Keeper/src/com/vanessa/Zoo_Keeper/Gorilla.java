package com.vanessa.Zoo_Keeper;

public class Gorilla extends Mammal {
	public String throwSomething() {
		energyLevel -= 5;
		return("*Rock Flies By*");
	}
	public String eatBananas() {
		energyLevel += 10;
		return "Haha Looks like he's hungry.";
	}
	public String climb() {
		if(energyLevel >= 10) {
			energyLevel -= 10;
			return "Wow look at that gorilla climb!";
		}
		return "Looks like the gorilla is taking a rest.";
	}
}
