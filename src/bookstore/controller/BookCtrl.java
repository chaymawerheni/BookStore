/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.controller;

import bookstore.model.Book;
import bookstore.connect.ConnectSing;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

/**
 *
 * @author Chayma
 */
public class BookCtrl {

    public BookCtrl() {

        ConnectSing.GetInstance();
    }

    public static Book getBook(int id) {
        Book book = null;
        try {
            ResultSet r;
            Statement st;

            String req = ("select * from book where id ='" + id + "'");

            st = ConnectSing.GetInstance().createStatement();
            r = st.executeQuery(req);

            while (r.next()) {

                book = new Book(r.getInt(1), r.getString(2), r.getString(3), r.getString(4), r.getString(5));
            }

        } catch (SQLException ex) {
            Logger.getLogger(BookCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return book;

    }

    public static ArrayList getListBook() {
        Book book = null;
        ArrayList<Book> list = new ArrayList();

        try {
            ResultSet r;
            Statement st;

            String req = ("select * from book ");
            st = ConnectSing.GetInstance().createStatement();
            r = st.executeQuery(req);
            while (r.next()) {
                book = new Book(r.getInt(1), r.getString(2), r.getString(3), r.getString(4), r.getString(5));

                list.add(book);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BookCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static void AfficheList(ArrayList<Book> listBook) {

        listBook = getListBook();
        System.out.println("Liste des livres :\n\n");

        for (Book b : listBook) {

            System.out.println("Livre N° :" + b.getId());
            System.out.println("Titre: " + b.getTitre());
            System.out.println("Author: " + b.getAuthor());
            System.out.println("Price: " + b.getPrice());
            System.out.println("Release date: " + b.getReleaseDate());
            System.out.println("      ____________________           \n");

        }
    }

   public static void AjoutBookBD(Book b) {

        try {

            String req = "insert into book (title,author,price,release_date, couverture) "
                    + "values ('" + b.getTitre() + "','" + b.getAuthor() + "','" + b.getPrice() + "','" + b.getReleaseDate() + "','" 
                    + b.getCouverture() + "')";

            PreparedStatement preparedStmt = ConnectSing.GetInstance().prepareStatement(req);

            preparedStmt.execute();
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText("Ajout de Livre");
                alert.setContentText("Le livre a été ajouter avec succee!");

                alert.showAndWait();
            
//            System.out.println("Un nouveau livre a ete ajouter avec succee!");

        } catch (SQLException ex) {
            Logger.getLogger(BookCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void ModifyBookBD(Book b) {


        if (b != null) {
            
            String req = "update book set title = '"+b.getTitre()+"', author = '"+b.getAuthor()
                    +"', price='"+b.getPrice()+"', release_date = '"+b.getReleaseDate()+"' where id = "+b.getId();
            try {
              
                PreparedStatement preparedStmt = ConnectSing.GetInstance().prepareStatement(req);
                preparedStmt.execute();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText("Modification du Livre");
                alert.setContentText("Le nom du livre a ete modifier avec succee!");

                alert.showAndWait();
//                System.out.println("Le nom du livre a ete modifier avec succee!");

            } catch (SQLException ex) {
                Logger.getLogger(BookCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            System.out.println("ce livre n'existe pas, verifier l'id ");
        }

  
    }
    
    public static void DeleteBookBD(Book b) {


        if (b != null) {
            
            String req = "delete from book where id = "+b.getId();
            
            try {
             
                PreparedStatement preparedStmt = ConnectSing.GetInstance().prepareStatement(req);
                preparedStmt.execute();
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText("Suppression du Livre");
                alert.setContentText("Le livre a été supprimer avec succee!");

                alert.showAndWait();
//                System.out.println("Le livre a été supprimer avec succee!");

            } catch (SQLException ex) {
                Logger.getLogger(BookCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            System.out.println("ce livre n existe pas, verifier l id ");
        }

  
    }

}
