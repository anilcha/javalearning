<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css"> 
<link rel="stylesheet" href="resources/login.css">
<script type="text/javascript" src="resources/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/jquery-login.js"></script>

<!-- Include the above in your HEAD tag -->

<%
Cookie[] cookies = request.getCookies();
	for(int i =0; i <cookies.length; i++)
	{
		if (cookies[i].getName().equals("uname"))
		{
			request.setAttribute("un", cookies[i].getValue());
		} else if (cookies[i].getName().equals("pass"))
			{
			request.setAttribute("pw", cookies[i].getValue());
			} 
	}
%>

<body>
    <div id="login">
        <h3 class="text-center text-white pt-5">OCASh LLC</h3>
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-10">
                     <span style="color: red">${msg}</span>
                        <form id="login-form" class="form-login" action="LoginController" method="post">                                             
                            <h3 class="text-center text-info">Login</h3>                          
                            <div class="form-group">
                                <label for="username" class="text-info">Username:</label><br>
                                <input type="text" id="user_name" class="form-control" name="uname" placeholder="User_name" value="${un}" required autofocus>
                            </div>
                            <div class="form-group">
                                <label for="password" class="cool">Password:</label><br>
                                <input type="password" id="password" class="form-control" name="pass" placeholder="Password" value="${pw}" required>
                            </div>
                            <div class="form-group">
                                <label for="remember-me" class="text-info"><span>Remember me</span> <span><input id="remember-me" name="remember-me" type="checkbox" value="remember-me"></span></label><br>
                                <input type="submit" name="submit" class="btn btn-info btn-md" value="submit">
                            </div>
                            <div id="register-link" class="text-right">
                                <a href="userForm.jsp" class="text-info">Register Now</a>                                
                            </div>
                            <div id="forgot-password-link" class="text-right">
                            	<a href="userEditForm.jsp" class="text-info">Forgot Password</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
