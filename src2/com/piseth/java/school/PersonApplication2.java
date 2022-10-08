package com.piseth.java.school;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.piseth.java.school.model.Person2;
import com.piseth.java.school.service.DbConnection;
import com.piseth.java.school.service.PersonService2;
import com.piseth.java.school.service.PersonServiceImpl2;

/******************************************************************************************
លំហាត់ទី៣

តាមរយៈលំហាត់ទី១ ចូរ Design Database ហើយដាក់ទិន្នន័យក្នុង table។
>> រាប់ចំនួនមនុស្សប្រុសនិងមនុស្សស្រី
>> តើអ្នកណាខ្លះចិញ្ចឹមសត្វលើសពី១ប្រភេទ?
>> អ្នកណាខ្លះចិញ្ចឹមឆ្មា?
>> តើប្រុសឬស្រីដែលចូលចិត្តចិញ្ចឹមឆ្មាជាងគេ?
>> តើមានអ្នកដែលអត់ចិញ្ចឹមសត្វដែរឬទេ?
>> មនុស្សដែលមានអាយុតិចជាងគេឈ្មោះអ្វី?​
  
******************************************************************************************/


public class PersonApplication2 {
	
	private final PersonService2 personService2 = new PersonServiceImpl2();
	DbConnection dbcon = new DbConnection();
	Connection con = dbcon.DbConnect();

	public static void main(String[] args) {
		PersonApplication2 application = new PersonApplication2();
		
		//>> រាប់ចំនួនមនុស្សប្រុសនិងមនុស្សស្រី
		application.showNumberOfPeopleByGender2();
		//>> តើអ្នកណាខ្លះចិញ្ចឹមសត្វលើសពី១ប្រភេទ?
		application.showNumberOfPetMoreThan2();
		//>> អ្នកណាខ្លះចិញ្ចឹមឆ្មា?
		application.showPeopleByPetType2();
		//>> តើប្រុសឬស្រីដែលចូលចិត្តចិញ្ចឹមឆ្មាជាងគេ?
		application.showGenderOfPeopleWhoLikeCatTheMost();
		//>> តើមានអ្នកដែលអត់ចិញ្ចឹមសត្វដែរឬទេ?
		application.showIfThereIsPersonWhoDoesNotHavePet();
		//>> មនុស្សដែលមានអាយុតិចជាងគេឈ្មោះអ្វី?
		application.displayYoungestPerson();

	}
	
//----------------------------------------------------------------------------------------------------------//
	public void showNumberOfPeopleByGender2() {	
		System.out.println("=========== Count number of people by gender ==========");
		Map<String, Integer> countNumberOfPeopleByGender = personService2.countNumberOfPeopleByGender(con);
		System.out.println(countNumberOfPeopleByGender);
	}
	
	//
	public void showNumberOfPetMoreThan2() {	
		System.out.println("\n=========== People who raise pet more than ==========");
		List<Person2> findByNumberOfPetMoreThan = personService2.findByNumberOfPetMoreThan(1, con);
		findByNumberOfPetMoreThan.forEach(p -> System.out.println(p.toString()));
	}
	
	//
	public void showPeopleByPetType2() {
		System.out.println("\n=========== People who raise CAT ==========");
		List<Person2> findByPetType = personService2.findByPetType("cat", con);
		findByPetType.forEach(p -> System.out.println(p.toString()));
		
	}
	
	//
	public void showGenderOfPeopleWhoLikeCatTheMost() {
		System.out.println("\n=========== Gender Which like cat the most ==========");
		String mostFavouriteGenderToHavePet = personService2.mostFavouriteGenderToHavePet("cat", con);
		System.out.println(mostFavouriteGenderToHavePet);
	}
	
	//
	public void showIfThereIsPersonWhoDoesNotHavePet() {
		System.out.println("\n=========== Is there any person who doesn't have pet? ==========");
		boolean hasPersonWhoDoesNotHavePet = personService2.hasPersonWhoDoesNotHavePet(con);
		System.out.println(hasPersonWhoDoesNotHavePet);
	}
	
	//
	public void displayYoungestPerson() {
		System.out.println("\n=========== The youngest person is ==========");
		Person2 youngestPerson = personService2.youngestPerson(con);
		System.out.println(youngestPerson.getName());
	}
}
