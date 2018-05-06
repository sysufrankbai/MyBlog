package com.chongxue.action;



import java.util.Map;





import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.chongxue.po.BlogInfo;
import com.chongxue.service.BlogInfoService;



public class GetBlogInfo extends ActionSupport {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BlogInfoService blogInfoService;



	public BlogInfoService getBlogInfoService() {

		return blogInfoService;

	}



	public void setBlogInfoService(BlogInfoService blogInfoService) {

		this.blogInfoService = blogInfoService;

	}

	

	@SuppressWarnings({ "unchecked", "static-access" })
	public String execute() throws Exception {

		//获得usrname

		@SuppressWarnings("rawtypes")
		Map session = ActionContext.getContext().getSession();

		String username = (String) session.get("username");

		

		//通过业务逻辑组件来查询

		BlogInfo bloginfo  = blogInfoService.getBlogInfo(username);

		

		if(bloginfo != null) {

			session.put("blogtitle", bloginfo.getBlogtitle());

			session.put("idiograph", bloginfo.getIdiograph());

		}

		return this.SUCCESS;

	}

}

