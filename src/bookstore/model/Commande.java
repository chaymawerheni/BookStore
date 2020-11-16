/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.model;

import java.util.ArrayList;

/**
 *
 * @author Youssef
 */
public class Commande {
     private int id;
     private String date;
     private double prixTotale;
     private ArrayList<Book> lb;
     private int idClient;

    public Commande(int id, String date, double prixTotale, ArrayList<Book> lb, int idClient) {
        this.id = id;
        this.date = date;
        this.prixTotale = prixTotale;
        this.lb = lb;
        this.idClient = idClient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPrixTotale() {
        return prixTotale;
    }

    public void setPrixTotale(double prixTotale) {
        this.prixTotale = prixTotale;
    }

    public ArrayList<Book> getLb() {
        return lb;
    }

    public void setLb(ArrayList<Book> lb) {
        this.lb = lb;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
     
     
     
     
    
    
}
