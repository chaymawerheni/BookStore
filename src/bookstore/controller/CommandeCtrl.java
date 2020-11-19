/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.controller;

import bookstore.connect.ConnectSing;


import bookstore.model.Commande;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

/**
 *
 * @author Youssef
 */
public class CommandeCtrl {
    public CommandeCtrl() {

        ConnectSing.GetInstance();
    }
    
    public static Commande getCommand(int id) {
        Commande cmd = null;
        try {
            ResultSet r;
            Statement st;

            String req = ("select * from commande where idCommande = '" + id + "'");

            st = ConnectSing.GetInstance().createStatement();
            r = st.executeQuery(req);

            while (r.next()) {

                cmd = new Commande(r.getInt(1), r.getString(2), r.getInt(3), r.getInt(4));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CommandeCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cmd;

    }
    
    public static ArrayList getListCommands() {
        Commande cmd = null;
        ArrayList<Commande> list = new ArrayList();

        try {
            ResultSet r;
            Statement st;

            String req = ("select * from commande ");
            st = ConnectSing.GetInstance().createStatement();
            r = st.executeQuery(req);
            while (r.next()) {
                cmd = new Commande(r.getInt(1), r.getString(2), r.getInt(3), r.getInt(4));

                list.add(cmd);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CommandeCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public static void AjoutCommande(Commande c) {

        try {

            String req = "insert into commande (date,idClient,id) "
                    + "values ('" + c.getDate() + "','" + c.getIdClient()+ "','" + c.getIdBook() + "')";

            PreparedStatement preparedStmt = ConnectSing.GetInstance().prepareStatement(req);

            preparedStmt.execute();
            
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText("Confirmation de votre Commande");
                alert.setContentText("L'ajout de votre commande à été effectuer avec succès!");

                alert.showAndWait();
//            System.out.println("Une nouvelle commande a ete ajouter avec succee!");

        } catch (SQLException ex) {
            Logger.getLogger(CommandeCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
}
