package com.chongxue.service;



import com.chongxue.po.User;



public interface UserService {

	//�û�ע��

	public boolean registerUser(User user);

	

	//�û���½

	public boolean loginUser(User user);

}

