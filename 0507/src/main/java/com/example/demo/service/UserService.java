package com.example.demo.service;


import java.io.Console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

import io.micrometer.common.util.StringUtils;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public String Login(User user) {
		
		if(StringUtils.isEmpty(user.getUserid())) {
			
			return "帳號不能為空";
		}
		
		if(StringUtils.isEmpty(user.getUserpassword())) {
			
			return "密碼不能為空";
		}
		
		User Cuser;
		Cuser = userRepository.findByUserid(user.getUserid());
		if(Cuser==null) {
			
			return "找無使用者，請先註冊。";
		}
		String Lpw = user.getUserpassword();
		String Cpw = Cuser.getUserpassword();
		if(Lpw.equals(Cpw)) {
			return Cuser.getAdmin().toString();
		}
		
		return "帳號或密碼錯誤";
		
	}
}
