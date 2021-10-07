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

import com.ecommerce.dao.StoreDaoImp;
import com.ecommerce.pojo.Store;

/**
 * Servlet implementation class StoreServlet
 */
@WebServlet("/StoreServlet")
public class StoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreServlet() {
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
			int storeId = Integer.parseInt(request.getParameter("storeid"));
			List<Store> listOfStore =new ArrayList<>();
			Store s =new StoreDaoImp().getStoreById(storeId);
			listOfStore.add(s);
			
			rd = request.getRequestDispatcher("totalstore.jsp");
			request.setAttribute("stores",listOfStore );
			rd.forward(request, response);
			
		}
		
		else if(action.equals("searchByName")) {
			String storeName = request.getParameter("storename");
			List<Store> listOfStore =new ArrayList<>();
			listOfStore =new StoreDaoImp().getStoreByName(storeName);
			
			rd = request.getRequestDispatcher("totalstore.jsp");
			request.setAttribute("stores",listOfStore );
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
