package com.chongxue.action;



import java.io.File;
import java.util.Map;




import javax.servlet.http.HttpServletRequest;




import org.apache.struts2.ServletActionContext;




import com.opensymphony.xwork2.ActionSupport;



public class ShowPhoto  extends ActionSupport{



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String execute() throws Exception {

		//���username

		@SuppressWarnings("rawtypes")
		Map session = ServletActionContext.getContext().getSession();

		String username = (String) session.get("username");

		

		//�����ļ�Ŀ¼

		String photoPath = 

			ServletActionContext.getServletContext().getRealPath("/user/photo/" + username);

		//ʹ��File��װ

		File fphotoPath = new File(photoPath);

		//������Ŀ¼������ͼƬ�ļ�

		String[] photoList = fphotoPath.list();

		//��ͼƬ�б����õ�request��Χ

		HttpServletRequest request = ServletActionContext.getRequest();

		request.setAttribute("photoList", photoList);

		return super.execute();

	}



}

