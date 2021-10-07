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