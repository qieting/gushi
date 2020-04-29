package com.example.gushi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


@Component
public interface PeopleRepository extends JpaRepository<People, Integer> {
	
	People findByPhoneNumber(String phone_number);

	

}