<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Executive Register</title>
<%@ include file="components/common_cs_js.jsp"%>
</head>
<body>
<%@ include file="components/navbar.jsp"%>
<div class="container-fluid">
  <div class="row mt-2">
       <div class="col-md-4 offset-md-4" >
            <div class="card">
                <%@ include file="components/message.jsp"%>
                <div class="card-body px-5">
                    <h3 class="text-center my-3">Executive register</h3>
            <form onsubmit="return validate()" action="RegisterServlet" method="post">
                  <input type="hidden" name="action" value="executiveRegister">
                  <div class="form-group">
                     <label for="email">First Name</label>
                     <input type="text" class="form-control" id="firstname" aria-describedby="emailHelp" name="firstname" placeholder="Enter First name" required>
                 </div>
                 <div class="form-group">
                     <label for="email">Last Name</label>
                     <input type="text" class="form-control" id="lastname" aria-describedby="emailHelp" name="lastname" placeholder="Enter Last name" required>
                 </div>
                  <div class="form-group">
                     <label for="email">Email</label>
                     <input type="email" class="form-control" id="email" aria-describedby="emailHelp" name="email" placeholder="Enter Email" required>
                 </div>
                 
                 <div class="form-group">
                     <label for="password">Contact</label>
                     <input type="text" class="form-control" id="password" aria-describedby="emailHelp" name="contact" placeholder="Enter Contact" required>
                 </div>
                 
                 <div class="form-group">
                     <label for="password">Password</label>
                     <input type="password" class="form-control" id="cpassword" aria-describedby="emailHelp" name="password" placeholder="Enter Password" required>
                     <div class="invalid-feedback"><span id="feedback"></span></div>
                 </div>
                 <div class="form-group">
                     <label for="password">Confirm Password</label>
                     <input type="password" class="form-control" id="cpassword" aria-describedby="emailHelp" name="cpassword" placeholder="Enter Password" required>
                     <div class="invalid-feedback"><span id="feedback"></span></div>
                 </div>
                 <div class="container text-center">
                      <input class="btn text-white bg-dark" type="submit" value="Register">
                 </div>
                 
            </form>
                </div>
            </div>
       </div>
  </div>
</div>
</body>
</html>