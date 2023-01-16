package net.softsociety.spring3.dao;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.spring3.domain.Person;

/**
 * Mybatis의 매퍼 인터페이스
 */
@Mapper
public interface PersonDAO {
	//저장
	public int insertPerson(Person p);
}
