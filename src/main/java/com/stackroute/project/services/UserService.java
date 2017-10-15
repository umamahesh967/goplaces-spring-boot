package com.stackroute.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stackroute.project.domains.User;
import com.stackroute.project.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userrepository;
	
	
	public Boolean add(User user) {
		
		if(user.getPassword()==null || user.getPassword()=="") {
			return false;
		}
		
		userrepository.save(user);
		return true;
	}
	
	public Boolean check(User user){
		
		if((user.getPassword()).equals(userrepository.findOne(user.getUsername()).getPassword() )){
			
			return true;
		}
	
		return false;
		
	}

}
