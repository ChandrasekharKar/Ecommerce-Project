package com.ecommerce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecommerce.dao.AdminDaoImp;
import com.ecommerce.dao.CustomerDaoImp;
import com.ecommerce.dao.ExecutiveDaoImp;
import com.ecommerce.dao.StoreDaoImp;
import com.ecommerce.pojo.Admin;
import com.ecommerce.pojo.Customer;
import com.ecommerce.pojo.Executive;
import com.ecommerce.pojo.Store;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session=request.getSession();
		session.setAttribute("message","Logged out...");
        response.sendRedirect("index.jsp");
        session.invalidate();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HttpSession session=request.getSession();
		String action =request.getParameter("action");
		
	    if(action.equals("adminLogin"))
	    {
	    	String email=request.getParameter("email");
	    	String password =request.getParameter("password");
	    	
	    	Admin admin=new AdminDaoImp().login(email, password);
	    	if(admin != null)
	    	{
	    		session.setAttribute("message","Admin Login Successfully..!");
	    		session.setAttribute("activeUserType",admin.getUsertype());
	    		session.setAttribute("active-user", admin);
		        response.sendRedirect("admin.jsp");
	    	}
	    	
	    	else
	    	{
	    		session.setAttribute("message","Failed to Login Admin");
		        response.sendRedirect("adminLogin.jsp");
	    	}	
	    }
	    
	    if(action.equals("customerLogin"))
	    {
	    	String email=request.getParameter("email");
	    	String password =request.getParameter("password");
	    	
	    	Customer customer=new CustomerDaoImp().login(email, password);
	    	if(customer != null)
	    	{
	    	    int visitorDetailCountInTable =	new CustomerDaoImp().getCountOfVisitorDetail();
	    	    if(visitorDetailCountInTable == 1)
	    	    {
	    	    	int count = new CustomerDaoImp().getVisitorCounter();
	    	        count++;
	    	        new CustomerDaoImp().updateVisitorCounter(1, count);
	    	    }
	    	    
	    	    else
	    	    {
	    	    	new CustomerDaoImp().addVisitorCounter();
	    	    }
	    		session.setAttribute("message"," Login Successfully..!");
	    		session.setAttribute("activeUserType",customer.getUsertype());
	    		session.setAttribute("active-user", customer);
		        response.sendRedirect("index.jsp");
	    	}
	    	
	    	else
	    	{
	    		session.setAttribute("message","Failed to Login as Customer");
		        response.sendRedirect("customerLogin.jsp");
	    	}	
	    }
	    
	    if(action.equals("executiveLogin"))
	    {
	    	String email=request.getParameter("email");
	    	String password =request.getParameter("password");
	    	
	    	Executive executive=new ExecutiveDaoImp().login(email, password);
	    	if(executive != null)
	    	{
	    		session.setAttribute("message"," Login Successfully..!");
	    		session.setAttribute("activeUserType",executive.getUsertype());
	    		session.setAttribute("active-user", executive);
		        response.sendRedirect("index.jsp");
	    	}
	    	
	    	else
	    	{
	    		session.setAttribute("message","Failed to Login as Executive");
		        response.sendRedirect("index.jsp");
	    	}	
	    }
	    
	    if(action.equals("storeOwnerLogin"))
	    {
	    	String email=request.getParameter("email");
	    	String password =request.getParameter("password");
	    	
	    	Store store=new StoreDaoImp().login(email, password);
	    	if(store != null)
	    	{
	    		session.setAttribute("message"," Login Successfully..!");
	    		session.setAttribute("activeUserType",store.getUsertype());
	    		session.setAttribute("active-user", store);
		        response.sendRedirect("index.jsp");
	    	}
	    	
	    	else
	    	{
	    		session.setAttribute("message","Failed to Login Admin");
		        response.sendRedirect("index.jsp");
	    	}	
	    }
		
		
	}
		
		

}
