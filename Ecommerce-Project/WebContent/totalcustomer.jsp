<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="com.ecommerce.pojo.*"%>
<%@ page import ="com.ecommerce.dao.*"%>
<%@ page import ="java.sql.*"%>
<%@ page import ="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Total Customers</title>
<%@ include file="./components/common_cs_js.jsp"%>
</head>
<body>
<%@ include file="./components/navbar.jsp"%>
<div class="container-fluid">
  <div class="row mt-4">
       <form class="form-inline ml-5" action="CustomerServlet">
       <input type="hidden" name="action" value="searchByID"/>
          <div class="form-group">
            <label for="inputPassword2" class="text-color"><h4>Search Customer By Id</h4></label>
            <input type="number" class="form-control ml-3" id="inputPassword2" name="customerid" placeholder="Enter Customer Id.." required>
          </div>
          <button type="submit" class="btn text-color custom-bg ml-2">Search</button>
       </form>
       <form class="form-inline mt-1" action="CustomerServlet">
       <input type="hidden" name="action" value="searchByName"/>
          <div class="form-group">
            <label for="inputPassword2" class="text-color ml-5"><h4>Search Customer By Name</h4></label>
            <input type="text" class="form-control ml-3" id="inputPassword2" name="customername" placeholder="Enter Customer name.." required>
          </div>
          <button type="submit" class="btn text-color custom-bg ml-2">Search</button>
       </form>
  </div>
  <div class="table-responsive">
          <table class="table">
  <thead class="bg-dark text-white">
    <tr>
      <th scope="col">First Name</th>
      <th scope="col">Last Name</th>
      <th scope="col">Email</th>
      <th scope="col">Contact</th>
    </tr>
  </thead>
  <tbody>
   <%
      List<Customer> customers = (List<Customer>)request.getAttribute("customers");
      List<Customer> cus = null;   		
            		
      if(customers != null) {
    	  cus = customers;
      }
      
      else
      {
    	  cus = new CustomerDaoImp().getAllCustomers();
      }
   
   %>
  
   <%
      for(Customer e : cus)
      {
   %>
    <tr>
      <td class="mid-align"><%=e.getFirstname() %></td>
      <td class="mid-align"><%=e.getLastname()%></td>
      <td class="mid-align"><%=e.getEmail() %></td>
      <td class="mid-align"><%=e.getContact() %></td>
    </tr>
    <%
      }
    %>
  </tbody>
</table>
</div>
</div>

</body>
</html>