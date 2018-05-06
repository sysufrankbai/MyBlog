package com.chongxue.dao;



import java.util.Date;
import java.util.List;




import com.chongxue.po.Dianjiliang;



public interface DianjiliangDAO {

	

	//返回该文章，该IP，该时间的访问记录

	@SuppressWarnings("rawtypes")
	public List queryByAId(int AId,String IP,Date time);

	

	//添加访问记录

	public void addJilu(Dianjiliang dianjiliang);

}

