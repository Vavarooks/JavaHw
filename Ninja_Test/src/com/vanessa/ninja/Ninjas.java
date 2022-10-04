package com.vanessa.ninja;

public class Ninjas {
	private String name;
	private String weapon;
	private String school;
	private int powerLevel;
	private int health;
	private int stamina;
	
	public Ninjas() {
		this.name = "anonymous";
		this.weapon = "punches";
		this.health = 100;
	}
	
	public void attack(Ninjas target) {
		System.out.println(this.getName() + " attacked " + target.getName());
		target.setHealth(target.getName() - this.powerLevel());
	}
	
//	--- Getter Setters ----
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getWeapon() {
		return weapon;
	}
	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public int getPowerLevel() {
		return powerLevel;
	}
	public void setPowerLevel(int powerLevel) {
		this.powerLevel = powerLevel;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getStamina() {
		return stamina;
	}
	public void setStamina(int stamina) {
		this.stamina = stamina;
	}
	
}
