<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Files</title>
</head>
<body>
    <div>
        <h3>Uploaded Files</h3>
        <g:each in="${document}" var="docs" status="i">
            <h3>${i+1}. ${docs.name}</h3>
            <br/>
        </g:each>
      
        <g:uploadForm name="download_form" >
        <g:hiddenField name="file1" value="${uploadFile}" />
        </g:uploadForm>
    </div>

    <g:link controller="hello" action="downloadfile">Download</g:link><br>
    
    </body>
</html>
