/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.model;

/**
 *
 * @author Youssef
 */
public class Commande {
     private int idCmd;
     private String date;
     private int idBook;
     private int idClient;

    public Commande(int idCmd, String date,int idBook, int idClient) {
        this.idCmd = idCmd;
        this.date = date;
        this.idBook = idBook;
        this.idClient = idClient;
    }
 public Commande(String date, int idBook, int idClient) {
     
        this.date = date;
        this.idBook = idBook;
        this.idClient = idClient;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public int getIdCmd() {
        return idCmd;
    }

    public void setIdCmd(int idCmd) {
        this.idCmd = idCmd;
    }
 


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

 
    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
     
     
     
     
    
    
}
