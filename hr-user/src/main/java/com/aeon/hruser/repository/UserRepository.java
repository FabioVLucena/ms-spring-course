package com.aeon.hruser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aeon.hruser.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
	
}
