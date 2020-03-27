<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main"/>
        <title>Login page</title>
    </head>
    <body>
        <g:form controller="login_form" controller="hello" action="welcome" >
            <label>Username: </label>
            <g:textField name="uid" placeholder="Username" class="form-control"/><br/>
            <label>Password: </label>
            <g:passwordField name="myPasswordField" value="${myPassword}" placeholder="Password" class="form-control" />
            <br>
                <br>

                </br>
            </br><g:submitButton value="Login" name="login" class="btn btn-success"/>
        </g:form>
    </body>
</html>