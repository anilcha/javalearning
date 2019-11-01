<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css"> 
<link rel="stylesheet" href="resources/login.css">
<script type="text/javascript" src="resources/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/jquery-login.js"></script>

<!-- Include the above in your HEAD tag -->

<body>
    <div id="login">
        <h3 class="text-center text-white pt-10">OCASh LLC</h3>
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-10">
                     <span style="color: red">${msg}</span>
                        <form id="login-form" class="form-login" action="ForgotPasswordController" method="post">                                             
                            <h3 class="text-center text-info">Forgot Password</h3>
                            <h6 class="text-center text-info">Please enter username and email to edit password</h6>                         
                            <div class="form-group">
                                <label for="username" class="text-info">Username:</label><br>
                                <input type="text" id="user_name" class="form-control" name="uname" placeholder="(e.g. visitnepal2019)" required autofocus>
                            </div>
                            <div class="form-group">
                                <label for="email" class="text-info">Email:</label><br>
                                <input type="email" id="email" class="form-control" name="email" placeholder="(e.g. java@hotmail.com)" required>
                            </div>
                            <div id="reset-password-link" class="text-right">
                            	<a href="ResetPasswordController">Submit</a>                             
                            </div>                            
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>