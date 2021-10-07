package com.ecommerce.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.dao.ExecutiveDaoImp;
import com.ecommerce.pojo.Executive;

/**
 * Servlet implementation class ExecutiveServlet
 */
@WebServlet("/ExecutiveServlet")
public class ExecutiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExecutiveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String action= request.getParameter("action");
		RequestDispatcher rd=null;
		
		if(action !=null &&  action.equals("searchByID")) {
			int executiveId = Integer.parseInt(request.getParameter("executiveid"));
			List<Executive> listOfExecutive =new ArrayList<>();
			Executive e =new ExecutiveDaoImp().getExecutiveById(executiveId);
			listOfExecutive.add(e);
			
			rd = request.getRequestDispatcher("totalexecutive.jsp");
			request.setAttribute("executives",listOfExecutive );
			rd.forward(request, response);
			
		}
		
		else if(action.equals("searchByName")) {
			String executiveName = request.getParameter("executivename");
			List<Executive> listOfExecutive =new ArrayList<>();
			listOfExecutive =new ExecutiveDaoImp().getExecutiveByName(executiveName);
			
			rd = request.getRequestDispatcher("totalexecutive.jsp");
			request.setAttribute("executives",listOfExecutive );
			rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
