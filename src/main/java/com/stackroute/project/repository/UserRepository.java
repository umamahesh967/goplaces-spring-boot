package com.stackroute.project.repository;

import org.springframework.data.repository.CrudRepository;
import com.stackroute.project.domains.User;

public interface UserRepository extends CrudRepository<User, String>{
	
	

}

