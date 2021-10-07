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
<title>Total Stores</title>
<%@ include file="./components/common_cs_js.jsp"%>
</head>
<body>
<%@ include file="./components/navbar.jsp"%>
<div class="container-fluid">
  <div class="row mt-4">
       <form class="form-inline ml-5" action="StoreServlet">
       <input type="hidden" name="action" value="searchByID"/>
          <div class="form-group">
            <label for="inputPassword2" class="text-color"><h4>Search Store By Id</h4></label>
            <input type="number" class="form-control ml-3" id="inputPassword2" name="storeid" placeholder="Enter Store Id.." required>
          </div>
          <button type="submit" class="btn text-color custom-bg ml-2">Search</button>
       </form>
       <form class="form-inline mt-1" action="StoreServlet">
       <input type="hidden" name="action" value="searchByName"/>
          <div class="form-group">
            <label for="inputPassword2" class="text-color ml-5"><h4>Search Store By Name</h4></label>
            <input type="text" class="form-control ml-3" id="inputPassword2" name="storename" placeholder="Enter Store name.." required>
          </div>
          <button type="submit" class="btn text-color custom-bg ml-2">Search</button>
       </form>
  </div>
  <div class="table-responsive">
          <table class="table">
  <thead class="bg-dark text-white">
    <tr>
      <th scope="col">Store Image</th>
      <th scope="col">Store Name</th>
      <th scope="col">Location</th>
      <th scope="col">Contact</th>
      <th scope="col">Owner name</th>
      <th scope="col">Email</th>
    </tr>
  </thead>
  <tbody>
   <%
      List<Store> stores = (List<Store>)request.getAttribute("stores");
      List<Store> st = null;   		
            		
      if(stores != null) {
    	  st = stores;
      }
      
      else
      {
    	  st = new StoreDaoImp().getAllStore();
      }
   
   %>
  
   <%
      for(Store s:st)
      {
   %>
    <tr>
      <td class="mid-align"><img style="max-width:70px" class="img-fluid rounded-circle" src="storeimages/<%=s.getStoreImagePath() %>" alt="users_pic" ></td>
      <td class="mid-align"><%=s.getName() %></td>
      <td class="mid-align"><%=s.getLocation() %></td>
      <td class="mid-align"><%=s.getContact() %></td>
      <td class="mid-align"><%=s.getOwnername() %></td>
      <td class="mid-align"><%=s.getEmail() %></td>
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