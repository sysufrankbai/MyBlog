package com.chongxue.dao;



import com.chongxue.po.BlogInfo;



public interface BlogInfoDAO {

	//���ø��Ի�����

	public void save(BlogInfo info);

	//���

	public BlogInfo get(String username);

}

