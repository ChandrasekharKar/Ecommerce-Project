<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Register</title>
<%@ include file="components/common_cs_js.jsp"%>
<script>
function validate()
{
	var userPass=document.getElementById("password").value;
	var userCpass=document.getElementById("cpassword").value;
	
	if(userCpass!=userPass)
	{
	  document.getElementById("feeback").innerHTML="Password not matching..";
	  return false;
	}
	
	return true;
}
</script>
</head>
<body>
<%@ include file="components/navbar.jsp"%>
<div class="container-fluid">
  <div class="row mt-2">
       <div class="col-md-4 offset-md-4" >
            <div class="card">
                <%@ include file="components/message.jsp"%>
                <div class="card-body px-5">
                    <h3 class="text-center my-3">Admin register</h3>
            <form onsubmit="return validate()" action="RegisterServlet" method="post">
                  <input type="hidden" name="action" value="adminRegister">
                  <div class="form-group">
                     <label for="email">Email</label>
                     <input type="email" class="form-control" id="email" aria-describedby="emailHelp" name="email" placeholder="Enter Email" required>
                 </div>
                 
                 <div class="form-group">
                     <label for="password">Password</label>
                     <input type="password" class="form-control" id="password" aria-describedby="emailHelp" name="password" placeholder="Enter Password" required>
                 </div>
                 
                 <div class="form-group">
                     <label for="password">Confirm Password</label>
                     <input type="password" class="form-control" id="cpassword" aria-describedby="emailHelp" name="cpassword" placeholder="Repeat Password" required>
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