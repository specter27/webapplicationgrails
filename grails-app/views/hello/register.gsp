<!doctype html>
<html>
<head>

    <title>Registration page</title>
</head>

<body>
    <g:form name="registration_form" controller="hello" action="saveData" >
        <label>Firstname: </label>
        <g:textField name="firstName" placeholder="Firstname" class="form-control"/><br><br>
        <label>Lastname: </label>
        <g:textField name="lastName" value="${myPassword}" placeholder="Lastname" class="form-control" /><br><br>
        <br>
            <label>Email: </label>
            <g:textField name="mail" value="${myPassword}" placeholder="Email" class="form-control" /><br><br>
            <br>
                <label>Password: </label>
                <g:passwordField name="password" value="${myPassword}" placeholder="password" class="form-control" /><br><br>

            </br>
        </br><g:submitButton value="Register" name="register" class="btn btn-success"/>
    </g:form>

   </body>

</html>
