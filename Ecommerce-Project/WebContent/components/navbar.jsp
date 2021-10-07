<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="index.jsp"><i>All in One Store</i></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    
    <%
       String activeUserType=(String)session.getAttribute("activeUserType");
       if(activeUserType != null )
       {
    %>
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="LoginServlet">Logout <span class="sr-only">(current)</span></a>
            </li>
          </ul>
    <%
       }
       
       else
       {
    %>
         <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="adminRegister.jsp">Admin Register <span class="sr-only">(current)</span></a>
            </li>
          </ul>
     
         <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="customerRegister.jsp">Customer Register <span class="sr-only">(current)</span></a>
            </li>
          </ul>
          
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="executiveRegister.jsp">Executive Register <span class="sr-only">(current)</span></a>
            </li>
          </ul>
          
           <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="adminLogin.jsp">Admin Login <span class="sr-only">(current)</span></a>
            </li>
          </ul>
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="customerLogin.jsp">Customer Login <span class="sr-only">(current)</span></a>
            </li>
          </ul>
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="executiveLogin.jsp">Executive Login <span class="sr-only">(current)</span></a>
            </li>
          </ul>
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="storeRegister.jsp">Store Register<span class="sr-only">(current)</span></a>
            </li>
          </ul>
          
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="storeOwnerLogin.jsp">Store Owner Login <span class="sr-only">(current)</span></a>
            </li>
          </ul>
    <%
       }
       
       if(activeUserType != null && activeUserType.equals("admin"))
       {
    %>
         <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="admin.jsp">Admin Page <span class="sr-only">(current)</span></a>
            </li>
          </ul>
      
         <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="executiveRegister.jsp">Executive Register <span class="sr-only">(current)</span></a>
            </li>
          </ul>
    <%
       }
       
       else if(activeUserType != null && activeUserType.equals("executive"))
       {
    %>
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="storeRegister.jsp">Store Register <span class="sr-only">(current)</span></a>
            </li>
          </ul>
          
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="myAddedStores.jsp">My Added Stores<span class="sr-only">(current)</span></a>
            </li>
          </ul>
    <%
       }
       
       else if( activeUserType != null && activeUserType.equals("store"))
       {
    %> 
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="store.jsp">My Store<span class="sr-only">(current)</span></a>
            </li>
          </ul>
    <%
       }
       
       else if( activeUserType != null && activeUserType.equals("customer"))
       {
    %>
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="myWishlist.jsp">My Wishlist<span class="sr-only">(current)</span></a>
            </li>
          </ul>
    <%
       }
    %>
  </div>
</nav>