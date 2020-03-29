<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome</title>
</head>
<body>


    <h1> Hi , ${luser.firstName}</h1>
    <g:link controller="hello" method="post" asynchronous="false" onSuccess="/hello/login">Logout</g:link>

    <h4> you can now upload your files with this application<h4>

    <div style="margin-bottom: 25px" class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
        <h1>Upload New Document</h1>
        <g:uploadForm name="upload_form" controller="hello" action="upload">
            <fieldset class="form">
                <input type="file" name="file" />
            </fieldset>
            <fieldset class="buttons">
                <g:submitButton name="upload" class="save" value="Upload" />
            </fieldset>
        </g:uploadForm>

    </div>

</body>
</html>
