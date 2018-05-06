package com.chongxue.service;



import java.util.List;



import com.chongxue.fenye.Page;

import com.chongxue.fenye.Result;

import com.chongxue.po.Article;



public interface ArticleService {

	//�������µı���

	public void addArticle(Article article);

	

	//ȡ���û����е�����

	public List<Article> showUserAllArticle(String username);

	

	//��ҳ��ʾ�û�����

	public Result showUserArticleByPage(String username,Page page);

	

	//��ҳ��ʾȫ������

	public Result showArticleByPage(Page page);

	

	//��ʾ����

	public Article showArticle(int id);

	

	//���������

	public int getCritiqueCount(int AId);

}

