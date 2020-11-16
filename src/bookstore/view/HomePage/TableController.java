/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.view.HomePage;

import bookstore.connect.ConnectSing;
import bookstore.model.Book;
import java.io.IOException;
import static java.lang.Double.parseDouble;
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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

/**
 *
 * @author Chayma
 */
public class TableController implements Initializable {

    @FXML
    private TableView<Book> table;
    @FXML
    public static TableView<Book> table2;
    @FXML
    private TableColumn<Book, Button> editClmn;
    @FXML
    private TableColumn<Book, Button> deleteClmn;
    @FXML
    private TableColumn<Book, Integer> idClmn;
    @FXML
    private TableColumn<Book, String> titleClmn;
    @FXML
    private TableColumn<Book, String> authorClmn;
    @FXML
    private TableColumn<Book, String> prixClmn;
    @FXML
    private TableColumn<Book, String> dateClmn;
    public static ObservableList<Book> oblist;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        table2 = table;

        initTable();
        loadData();

    }
    public void changeScreenButtonGoBack(ActionEvent event) throws IOException
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    private void initTable() {

        initCols();

    }

    private void initCols() {

        idClmn.setCellValueFactory(new PropertyValueFactory<>("id"));
        titleClmn.setCellValueFactory(new PropertyValueFactory<>("titre"));

        authorClmn.setCellValueFactory(new PropertyValueFactory<>("author"));

        prixClmn.setCellValueFactory(new PropertyValueFactory<>("price"));

        dateClmn.setCellValueFactory(new PropertyValueFactory<>("releaseDate"));

        editClmn.setCellValueFactory(new PropertyValueFactory<>("update"));
        deleteClmn.setCellValueFactory(new PropertyValueFactory<>("delete"));

        editableCOls();

    }

    private void editableCOls() {

        try {
            titleClmn.setCellFactory(TextFieldTableCell.forTableColumn());
            titleClmn.setOnEditCommit(e -> {
                e.getTableView().getItems().get(e.getTablePosition().getRow()).setTitre(e.getNewValue());
            });

            authorClmn.setCellFactory(TextFieldTableCell.forTableColumn());
            authorClmn.setOnEditCommit(e -> {
                e.getTableView().getItems().get(e.getTablePosition().getRow()).setAuthor(e.getNewValue());
            });

            prixClmn.setCellFactory(TextFieldTableCell.forTableColumn());
            prixClmn.setOnEditCommit(e -> {
                e.getTableView().getItems().get(e.getTablePosition().getRow()).setPrice(e.getNewValue());
            });

            dateClmn.setCellFactory(TextFieldTableCell.forTableColumn());
            dateClmn.setOnEditCommit(e -> {
                e.getTableView().getItems().get(e.getTablePosition().getRow()).setReleaseDate(e.getNewValue());
            });

            table.setEditable(true);

        } catch (Exception f) {
            System.exit(0);
        }

    }

    public static void loadData() {

        ResultSet r;
        Statement st;
        ObservableList<Book> oblist = FXCollections.observableArrayList();

        try {
            String req = ("select * from book ");
            st = ConnectSing.GetInstance().createStatement();
            r = st.executeQuery(req);
            while (r.next()) {
                oblist.add(new Book(r.getInt(1), r.getString(2), r.getString(3),
                        r.getString(4), r.getString(5), new Button("Update"), new Button("Delete")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TableController.class.getName()).log(Level.SEVERE, null, ex);
        }

        table2.setItems(oblist);

    }

}
