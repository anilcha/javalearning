

<!-- copy bootstrap.min.css into href from bootstrap folder -->
<!-- link jQuery by dragging the file from the resources -->
<!-- link bootstrap.mn.js by dragging the file from the resources -->

<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css"> 
<script type="text/javascript" src="resources/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="resources/bootstrap/js/bootstrap.min.js"></script>

<nav class="navbar navbar-expand-lg navbar-inverse bg-dark">
  <a class="navbar-brand" href="#">UserInfoSystems</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
		<li class="nav-item active">
        	<a class="nav-link" href="home.jsp">Home <span class="sr-only">(current)</span></a>
      	</li>
		<li class="nav-item">
        	<a class="nav-link" href="UserController?actions=list"></a>
     	 </li>
		<li class="nav-item dropdown">
        	<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">${u}
        </a>
        <div class="dropdown-menu"  aria-labelledby="navbarDropdown">
          	<a class="dropdown-item" href="userForm.jsp">Add User</a>
			<a class="dropdown-item" href="UserController?actions=list">Edit User</a>
			<a class="dropdown-item" href="UserController?actions=list">Delete User</a>
			<a class="dropdown-item" href="LoginController">Logout</a>
        </div>
      </li>
</ul>
  </div>
</nav>
 