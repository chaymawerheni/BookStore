/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandsLIst;

import bookstore.view.HomePage.*;
import bookstore.connect.ConnectSing;
import static bookstore.controller.BookCtrl.getBook;
import static bookstore.controller.ClientCtrl.getClient;
import bookstore.model.Book;
import bookstore.model.Client;
import bookstore.model.Commande;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Chayma
 */
public class CommandListController implements Initializable {

    @FXML
    private TableColumn<String, String> nomPrenomClt;

    @FXML
    private TableColumn<Commande, Integer> idClient;

    @FXML
    private TableColumn<Commande, Integer> idCmd;

    @FXML
    private TableColumn<Commande, Integer> idBook;

    @FXML
    private TableColumn<Commande, String> dateCmd;

    @FXML
    private TableColumn<String, String> titreBook;

    @FXML
    private TableColumn<String, String> prixUnit;

    @FXML
    private TableView<Commande> table;
    @FXML
    public static TableView<Commande> table2;

    public static String price="123";
    public static String titre="klklk";
    public static String nom="cccccc";
    public static String prenom="yyyyy";

    public static ObservableList<Commande> oblistCmd;
    public static ObservableList<Client> oblistClt ;
    public static ObservableList<Book> oblistBook ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        table2 = table;

        initTable();
        loadData();

    }

    private void initTable() {

        initCols();

    }

    private void initCols() {

        idCmd.setCellValueFactory(new PropertyValueFactory<>("idCmd"));
        dateCmd.setCellValueFactory(new PropertyValueFactory<>("date"));
        idClient.setCellValueFactory(new PropertyValueFactory<>("idClient"));
        idBook.setCellValueFactory(new PropertyValueFactory<>("idBook"));
        nomPrenomClt.setCellValueFactory(new PropertyValueFactory<>(nom + " " + prenom));
        titreBook.setCellValueFactory(new PropertyValueFactory<>(titre));
        prixUnit.setCellValueFactory(new PropertyValueFactory<>(price));

        editableCOls();

    }

    public void changeScreenButtonGoBack(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    private void editableCOls() {
        try {
     
            
            dateCmd.setCellFactory(TextFieldTableCell.forTableColumn());
            dateCmd.setOnEditCommit(e -> {
                e.getTableView().getItems().get(e.getTablePosition().getRow()).setDate(e.getNewValue());
            });
            
       
            

            

            table.setEditable(false);

        } catch (Exception f) {
            System.exit(0);
        }

    }

    public static void loadData() {

        ResultSet r;
        Statement st;

        oblistCmd = FXCollections.observableArrayList();
        oblistClt = FXCollections.observableArrayList();
        oblistBook = FXCollections.observableArrayList();

        try {
            String req = ("select * from commande ");
            st = ConnectSing.GetInstance().createStatement();
            r = st.executeQuery(req);
            while (r.next()) {

                oblistCmd.add(new Commande(r.getInt(1), r.getString(2), r.getInt(3), r.getInt(4)));

              
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommandListController.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
//        for (Commande cmd : oblistCmd) {
//            
//            
//
//            oblistClt.add(getClient(cmd.getIdClient())) ;
//            
//            for(Client clt: oblistClt){
//            
//                nom = clt.getNom();
//                prenom = clt.getPrenom();
//            
//            }
//            oblistBook.add( getBook(cmd.getIdBook()));
//            for(Book bk : oblistBook){
//            
//                titre = bk.getTitre();
//                price = bk.getPrice();
//            
//            }    
//        }
   
        
        table2.setItems(oblistCmd);

    }

}
