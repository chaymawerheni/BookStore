/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.Models;

import java.util.Date;

/**
 *
 * @author chaym
 */
public class Book {
    String authors[];
    Date publicationDate;

    public Book(String[] authors, Date publicationDate) {
        this.authors = authors;
        this.publicationDate = publicationDate;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }
    
    
}
