package com.vanessa.Zoo_Keeper;

public class Zoo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Gorilla gorilla1 = new Gorilla();
		System.out.println("Watch out! "+ gorilla1.throwSomething() + " Ah! Duck!");
		System.out.println("Watch out! "+ gorilla1.throwSomething() + " Ah! Duck!");
		System.out.println("Watch out! "+ gorilla1.throwSomething() + " Ah! Duck!");
		System.out.println("Look! "+ gorilla1.eatBananas());
		System.out.println("Look! "+ gorilla1.eatBananas());
		System.out.println("Oh wow, "+ gorilla1.climb());
		System.out.println("Wow you have " + gorilla1.displayEnergy()  + " Energy Left");
		
		Bat bat1 = new Bat();
		System.out.println("*village in the distance*" + bat1.attackTown());
		System.out.println("*village in the distance*" + bat1.attackTown());
		System.out.println("*village in the distance*" + bat1.attackTown());
		System.out.println("Ah-" + bat1.eatHumans());
		System.out.println("Ah-" + bat1.eatHumans());
		System.out.println("Look up! Is that Bat-man? " + bat1.fly());
		System.out.println("The Bat has: "+ bat1.displayEnergy()+ " Energy Left.");
	}

}
