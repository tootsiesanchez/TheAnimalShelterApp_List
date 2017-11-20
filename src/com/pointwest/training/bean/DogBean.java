package com.pointwest.training.bean;

public class DogBean extends AnimalBean {

	private String signatureSound = "arf arf arf";
	private int uniqueID;
	
	public String getSignatureSound() {
		return signatureSound;
	}

	public void setSignatureSound(String signatureSound) {
		this.signatureSound = signatureSound;
	}

	public int getUniqueID() {
		return uniqueID;
	}

	public void setUniqueID(int uniqueID) {
		this.uniqueID = uniqueID;
	}

	public void sound() {
		//uniqueID=aDog++;
		System.out.println(uniqueID + ": " + signatureSound + " Hi I'm " + getName() + " the Dog, I'm " + getAge() + " of age.");
	}
	
	
	
}
