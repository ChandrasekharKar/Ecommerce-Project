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
<title>Home Page</title>
<%@ include file="components/common_cs_js.jsp"%>
</head>
<body>
<%@ include file="components/navbar.jsp"%>
<div class="text-center"><%@ include file="components/message.jsp"%></div>

<div class="container-fluid">
     <div class="col-md-12">
             <div class="row mt-4">
                 <div class="col-md-12">
                     <div class="card-columns">
                     
                         <%
                             Executive executive = (Executive)session.getAttribute("active-user");
                             List<Store> li=new StoreDaoImp().getStoreByExecutiveId(executive.getId());
                             for(Store s:li)
                             {
                          
                         %>
                        
                         <div class="card">                         
                             <div class="card-body">
                                 <img src="storeimages/<%=s.getStoreImagePath() %>" style="max-height:270px;max-width:100%;width:auto;" class="card-img-top rounded mx-auto d-block m-2" alt="img">
                                 <h1 class="card-title">Store Name : <a href="myStore.jsp?storeId=<%=s.getId()%>" style="text-decoration: none;color:black;"> <%=s.getName()%></a></h1>
                                 <p class="card-text">Location : <%=s.getLocation() %></p> 
                                 <p class="card-text">Contact No. : <%=s.getContact() %></p> 
                             </div>
                             <div class="card-footer text-center">
                                 <p style="font-size:25px"><span class="ml-2">Owner : <b><%=s.getOwnername()%></b></span>
                             </div>
                             
                         </div>
                         
                       
                         <%
                             
                             }
                         %>
                     </div>
                 </div>
             </div>
            
         </div>
</div>
</body>
</html>