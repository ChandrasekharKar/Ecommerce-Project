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
<title>Admin Page</title>
<%@ include file="components/common_cs_js.jsp"%>

</head>
<body>
 <%@ include file="components/navbar.jsp"%>
  
 <div class="container mt-2">
     <%@ include file="components/message.jsp"%>
      <div class="row mt-3">
           <div class="col-md-3">
                 <div class="card">
                     <div class="card-body text-center">
                         <h1><%=new StoreDaoImp().getCountOfStore() %></h1>
                         <h2 class="text-uppercase text-muted"><a href="totalstore.jsp"><button type="button" class="btn btn-dark">Total No. of Stores</button></a></h2>
                     </div>
                 </div>
           </div>
           
           <div class="col-md-3">
                  <div class="card">
                     <div class="card-body text-center">
                          <h1><%=new ExecutiveDaoImp().getCountOfExecutive() %></h1>
                          <h2 class="text-uppercase text-muted"><a href="totalexecutive.jsp"><button type="button" class="btn btn-dark">Total No. of Executives</button></a></h2>
                     </div>
                 </div>
           </div>
           
           <div class="col-md-3">
                  <div class="card">
                     <div class="card-body text-center">
                          <h1><%=new CustomerDaoImp().getCountOfCustomer() %></h1>
                          <h2 class="text-uppercase text-muted"><a href="totalcustomer.jsp"><button type="button" class="btn btn-dark">Total No. of Customers</button></a></h2>
                     </div>
                 </div>
           </div>
           
          
           </div>
      </div>


</body>
</html>