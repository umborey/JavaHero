package com.piseth.java.school.service;

import java.util.List;
import java.util.Map;

import com.piseth.java.school.model.Gender;
import com.piseth.java.school.model.Person;
import com.piseth.java.school.model.Pet;

public interface PersonService {
	Map<Gender, Long> countNumberOfPeopleByGender(List<Person> list);

	List<Person> findByNumberOfPetMoreThan(List<Person> list, int minNumber);

	List<Person> findByPetType(List<Person> list, Pet petType);

	Gender mostFavouriteGenderToHavePet(List<Person> list, Pet petType);

	boolean hasPersonWhoDoesNotHavePet(List<Person> list);

	Person youngestPerson(List<Person> list);
	
//----------------------------Exercise No.2 extends from No.1----------------------------------//
	Long countPetByType(List<Person> list);
	
	Map<Integer, List<String>> findPeopleByAge(List<Person> list);
	
	Map<Boolean, List<String>> getListOfPeople(List<Person> list);
	
	Map<Pet, List<Person>> listPeopleByPetType(List<Person> list);
	
	List<Person> findNameAndAgeOfPeopleRaiseOnlyCat(List<Person> list);

}
