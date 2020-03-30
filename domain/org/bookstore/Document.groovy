package org.bookstore

import java.util.Date;
class Document {

    String name
    String type
    byte[] payload
    Date lastUpdated // Predefined by Grails – filled automatically
    Date dateCreated // Predefined by Grails – filled automatically
    Date uploadDate = new Date()

    static constraints = {
        payload(nullable:false, maxSize:1073741824) // max of 4GB
        type(blank:true, nullable:true)
        name(blank:true, nullable:true)
    }

}
