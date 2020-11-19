/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.model;

import bookstore.view.HomePage.TableController;
import static com.oracle.util.Checksums.update;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import static bookstore.controller.BookCtrl.DeleteBookBD;
import static bookstore.controller.BookCtrl.ModifyBookBD;
import static bookstore.view.HomePage.TableController.loadData;
import javafx.collections.FXCollections;
import javafx.scene.control.CheckBox;


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
    private String couverture ;
    public Button update;
    public Button delete;
    public CheckBox checklivre;
    

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
    
    public Book(String titre, String author, String price, String releaseDate, String couverture) {
        this.titre = titre;
        this.author = author;
        this.price = price;
        this.releaseDate = releaseDate;
        this.couverture = couverture;
    }
     public Book(int id ,String titre, String author, String price, String releaseDate,String couverture ,Button update, Button delete) {
        this.id = id;
         this.titre = titre;
        this.author = author;
        this.price = price;
        this.releaseDate = releaseDate;
        this.couverture = couverture;
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

  public Book(int id ,String titre, String price, CheckBox checklivre) {
        this.id = id;
         this.titre = titre;
        this.checklivre=checklivre;
        this.price = price;
     
        //this.checklivre=checklivre;
        ObservableList <String> checkboxList = FXCollections.observableArrayList();
        checklivre.setOnAction(e->{
        
        checkboxList.add(checklivre.getText());
        });
        
        
        
 
  }

    public CheckBox getChecklivre() {
        return checklivre;
    }

    public void setChecklivre(CheckBox checklivre) {
        this.checklivre = checklivre;
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

    public String getCouverture() {
        return couverture;
    }

    public void setCouverture(String couverture) {
        this.couverture = couverture;
    }
    

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", titre=" + titre + ", author=" + author + ", price=" + price + ", releaseDate=" + releaseDate + '}';
    }

}
