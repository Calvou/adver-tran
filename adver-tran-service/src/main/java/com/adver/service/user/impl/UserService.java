package com.adver.service.user.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.adver.dao.entity.User;
import com.adver.dao.repository.user.UserRepository;
import com.adver.service.user.IUserService;

@Service
public class UserService implements IUserService{

	@Resource
	private UserRepository userRepository;
	
	@Override
	public int saveUser() throws Exception {
		User user = new User();
		user.setName(("3432"+Math.random()).substring(0, 10));
		user = userRepository.save(user);		
		return user.getId();
	}

	
	
}
