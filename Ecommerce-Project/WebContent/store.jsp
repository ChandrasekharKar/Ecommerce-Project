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
<title>My Store</title>
<%@ include file="components/common_cs_js.jsp"%>
</head>
<body>
<%@ include file="components/navbar.jsp"%>
<div class="container-fluid">
  <div class="row mt-2">
       <div class="col-md-4 offset-md-4" >
                         <%
                             Store s = (Store)session.getAttribute("active-user");
                             Store store = new StoreDaoImp().getStoreById(s.getId()); 
                         %>
                        
                         <div class="card">                         
                             <div class="card-body">
                                 <img src="storeimages/<%=s.getStoreImagePath() %>" style="max-height:270px;max-width:100%;width:auto;" class="card-img-top rounded mx-auto d-block m-2" alt="img">
                                 <h1 class="card-title">Store Name : <%=store.getName()%></h1>
                                 <p class="card-text">Location : <%=store.getLocation() %></p> 
                                 <p class="card-text">Contact No. : <%=store.getContact() %></p> 
                                 <p class="card-text">Owner : <%=store.getOwnername() %></p> 
                             </div>
                             
                             <%
                                String userType = (String)session.getAttribute("activeUserType");
                             System.out.println(userType);
                                if(userType != null && userType.equals("store")) 
                                {
                             %>
                             <div class="card-footer text-center">
                                 <a href="updateStore.jsp?storeId=<%=s.getId()%>"><button type="button" class="btn btn-dark">Update Store</button></a>
                             </div>
                             <%
                                }
                             %>
                         </div>         
       </div>
  </div>
</div>

</body>
</html>