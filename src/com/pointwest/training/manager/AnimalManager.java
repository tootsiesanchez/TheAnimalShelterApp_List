package com.pointwest.training.manager;

import java.util.ArrayList;
import java.util.List;

import com.pointwest.training.bean.AnimalBean;
import com.pointwest.training.bean.CatBean;
import com.pointwest.training.bean.DogBean;
import com.pointwest.training.bean.ParrotBean;

public class AnimalManager {
	List<AnimalBean> listOfAnimals = new ArrayList<AnimalBean>();
		
	
	private int setAnimalID() {
		int uniqueID = AnimalBean.getAnimalCounter() + 1;
		AnimalBean.setAnimalCounter(uniqueID);
		
		return uniqueID;
	}
	
	public void addDog(DogBean newDog) {
		newDog.setUniqueID(setAnimalID());
		
		listOfAnimals.add(newDog);
	}

	public void addCat(CatBean newCat) {
		newCat.setUniqueID(setAnimalID());
		
		listOfAnimals.add(newCat);
	}

	public void addParrot(ParrotBean newParrot) {
		newParrot.setUniqueID(setAnimalID());
		
		listOfAnimals.add(newParrot);
	}

	public boolean removeAnimal(int animalID) {
		for (AnimalBean animal : listOfAnimals) {
			if (animal.getUniqueID() == animalID) {
				listOfAnimals.remove(animal);
				return true;
			}
		}
		
		return false;
	}

	public List<AnimalBean> viewAnimal() {
		return listOfAnimals;
	}
	
	public int getAnimalCount() {
		return listOfAnimals.size();
	}

}
