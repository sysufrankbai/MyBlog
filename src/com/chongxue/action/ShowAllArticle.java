package com.chongxue.action;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.chongxue.fenye.Page;
import com.chongxue.fenye.Result;
import com.chongxue.po.Article;
import com.chongxue.service.ArticleService;
import com.opensymphony.xwork2.ActionSupport;



public class ShowAllArticle extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArticleService articleService;

	private int currentPage;



	public int getCurrentPage() {

		return currentPage;

	}

	public void setCurrentPage(int currentPage) {

		this.currentPage = currentPage;

	}

	public ArticleService getArticleService() {

		return articleService;

	}

	public void setArticleService(ArticleService articleService) {

		this.articleService = articleService;

	}

	

	@SuppressWarnings({ "rawtypes", "unchecked", "static-access" })
	public String execute() throws Exception {

		//通过调用业务逻辑组件来完成查询

		Page page = new Page();

		page.setCurrentPage(this.getCurrentPage());

		page.setEveryPage(10);

		

		Result result = articleService.showArticleByPage(page);

		page = result.getPage();

		List<Article> all = result.getList();

		

		List critiqueCounts = new ArrayList();

		for(Article article : all) {

			critiqueCounts.add(articleService.getCritiqueCount(article.getId()));

		}

		

		//把查询到的结果保存在一个范围，request

		HttpServletRequest request = ServletActionContext.getRequest();

		request.setAttribute("all", all);

		request.setAttribute("page", page);

		request.setAttribute("critiqueCounts",critiqueCounts);

		return this.SUCCESS;

	}

	

}

