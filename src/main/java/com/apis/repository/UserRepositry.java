package com.apis.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.apis.model.UserDBMapping;


public interface UserRepositry extends JpaRepository<UserDBMapping, Integer>{


	


}
