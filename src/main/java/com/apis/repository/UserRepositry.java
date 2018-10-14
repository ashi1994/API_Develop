package com.apis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apis.model.UserDBMapping;


public interface UserRepositry extends JpaRepository<UserDBMapping, Integer>{


	


}
