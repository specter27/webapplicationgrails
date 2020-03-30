package org.bookstore

class user {
    String firstName
    String lastName
    String mail
    String password

    static constraints = {
        firstName(blank:false)
        lastName(blank:false)
        mail(blank:false)
        password(blank:false)
    }

}
