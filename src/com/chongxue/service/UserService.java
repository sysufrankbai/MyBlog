package com.chongxue.service;



import com.chongxue.po.User;



public interface UserService {

	//用户注册

	public boolean registerUser(User user);

	

	//用户登陆

	public boolean loginUser(User user);

}

