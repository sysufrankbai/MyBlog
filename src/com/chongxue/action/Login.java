package com.chongxue.action;



import java.util.Map;






import javax.servlet.http.HttpServletRequest;






import org.apache.struts2.ServletActionContext;






import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.chongxue.po.User;
import com.chongxue.service.UserService;



public class Login extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username;

	private String password;

	private UserService userService;



	public UserService getUserService() {

		return userService;

	}



	public void setUserService(UserService userService) {

		this.userService = userService;

	}



	public String getUsername() {

		return username;

	}



	public void setUsername(String username) {

		this.username = username;

	}



	public String getPassword() {

		return password;

	}



	public void setPassword(String password) {

		this.password = password;

	}



	@SuppressWarnings("unchecked")
	public String execute() throws Exception {

		User user = new User();

		user.setUsername(username);

		user.setPassword(password);

		//获得request

		HttpServletRequest request = ServletActionContext.getRequest();

		if(userService.loginUser(user)) {

			request.setAttribute("url", "user/getBlogInfo.action");

			request.setAttribute("info", "登陆成功");

			//将username保存到session范围中

//			HttpSession session = request.getSession();

			@SuppressWarnings("rawtypes")
			Map session = ActionContext.getContext().getSession();

//			session.setAttribute("username", username);	

			session.put("username", username);

			return SUCCESS;

		} else {

			request.setAttribute("url", "login.jsp");

			request.setAttribute("info", "登陆失败");

			return ERROR;

		}

	}



}

