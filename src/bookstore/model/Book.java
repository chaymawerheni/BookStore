/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.model;


import static bookstore.controller.BookCtrl.DeleteBookBD;
import static bookstore.controller.BookCtrl.ModifyBookBD;
import bookstore.view.HomePage.TableController;
import static bookstore.view.HomePage.TableController.loadData;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;


/**
 *
 * @author Chayma
 */
public class Book {

    private int id;
    private String titre;
    private String author;
    private String price;
    private String releaseDate;
    
    public Button update;
    public Button delete;
    
    
    

    public Book(int id, String titre, String author, String price, String releaseDate) {
        this.id = id;
        this.titre = titre;
        this.author = author;
        this.price = price;
        this.releaseDate = releaseDate;
    }

    public Book(String titre, String author, String price, String releaseDate) {
        this.titre = titre;
        this.author = author;
        this.price = price;
        this.releaseDate = releaseDate;
    }
     public Book(int id ,String titre, String author, String price, String releaseDate, Button update, Button delete) {
        this.id = id;
         this.titre = titre;
        this.author = author;
        this.price = price;
        this.releaseDate = releaseDate;
        this.update=update;
        this.delete=delete;
        
        update.setOnAction(e -> {
         /*   for  (Book book : TableController.oblist) { 
                if (book.getUpdate() == update){
                    System.out.println("Id :" +book.getId());
                    System.out.println("Titre :" +book.getTitre());
                    System.out.println("Auteur :" +book.getAuthor());
                    System.out.println("Prix :" +book.getPrice());
                    System.out.println("Date :" +book.getReleaseDate());
                
            } */
         
            ObservableList <Book> books = TableController.table2.getSelectionModel().getSelectedItems();
             for  (Book book : books) { 
                if (book.getUpdate() == update){
                    
                   ModifyBookBD(book);
                    
                    /*System.out.println("Id :" +book.getId());
                    System.out.println("Titre :" +book.getTitre());
                    System.out.println("Auteur :" +book.getAuthor());
                    System.out.println("Prix :" +book.getPrice());
                    System.out.println("Date :" +book.getReleaseDate());*/
                
            }
             }
        
    });
       
      delete.setOnAction(e-> {
          
          ObservableList <Book> books = TableController.table2.getSelectionModel().getSelectedItems();
          
          for(Book book : books){
              if(book.getDelete()== delete){
                  
                  DeleteBookBD(book);
                  loadData();
              }
          }
  
      });
    }

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Button getUpdate() {
        return update;
    }

    public void setUpdate(Button update) {
        this.update = update;
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", titre=" + titre + ", author=" + author + ", price=" + price + ", releaseDate=" + releaseDate + '}';
    }

}
