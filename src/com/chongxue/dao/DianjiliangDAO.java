package com.chongxue.dao;



import java.util.Date;
import java.util.List;




import com.chongxue.po.Dianjiliang;



public interface DianjiliangDAO {

	

	//���ظ����£���IP����ʱ��ķ��ʼ�¼

	@SuppressWarnings("rawtypes")
	public List queryByAId(int AId,String IP,Date time);

	

	//��ӷ��ʼ�¼

	public void addJilu(Dianjiliang dianjiliang);

}

