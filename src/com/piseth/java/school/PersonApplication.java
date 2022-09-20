package com.piseth.java.school;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.piseth.java.school.model.Gender;
import com.piseth.java.school.model.Person;
import com.piseth.java.school.model.Pet;
import com.piseth.java.school.service.PersonService;
import com.piseth.java.school.service.PersonServiceImpl;

public class PersonApplication {
	
	private final PersonService personService = new PersonServiceImpl();
	
	private final List<Person> LIST_OF_PEOPLE = List.of(
			new Person("Dara", Gender.MALE, 18, List.of(Pet.CAT)),
			new Person("Thida", Gender.FEMALE, 17, List.of(Pet.DOG)),
			new Person("Dalin", Gender.FEMALE, 19, List.of(Pet.DOG, Pet.CAT)),
			new Person("Veasna", Gender.MALE, 16, List.of()),
			new Person("Sopheak", Gender.FEMALE, 17, List.of(Pet.FISH)),
			new Person("Vannda", Gender.MALE, 21, List.of(Pet.BIRD)),
			new Person("Nary", Gender.FEMALE, 23, List.of(Pet.DOG, Pet.BIRD, Pet.CAT)),
			new Person("Pisey", Gender.FEMALE, 19, List.of(Pet.CAT, Pet.RABBIT)),
			new Person("Sovann", Gender.MALE, 18, List.of(Pet.CAT)),
			new Person("Vannary", Gender.FEMALE, 20, List.of(Pet.FISH))
			
			);

	public static void main(String[] args) {
		PersonApplication application = new PersonApplication();
		//Count number of people by gender
		application.showNumberOfPeopleByGender();
		//People Who Have Pet More Than 1 Type
		application.peopleWhoHavePetMoreThanOneType();
		//People Who have cat
		application.peopleWhoHaveCat();
		//Gender Which like cat the most
		application.showGenderOfPeopleWhoLikeCatTheMost();
		//Is there any person who doesn't have pet? 
		application.showIfThereIsPersonWhoDoesNotHavePet();
		//The youngest person is
		application.displayYoungestPerson();
		//
		application.displayAmountOfPetType();
		//
		application.displayPeopleByAge();
		//
		application.displayListOfVottingStatus();
		//
		application.displayListOfPeopleByPetType();
		//
		application.displayNameAndAge();

	}
	
	// Count number of people by gender
	public void showNumberOfPeopleByGender() {
		System.out.println("=========== Count number of people by gender ==========");
		Map<Gender, Long> countNumberOfPeopleByGender = personService.countNumberOfPeopleByGender(LIST_OF_PEOPLE);
		System.out.println(countNumberOfPeopleByGender);
	}
	
	public void peopleWhoHavePetMoreThanOneType() {
		System.out.println("\n=========== People Who Have Pet More Than 1 Type ==========");
		List<Person> listPeople = personService.findByNumberOfPetMoreThan(LIST_OF_PEOPLE, 1);
		listPeople.forEach(p -> System.out.println(p.getName()));
	}
	
	public void peopleWhoHaveCat() {
		System.out.println("\n=========== People Who have cat ==========");
		List<Person> peopleHaveCat = personService.findByPetType(LIST_OF_PEOPLE, Pet.CAT);
		peopleHaveCat.forEach(System.out::println);
		
	}
	
	public void showGenderOfPeopleWhoLikeCatTheMost() {
		System.out.println("\n=========== Gender Which like cat the most ==========");
		Gender genderWhichLikeCatTheMost = personService.mostFavouriteGenderToHavePet(LIST_OF_PEOPLE, Pet.CAT);
		System.out.println(genderWhichLikeCatTheMost);
	}
	
	public void showIfThereIsPersonWhoDoesNotHavePet() {
		System.out.println("\n=========== Is there any person who doesn't have pet? ==========");
		boolean hasPersonWhoDoesNotHavePet = personService.hasPersonWhoDoesNotHavePet(LIST_OF_PEOPLE);
		System.out.println(hasPersonWhoDoesNotHavePet);
	}
	
	public void displayYoungestPerson() {
		System.out.println("\n=========== The youngest person is ==========");
		Person youngestPerson = personService.youngestPerson(LIST_OF_PEOPLE);
		System.out.println(youngestPerson.getName());
	}
	
	
//----------------------------Exercise No.2 extends from No.1----------------------------------//
	public void displayAmountOfPetType() {
		System.out.println("\n=========== How many pet type in the village? ===========");
		Long countPetType = personService.countPetByType(LIST_OF_PEOPLE);
		System.out.println(countPetType);
	}
	
	public void displayPeopleByAge() {
		System.out.println("\n=========== List people by age ===========");
		Map<Integer, List<String>> listPeopleByAge = personService.findPeopleByAge(LIST_OF_PEOPLE);
		listPeopleByAge.forEach((age, p) -> System.out.println("Age " + age +": " +p));
	}
	
	public void displayListOfVottingStatus() {
		System.out.println("\n=========== List of votting status ===========");
		Map<Boolean, List<String>> listOfVoteStatus = personService.getListOfPeople(LIST_OF_PEOPLE);
		listOfVoteStatus.forEach((vote, p) -> {
				String voteStatus;
				if(vote == true) {voteStatus = "Can Vote";} else {voteStatus = "Cannot Vote";}
				System.out.println(voteStatus + ":\t" +p);
			});
	}
	
	public void displayListOfPeopleByPetType() {
		System.out.println("\n=========== List of people by pet type ===========");
		Map<Pet, List<Person>> listPeopleByPetType = personService.listPeopleByPetType(LIST_OF_PEOPLE);
		listPeopleByPetType.forEach((pet, person) -> {
			List<String> pName = person.stream().map(p -> p.getName()).collect(Collectors.toList());
			System.out.println(pet + ": " + pName);
		});
		 
	}
	
	public void displayNameAndAge() {
		System.out.println("\n=========== List of female people who raise Cat but not Dog, Age between 19 and 21===========");
		List<Person> listOfPeopleRaiseCatNotDog = personService.findNameAndAgeOfPeopleRaiseOnlyCat(LIST_OF_PEOPLE);
		listOfPeopleRaiseCatNotDog.forEach(p -> System.out.println("Name: " + p.getName() + ", Age: " + p.getAge()));
	}

}
