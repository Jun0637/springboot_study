package net.softsociety.spring3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

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

	public int deletePerson(String idnum) {
		int n = dao.deletePerson(idnum);
		return n;
	}
	
	public int delete2Person(String name) {
		int n = dao.delete2Person(name);
		return n;
	}

	public Person selectOne(String idnum) {
		Person person = dao.selectOne(idnum);
		return person;
	}
}
