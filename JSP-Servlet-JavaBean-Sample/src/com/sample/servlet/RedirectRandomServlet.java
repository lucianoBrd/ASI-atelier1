package com.sample.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sample.controler.PoneyDao;
import com.sample.model.PoneyBean;

@WebServlet("/random")
public class RedirectRandomServlet extends HttpServlet {
	private static final String RPONEY = "rponey";
	private static final String NDAO = "DAO";
	private static final long serialVersionUID = 1L;
	private PoneyDao dao;
       
    public RedirectRandomServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getDao();
		PoneyBean randPoney=this.dao.getRandomPoney();
		HttpSession currentSession = request.getSession();
		currentSession.setAttribute(RPONEY, randPoney);
		this.getServletContext().getRequestDispatcher( "/WEB-INF/displayRandom.jsp" ).forward( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		//DO NOTHING
	}
	
	public void getDao(){
		if(this.getServletContext().getAttribute(NDAO)!=null){
			this.dao=(PoneyDao)this.getServletContext().getAttribute(NDAO);
		}else{
			this.dao=new PoneyDao();
			this.getServletContext().setAttribute(NDAO,this.dao);
		}
	}
}
