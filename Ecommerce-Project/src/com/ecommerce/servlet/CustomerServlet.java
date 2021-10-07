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

import com.ecommerce.dao.CustomerDaoImp;
import com.ecommerce.pojo.Customer;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
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
			int customerId = Integer.parseInt(request.getParameter("customerid"));
			List<Customer> listOfCustomer =new ArrayList<>();
			Customer c =new CustomerDaoImp().getCustomerById(customerId);
			listOfCustomer.add(c);
			
			rd = request.getRequestDispatcher("totalcustomer.jsp");
			request.setAttribute("customers",listOfCustomer );
			rd.forward(request, response);
			
		}
		
		else if(action.equals("searchByName")) {
			String customerName = request.getParameter("customername");
			List<Customer> listOfCustomer =new ArrayList<>();
			listOfCustomer =new CustomerDaoImp().getCustomerByName(customerName);
			
			rd = request.getRequestDispatcher("totalcustomer.jsp");
			request.setAttribute("customers",listOfCustomer );
			rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
