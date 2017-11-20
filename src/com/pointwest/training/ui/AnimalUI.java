package com.pointwest.training.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.pointwest.training.bean.AnimalBean;
import com.pointwest.training.bean.CatBean;
import com.pointwest.training.bean.DogBean;
import com.pointwest.training.bean.ParrotBean;
import com.pointwest.training.manager.AnimalManager;

public class AnimalUI {

	AnimalManager animalManager = new AnimalManager();

	public void displayMainMenu() {

		int maxAnimalCount = 10;
		int totalAnimalCount = animalManager.getAnimalCount();
		boolean tryAgain = true;
		do {
			Scanner scanner = new Scanner(System.in);

			if (totalAnimalCount ==  0) {
				displayHeader();
				System.out.println("The shelter is currently empty.");
				displayOption1();
			} else if(totalAnimalCount < maxAnimalCount) {
				displayHeader();
				displayOption1();
				displayOption2();
				displayOption3();
				displayEnterMsg();
			} else {
				System.out.println("\nThe shelter is now full. We can no longer be able to accept a new animal.");
				System.out.println("\nDo you want to continue?[Y]Yes/ [N]No");
				String scanned =  scanner.nextLine();
				if (scanned.equalsIgnoreCase("Y"))
				{
					displayHeader();
					displayOption2();
					displayOption3();
					displayEnterMsg();
				}
				else 
				{
					tryAgain = false;
				}
			}
			
			if (tryAgain)
			{
				switch (scanner.nextLine()) {
					case "1":
						displayAddMenu();
						totalAnimalCount = animalManager.getAnimalCount();
						break;
					case "2":
						displayRemoveMenu();
						totalAnimalCount = animalManager.getAnimalCount();
						break;
					case "3":
						viewAnimal();
						break;
				}
			}
			
		} while (tryAgain);
		
		System.out.println("\nThe program will now end. Thank You!");
	}
	
	public void displayHeader() {
		System.out.println("\nWelcome to Tootsie's Animal Shelter!");
		System.out.println("\nPlease Select an option: ");
	}
	
	public void displayOption1()
	{
		System.out.println("[1] Add an Animal");
	}
	
	public void displayOption2()
	{
		System.out.println("[2] Remove an Animal");
	}
	
	public void displayOption3()
	{
		System.out.println("[3] View All Animal");
	}
	
	public void displayEnterMsg()
	{
		System.out.println("\nEnter Choice: ");
	}

	public void displayAddMenu() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("What animal are you trying to add?");
		System.out.println("[1] A Dog");
		System.out.println("[2] A Cat");
		System.out.println("[3] A Parrot");
		System.out.println("\nEnter choice: ");

		switch (scanner.nextLine()) {
			case "1":
				addNewDog();
				break;
			case "2":
				addNewCat();
				break;
			case "3":
				addNewParrot();
				break;
		}

	}
	
	public void addNewDog() {
		DogBean newDog = new DogBean();
		Scanner scanner = new Scanner(System.in);
		// AnimalManager animalManager = new AnimalManager();

		System.out.println("Enter Name of Dog: ");
		newDog.setName(scanner.nextLine());

		System.out.println("Enter Age of Dog: ");
		newDog.setAge(scanner.nextInt());

		System.out.println("Enter Gender of Dog: ");
		newDog.setGender(scanner.next());

		animalManager.addDog(newDog);

		System.out.println("\nAnimal " + newDog.getName() + " is now added.");
		System.out.println("Total animals in the shelter: " + animalManager.getAnimalCount() + "\n");

		// return newDog;
	}

	public void addNewCat() {
		CatBean newCat = new CatBean();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter Name of Cat: ");
		newCat.setName(scanner.nextLine());

		System.out.println("Enter Age of Cat: ");
		newCat.setAge(scanner.nextInt());

		System.out.println("Enter Gender of Cat: ");
		newCat.setGender(scanner.next());

		animalManager.addCat(newCat);
		System.out.println("\nAnimal " + newCat.getName() + " is now added.");
		System.out.println("Total animals in the shelter: " + animalManager.getAnimalCount() + "\n");

		// return newCat;
	}

	public void addNewParrot() {
		ParrotBean newParrot = new ParrotBean();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter Name of Parrot: ");
		newParrot.setName(scanner.nextLine());

		System.out.println("Enter Age of Parrot: ");
		newParrot.setAge(scanner.nextInt());

		System.out.println("Enter Gender of Parrot: ");
		newParrot.setGender(scanner.next());

		animalManager.addParrot(newParrot);
		System.out.println("\nAnimal " + newParrot.getName() + " is now added.");
		System.out.println("Total animals in the shelter: " + animalManager.getAnimalCount() + "\n");

		// return newParrot;
	}

	public void displayRemoveMenu() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Please enter the reference ID of the animal to remove: ");

		boolean isAnimalDeleted = animalManager.removeAnimal(scanner.nextInt());
		
		if(isAnimalDeleted) {
			System.out.println("\nThe animal is now removed.\n");
		} else {
			System.out.println("\nAnimal ID not found.\n");		
		}
	}

	public void viewAnimal() {
		List<AnimalBean> listOfAnimals = animalManager.viewAnimal();
		
		for (AnimalBean animal : listOfAnimals) {
			animal.sound();
		}
	}
	
}
