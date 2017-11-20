package com.pointwest.training.bean;

public abstract class AnimalBean {

	protected String name;
	protected String gender;
	protected int age;
	protected static int animalCounter = 1000;
	protected int uniqueID;
	
	
	public abstract void sound();


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public static int getAnimalCounter() {
		return animalCounter;
	}


	public static void setAnimalCounter(int animalCounter) {
		AnimalBean.animalCounter = animalCounter;
	}


	public int getUniqueID() {
		return uniqueID;
	}


	public void setUniqueID(int uniqueID) {
		this.uniqueID = uniqueID;
	}
	
	
	
	
	
}
