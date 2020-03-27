package bookstore

import org.bookstore.user



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

    def welcome(){

        //getting values from the gsp
        def uname=params.uid
        def pass=params.myPasswordField

        //getting values from database
        def luser=user.find("from user as u where u.mail=${uname}")
//               [luser:luser]
//            render" hello ${luser.password}"
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
