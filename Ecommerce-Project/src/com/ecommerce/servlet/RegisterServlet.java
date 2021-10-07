package com.ecommerce.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.ecommerce.dao.AdminDaoImp;
import com.ecommerce.dao.CustomerDaoImp;
import com.ecommerce.dao.ExecutiveDaoImp;
import com.ecommerce.dao.StoreDaoImp;
import com.ecommerce.dao.WishlistDaoImp;
import com.ecommerce.pojo.Admin;
import com.ecommerce.pojo.Customer;
import com.ecommerce.pojo.Executive;
import com.ecommerce.pojo.Store;
import com.ecommerce.pojo.Wishlist;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
@MultipartConfig
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		Customer customer = (Customer)session.getAttribute("active-user");
	    String sId = request.getParameter("storeId");
	    int storeId =Integer.parseInt(sId);
	    Wishlist wishlist =new Wishlist();
	    wishlist.setCustomerId(customer.getId());
	    wishlist.setStoreId(storeId);
	   
		boolean flag = new WishlistDaoImp().addToWishlist(wishlist);
		if(flag == true)
    	{
    		session.setAttribute("message","Store Added to Wishlist..!");
	        response.sendRedirect("adminLogin.jsp");
    	}
    	
    	else
    	{
    		session.setAttribute("message","Failed to add store to wishlist.");
	        response.sendRedirect("adminRegister.jsp");
    	}	
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		HttpSession session=request.getSession();
		String action =request.getParameter("action");
		
	    if(action.equals("adminRegister"))
	    {
	    	String email=request.getParameter("email");
	    	String password =request.getParameter("password");
	    	
	    	Admin admin=new Admin();
	    	admin.setEmail(email);
	    	admin.setPassword(password);
	    	admin.setUsertype("admin");
	    	
	    	boolean flag=new AdminDaoImp().registerAdmin(admin);
	    	if(flag == true)
	    	{
	    		session.setAttribute("message","Admin Registered Successfully..!");
		        response.sendRedirect("adminLogin.jsp");
	    	}
	    	
	    	else
	    	{
	    		session.setAttribute("message","Failed to Register Admin");
		        response.sendRedirect("adminRegister.jsp");
	    	}	
	    }
	    
	    if(action.equals("customerRegister"))
	    {
	    	String firstname=request.getParameter("firstname");
	    	String lastname=request.getParameter("lastname");
	    	String contact=request.getParameter("contact");
	    	String email=request.getParameter("email");
	    	String password=request.getParameter("password");
	    	
	    	Customer customer=new Customer();
	    	customer.setContact(contact);
	    	customer.setEmail(email);
	    	customer.setFirstname(firstname);
	    	customer.setLastname(lastname);
	    	customer.setPassword(password);
	    	customer.setUsertype("customer");
	    	
	    	boolean flag=new CustomerDaoImp().registerCustomer(customer);
	    	
	    	if(flag == true)
	    	{
	    		session.setAttribute("message",firstname+" Registered Successfully as customer..!");
		        response.sendRedirect("customerLogin.jsp");
	    	}
	    	
	    	else
	    	{
	    		session.setAttribute("message","Failed to Register Admin");
		        response.sendRedirect("customerRegister.jsp");
	    	}	
	    	  	
	    }
	    
	    if(action.equals("executiveRegister"))
	    {
	    	String firstname=request.getParameter("firstname");
	    	String lastname=request.getParameter("lastname");
	    	String contact=request.getParameter("contact");
	    	String email=request.getParameter("email");
	    	String password=request.getParameter("password");
	    	
	    	Executive executive=new Executive();
	    	executive.setContact(contact);
	    	executive.setEmail(email);
	    	executive.setFirstname(firstname);
	    	executive.setLastname(lastname);
	    	executive.setPassword(password);
	    	executive.setUsertype("executive");
	    	
	    	boolean flag=new ExecutiveDaoImp().registerExecutive(executive);
	    	
	    	if(flag == true)
	    	{
	    		session.setAttribute("message",firstname+" Registered Successfully as executive..!");
		        response.sendRedirect("executiveLogin.jsp");
	    	}
	    	
	    	else
	    	{
	    		session.setAttribute("message","Failed to Register executive");
		        response.sendRedirect("executiveRegister.jsp");
	    	}	
	    		
	    }
	    
	    if(action.equals("storeRegister"))
	    {
	    	Executive executive =(Executive)session.getAttribute("active-user");
	    	String storename=request.getParameter("storename");
	    	String location=request.getParameter("location");
	    	String ownername=request.getParameter("ownername");
	    	String email=request.getParameter("email");
	    	String password=request.getParameter("password");
	    	String contact=request.getParameter("contact");
	    	Part part=request.getPart("storePic");
			
			String fileName=part.getSubmittedFileName();
			
			String uploadPath="C:\\Users\\pc\\OneDrive\\Desktop\\Mapper\\WebContent\\storeimages"+fileName;

			try
			{
			FileOutputStream fos=new FileOutputStream(uploadPath);
			InputStream is=part.getInputStream();
			
			byte[] data=new byte[is.available()];
			is.read(data);
			fos.write(data);
			fos.close();
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
	    	
	    	Store store=new Store();
	    	store.setContact(contact);
	    	store.setEmail(email);
	    	store.setName(storename);
	    	store.setOwnername(ownername);
	    	store.setPassword(password);
	    	store.setUsertype("store");
	    	store.setLocation(location);
	    	store.setExecutiveId(executive.getId());
	    	store.setStoreImagePath(fileName);
	    	
	    	boolean flag=new StoreDaoImp().addStore(store);
	    	
	    	if(flag == true)
	    	{
	    		session.setAttribute("message","Store Added Successfully..!");
		        response.sendRedirect("index.jsp");
	    	}
	    	
	    	else
	    	{
	    		session.setAttribute("message","Failed to Add Store");
		        response.sendRedirect("index.jsp");
	    	}	
	    		
	    }
	    
	    if(action.equals("updateStore"))
	    {
	    	String storeid =request.getParameter("storeId");
	    	String storename=request.getParameter("storename");
	    	String location=request.getParameter("location");
	    	String ownername=request.getParameter("ownername");
	    	String contact=request.getParameter("contact");
	    	
	    	Store store=new Store();
	    	store.setId(Integer.parseInt(storeid));
	    	store.setContact(contact);
	    	store.setName(storename);
	    	store.setOwnername(ownername);
	    	store.setLocation(location);
	    	
	    	boolean flag=new StoreDaoImp().updateStore(store);
	    	
	    	if(flag == true)
	    	{
	    		session.setAttribute("message","Store Updated Successfully..!");
		        response.sendRedirect("index.jsp");
	    	}
	    	
	    	else
	    	{
	    		session.setAttribute("message","Failed to Update Store");
		        response.sendRedirect("index.jsp");
	    	}	
	    		
	    }
	    
	}
}
