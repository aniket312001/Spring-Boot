package com.jpa.test.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jpa.test.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	public List<User> findByName(String name);
	public List<User> findByNameAndCity(String name,String city);
	public List<User> findByNameStartingWith(String prefix);
	public List<User> findByNameEndingWith(String suffix);
	public List<User> findByNameContaining(String words);
	public List<User> findByIdGreaterThanEqual(int x);
	
	@Query("select u from User as u")
	public List<User> getAllUser();
 
	@Query("select u from User as u WHERE u.name =:name ")
	public List<User> getUserByName(String name);
}
	