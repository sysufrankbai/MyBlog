package com.chongxue.dao;



import java.util.List;



import com.chongxue.fenye.Page;

import com.chongxue.po.Critique;



public interface CritiqueDAO {

	//�������

	public void addCritique(Critique critique);

	

	//���ָ�����µ�������

	public int queryCritiqueCount(int AId);

	

	//����Page����ѯָ�����µ�����

	public List<Critique> queryByPage(int AId,Page page);

}

