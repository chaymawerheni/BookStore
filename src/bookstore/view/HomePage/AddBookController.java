/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.view.HomePage;

import static bookstore.controller.BookCtrl.AjoutBookBD;
import bookstore.model.Book;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Youssef
 */
public class AddBookController implements Initializable {

     @FXML
    private TextField authorField;

    @FXML
    private Label authorLabel;

    @FXML
    private TextField PriceField;

    @FXML
   private Button AddButton;
   
    @FXML
    private TextField nameField;

    @FXML
    private TextField DateField;

    @FXML
    private TextField coverField;
    
    @FXML
    private Label PriceLabel;

    @FXML
    private Label DateLabel;

    @FXML
    private Label HeaderLabel;

    @FXML
    private Label nameLabel;
    
    
    public void changeScreenButtonGoBack(ActionEvent event) throws IOException
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }

    public void addBookActionEvent(ActionEvent event)throws IOException{
     
         AddButton.setOnAction((ActionEvent) -> {
             Book b= new Book(nameField.getText(),authorField.getText(),PriceField.getText(),DateField.getText(), coverField.getText());
             AjoutBookBD(b);
         });
          
     }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
        
}
