package net.softsociety.spring3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.softsociety.spring3.dao.PersonDAO;
import net.softsociety.spring3.domain.Person;

@Service
public class PersonService {
	@Autowired
	PersonDAO dao;
	
	public int insertPerson(Person p) {
		int n = dao.insertPerson(p);
		return n;
	}
}
