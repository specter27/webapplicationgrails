package bookstore

import com.harshit.Randomstring
import com.harshit.encrypt
import org.bookstore.Document
import org.bookstore.Session
import org.bookstore.user

class HelloController {
    
    def show() {
    }
    
    def register() {
        render(view: "register")
    }

    def saveData = {
        def enc = new encrypt()
        params.password = enc.encryptThisString(params.password)
        def u = new user(params)
        u.save()
        render(view: "login")
    }


    Document document = new Document()

    def upload() {
        
        //getting the file which is uploaded on the gsp page
        def uploadedFile = request.getFile('file')
        if (uploadedFile.empty) {
            render: "File cannot be empty"
        } else {

            //converting file to bytes
            document.payload = uploadedFile.getBytes()
            //getting the file name from the uploaded file
            document.name = uploadedFile.originalFilename
            //getting and storing the file type
            document.type = uploadedFile.contentType
            //Create the record in DB by sending the needed Select command
            document.save()
            render(view: "uploadedfiles", model: [document: document])
        }

    }
    
    
    def downloadfile() {
        response.setContentType("application/octet-stream")
        response.setHeader("Content-disposition", "filename=${document.name}")
        response.outputStream << document.payload
        return
    }

    def customsession
    Session ses=new Session()
    def welcome() {
       //adding logout feature
        def randstring=new Randomstring()
        customsession=randstring.getAlphaNumericString()

        ses.sessionId=customsession
        ses.username=params.uid
        
        def uname = params.uid
        def pass = params.myPasswordField
        def enc = new encrypt()
        pass = enc.encryptThisString(pass)

        //getting values from database
        def luser = user.find("from user as u where u.mail=${uname}")

        if (luser.password.equals(pass)) {
            
            render(view: "welcome", model: [luser: user.find("from user as u where u.mail=${uname}"),ses:ses,customsession:customsession])

        } else {
            render "Invalid Password"
        }
    }

    
    def logout(){
        def randstring=new Randomstring()
        customsession=randstring.getAlphaNumericString()
        redirect( controller:'hello', action: 'login')
    }

    def login() {
        }
  }

