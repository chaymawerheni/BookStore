/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.controller;

import bookstore.Models.Book;
import dao.ConnectSing;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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

                book = new Book(r.getInt(1), r.getString(2), r.getString(3), r.getDouble(4), r.getString(5));
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
                book = new Book(r.getInt(1), r.getString(2), r.getString(3), r.getDouble(4), r.getString(5));

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

    public static void AjoutBookBD() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Saisissez le Titre d'un nouveau livre");
        String titre = sc.nextLine();

        System.out.println("Saisissez l'auther d'un nouveau livre");
        String author = sc.nextLine();

        System.out.println("Saisissez le prix d'un nouveau livre");
        double price = sc.nextDouble();
        sc.nextLine();

        System.out.println("Saisissez la date de creation du livre");
        System.out.println("Format : aaaa-mm-jj");

        String dateR = sc.nextLine();

        Book b = new Book(titre, author, price, dateR);

        try {

            String req = "insert into book (title,author,price,release_date) "
                    + "values ('" + b.getTitre() + "','" + b.getAuthor() + "','" + b.getPrice() + "','" + b.getReleaseDate() + "')";

            PreparedStatement preparedStmt = ConnectSing.GetInstance().prepareStatement(req);

            preparedStmt.execute();
            System.out.println("Un nouveau livre a ete ajouter avec succee!");

        } catch (SQLException ex) {
            Logger.getLogger(BookCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
