<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Store Register</title>
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
                    <h3 class="text-center my-3">Store Register</h3>
            <form onsubmit="return validate()" action="RegisterServlet" method="post" enctype="multipart/form-data">
                  <input type="hidden" name="action" value="storeRegister">
                  <div class="form-group">
                     <label for="email">Store Name</label>
                     <input type="text" class="form-control" id="firstname" aria-describedby="emailHelp" name="storename" placeholder="Enter Name" required>
                 </div>
                 <div class="form-group">
                     <label for="email">Location</label>
                     <input type="text" class="form-control" id="lastname" aria-describedby="emailHelp" name="location" placeholder="Enter Location" required>
                 </div>
                  <div class="form-group">
                     <label for="email">Owner Name</label>
                     <input type="text" class="form-control" id="email" aria-describedby="emailHelp" name="ownername" placeholder="Enter Owner name" required>
                 </div>
                 
                 <div class="form-group">
                     <label for="password">Contact</label>
                     <input type="text" class="form-control" id="password" aria-describedby="emailHelp" name="contact" placeholder="Enter Contact" required>
                 </div>
                 
                 <div class="form-group">
                     <label for="password">Email Id</label>
                     <input type="email" class="form-control" id="password" aria-describedby="emailHelp" name="email" placeholder="Enter Contact" required>
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
                 
                 <div class="form-group">
                   <label>Select Store Pic</label><br>
                   <input type="file" class="form-control" name="storePic" required>
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