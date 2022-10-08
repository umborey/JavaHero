package com.piseth.java.school.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.piseth.java.school.model.Person2;

public class PersonServiceImpl2 implements PersonService2{
	
	PreparedStatement pstm;
	ResultSet rs;
	
	@Override
	public Map<String, Integer> countNumberOfPeopleByGender(Connection conn) {		
		try {
			pstm = conn.prepareStatement("SELECT gender, count(*) FROM persons GROUP BY gender");
			rs = pstm.executeQuery();
			Map<String, Integer> mapGender = new LinkedHashMap<>();
			while (rs.next()) {
				mapGender.putIfAbsent(rs.getString(1), rs.getInt(2));
			}
			return mapGender;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public List<Person2> findByNumberOfPetMoreThan(int minNum, Connection conn) {
		try {
			pstm = conn.prepareStatement("SELECT * FROM persons WHERE CARDINALITY(pet) > ?");
			pstm.setInt(1, minNum);
			rs = pstm.executeQuery();
			ArrayList<Person2> personList = new ArrayList<>();
			while (rs.next()) {
				Person2 person = new Person2(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getArray(4));
				personList.add(person);
			}
			return personList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return null;
		
	}

	@Override
	public List<Person2> findByPetType(String pet, Connection conn) {
		try {
			pstm = conn.prepareStatement("SELECT * FROM persons WHERE ? ILIKE ANY(pet)");
			pstm.setString(1, pet);
			rs = pstm.executeQuery();
			ArrayList<Person2> personList = new ArrayList<>();
			while (rs.next()) {
				Person2 person = new Person2(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getArray(4));
				personList.add(person);
			}			
			return personList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return null;
		
	}

	@Override
	public String mostFavouriteGenderToHavePet(String pet, Connection conn) {
		try {
			pstm = conn.prepareStatement("SELECT a.gender FROM ("
					+ "SELECT gender, count(*) total_person FROM persons "
					+ "WHERE ? ILIKE ANY(pet) "
					+ "GROUP BY gender) a "
					+ "ORDER BY total_person DESC "
					+ "LIMIT 1");
			pstm.setString(1, pet);
			rs = pstm.executeQuery();
			String gender = null;
			if (rs.next()) {
				gender = rs.getString(1);
			}			
			return gender;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}

	@Override
	public boolean hasPersonWhoDoesNotHavePet(Connection conn) {
		try {
			pstm = conn.prepareStatement("SELECT EXISTS (SELECT * FROM persons WHERE CARDINALITY(pet) = 0)");
			rs = pstm.executeQuery();
			boolean noPet = false;
			if (rs.next()) {
				noPet = rs.getBoolean(1);
			}			
			return noPet;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Person2 youngestPerson(Connection conn) {
		try {
			pstm = conn.prepareStatement("SELECT * FROM persons ORDER BY age ASC LIMIT 1");
			rs = pstm.executeQuery();
			Person2 youngest = null;
			if (rs.next()) {
				youngest = new Person2(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getArray(4));
			}			
			return youngest;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
