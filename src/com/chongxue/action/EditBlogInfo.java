package com.chongxue.action;



import java.util.Map;





import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.chongxue.po.BlogInfo;
import com.chongxue.service.BlogInfoService;



public class EditBlogInfo extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String blogtitle;

	private String idiograph;

	private BlogInfoService blogInfoService;



	public BlogInfoService getBlogInfoService() {

		return blogInfoService;

	}



	public void setBlogInfoService(BlogInfoService blogInfoService) {

		this.blogInfoService = blogInfoService;

	}



	public String getBlogtitle() {

		return blogtitle;

	}



	public void setBlogtitle(String blogtitle) {

		this.blogtitle = blogtitle;

	}



	public String getIdiograph() {

		return idiograph;

	}



	public void setIdiograph(String idiograph) {

		this.idiograph = idiograph;

	}



	@SuppressWarnings("static-access")
	public String execute() throws Exception {

//		//���request

//		HttpServletRequest request = ServletActionContext.getRequest();

//		//���session

//		HttpSession session =request.getSession();

//		//���username

//		String username = (String) session.getAttribute("username");

		

		@SuppressWarnings("rawtypes")
		Map session = ActionContext.getContext().getSession();

		String username = (String) session.get("username");

		

		BlogInfo blogInfo = new BlogInfo();

		//�����û���

		blogInfo.setUsername(username);

		//���ò��ͱ���

		blogInfo.setBlogtitle(blogtitle);

		//���ø���ǩ��

		blogInfo.setIdiograph(idiograph);

		//����ҵ���߼�������������

		blogInfoService.setBlogInfo(blogInfo);

		

		return this.SUCCESS;

	}



}

