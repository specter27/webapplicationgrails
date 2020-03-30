package bookstore

import org.bookstore.Document
import org.bookstore.user

import javax.print.Doc


class HelloController {


    def show() {
//         def vat="Haihyshit"run
//          [user:vat]
//        render(view: "show")

    }

  def register(){
     render(view:"register")
  }

    def saveData={

        def u=new user(params)
        u.save()
        render(view: "login")

    }

    Document document = new Document()
    def upload(){

        //getting the file wich is uploaded on the gsp page

        //request--> is the object of the Interface HttpServletRequest
        def uploadedFile = request.getFile('file')

        if(uploadedFile.empty) {
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

//            render "${document.payload}"
            render( view:"uploadedfiles", model: [document:document])
        }

    }
 //
    def downloadfile()
    {
              response.setContentType("application/octet-stream")
        response.setHeader("Content-disposition", "filename=${document.name}")
        response.outputStream << document.payload
        return
            }

    def welcome(){

        //getting values from the gsp
        def uname=params.uid
        def pass=params.myPasswordField

        //getting values from database
        def luser=user.find("from user as u where u.mail=${uname}")
//               [luser:luser]
//            render" hello ${luser.password}"
        //getting the uploaded files

        if (luser.password.equals(pass))
        {
            render(view: "welcome" , model: [luser:user.find("from user as u where u.mail=${uname}")])
//            render:"Success *********"
        }
        else{
            render"Invalid Password"
        }

    }

}
