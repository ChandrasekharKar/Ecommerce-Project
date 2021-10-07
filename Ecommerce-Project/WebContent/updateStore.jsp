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
<title>Update Store</title>
<%@ include file="components/common_cs_js.jsp"%>
</head>
<body>
<%@ include file="components/navbar.jsp"%>
<div class="container-fluid">
  <div class="row mt-2">
       <div class="col-md-4 offset-md-4" >
            <div class="card">
                <%@ include file="components/message.jsp"%>
                <%
                  String storeId = request.getParameter("storeId");
                  System.out.println(storeId);
                  int id = Integer.parseInt(storeId); 
                  Store s = new StoreDaoImp().getStoreById(id);
                %>
                <div class="card-body px-5">
                    <h3 class="text-center my-3">Update Store</h3>
            <form action="RegisterServlet" method="post">
                  <input type="hidden" name="action" value="updateStore">
                  <input type="hidden" name="storeId" value="<%=s.getId()%>">
                  <img src="storeimages/<%=s.getStoreImagePath() %>" style="max-height:270px;max-width:100%;width:auto;" class="card-img-top rounded mx-auto d-block m-2" alt="img">
                  <div class="form-group">
                     <label for="email">Store Name</label>
                     <input type="text" class="form-control" id="firstname" aria-describedby="emailHelp" name="storename" placeholder="Enter Name" value="<%=s.getName() %>" required>
                 </div>
                 <div class="form-group">
                     <label for="email">Location</label>
                     <input type="text" class="form-control" id="lastname" aria-describedby="emailHelp" name="location" placeholder="Enter Location" value="<%=s.getLocation()%>" required>
                 </div>
                  <div class="form-group">
                     <label for="email">Owner Name</label>
                     <input type="text" class="form-control" id="email" aria-describedby="emailHelp" name="ownername" placeholder="Enter Owner name" value="<%=s.getOwnername()%>" required>
                 </div>
                 
                 <div class="form-group">
                     <label for="password">Contact</label>
                     <input type="text" class="form-control" id="password" aria-describedby="emailHelp" name="contact" placeholder="Enter Contact" value="<%=s.getContact()%>" required>
                 </div>
                 
                 <div class="form-group">
                     <label for="password">Email Id</label>
                     <input type="email" class="form-control" id="password" aria-describedby="emailHelp" name="email" placeholder="Enter Contact" value="<%=s.getEmail()%>" readonly required>
                 </div>
              
                 <div class="container text-center">
                      <input class="btn text-white bg-dark" type="submit" value="Update Store">
                 </div>
                 
            </form>
                </div>
            </div>
       </div>
  </div>
</div>
</body>
</html>