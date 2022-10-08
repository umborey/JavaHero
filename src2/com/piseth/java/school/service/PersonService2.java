package com.piseth.java.school.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.piseth.java.school.model.Person2;

public interface PersonService2 {
	//-------------------------------------Exercise No.3-------------------------------------------//
		Map<String, Integer> countNumberOfPeopleByGender(Connection conn);
		
		List<Person2> findByNumberOfPetMoreThan(int minNum, Connection conn);

		List<Person2> findByPetType(String pet, Connection conn);

		String mostFavouriteGenderToHavePet(String pet, Connection conn);

		boolean hasPersonWhoDoesNotHavePet(Connection conn);

		Person2 youngestPerson(Connection conn);
}
