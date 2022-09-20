package com.piseth.java.school.service;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.piseth.java.school.model.Gender;
import com.piseth.java.school.model.Person;
import com.piseth.java.school.model.Pet;

public class PersonServiceImpl implements PersonService{

	@Override
	public Map<Gender, Long> countNumberOfPeopleByGender(List<Person> list) {
		return list.stream()
			.collect(Collectors.groupingBy(Person::getGender, Collectors.counting()));
	}

	@Override
	public List<Person> findByNumberOfPetMoreThan(List<Person> list, int minNumber) {
		return list.stream()
			.filter(p -> p.getPets().size() > minNumber)
			.collect(Collectors.toList());
	}

	@Override
	public List<Person> findByPetType(List<Person> list, Pet petType) {
		return list.stream()
				.filter(p -> p.getPets().contains(petType))
				.collect(Collectors.toList());
	}

	@Override
	public Gender mostFavouriteGenderToHavePet(List<Person> list, Pet petType) {
		Map<Gender, Long> mapNumberOfPeople = countNumberOfPeopleByGender(list);
		long numberOfMale = mapNumberOfPeople.get(Gender.MALE);
		long numberOfFemale = mapNumberOfPeople.get(Gender.FEMALE);
		
		List<Person> peopleWhoHaveCat = findByPetType(list, petType);
		Map<Gender, Long> mapByGenderPeopleHaveCat = countNumberOfPeopleByGender(peopleWhoHaveCat);
		
		long numberOfMaleWhoHaveCat = mapByGenderPeopleHaveCat.get(Gender.MALE);
		long numberOfFemaleWhoHaveCat = mapByGenderPeopleHaveCat.get(Gender.FEMALE);
		
		double malePercentage = (double)numberOfMaleWhoHaveCat/numberOfMale;
		double femalePercentage = (double)numberOfFemaleWhoHaveCat/numberOfFemale;
		
		return malePercentage > femalePercentage ? Gender.MALE : Gender.FEMALE;
	}

	@Override
	public boolean hasPersonWhoDoesNotHavePet(List<Person> list) {
		return list.stream()
				.anyMatch(p -> p.getPets().isEmpty());
	}

	@Override
	public Person youngestPerson(List<Person> list) {
		return list.stream()
				.min((a,b) -> a.getAge() - b.getAge())
				.get();
	}
	
//----------------------------Exercise No.2 extends from No.1----------------------------------//
	
	@Override
	public Long countPetByType(List<Person> list) {
		return list.stream()
				.flatMap(p -> p.getPets().stream())
				.distinct()
				.count();
	}

	@Override
	public Map<Integer, List<String>> findPeopleByAge(List<Person> list) {
		return list.stream()
				.collect(Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.toList())));
	}

	@Override
	public Map<Boolean, List<String>> getListOfPeople(List<Person> list) {		
		return list.stream()
				.collect(Collectors.partitioningBy(p -> p.getAge() >= 18, Collectors.mapping(Person::getName, Collectors.toList())));
	}

	@Override
	public Map<Pet, List<Person>> listPeopleByPetType(List<Person> list) {
		
		Map<Pet, List<Person>> listPet = 
				list.stream()
		.flatMap(p -> p.getPets().stream()
                .map(pets -> new AbstractMap.SimpleEntry<>(p, pets))
                )
		.collect(Collectors.groupingBy(
					AbstractMap.SimpleEntry::getValue,
					Collectors.mapping(AbstractMap.SimpleEntry::getKey, Collectors.toList())
				));
		
		return listPet;
	}

	@Override
	public List<Person> findNameAndAgeOfPeopleRaiseOnlyCat(List<Person> list) {
		return list.stream()
		.filter(p -> p.getAge() >= 19 && p.getAge() <= 21 && p.getGender() == Gender.FEMALE && p.getPets().contains(Pet.CAT) && !p.getPets().contains(Pet.DOG))
		.collect(Collectors.toList());

	}
	
}
