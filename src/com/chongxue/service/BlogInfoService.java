package com.chongxue.service;



import com.chongxue.po.BlogInfo;



public interface BlogInfoService {

	//���ò��͸��Ի�����

	public void setBlogInfo(BlogInfo blogInfo);

	

	//��ò��͸��Ի�����

	public BlogInfo getBlogInfo(String name);

}

