package net.softsociety.spring3.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.ui.Model;

import net.softsociety.spring3.domain.Person;

/**
 * Mybatis의 매퍼 인터페이스
 */
@Mapper
public interface PersonDAO {
	//저장
	public int insertPerson(Person p);
	//1명 삭제
	public int deletePerson(String idnum);
	//이름 삭제
	public int delete2Person(String name);
	
	public Person selectOne(String idnum);
}
