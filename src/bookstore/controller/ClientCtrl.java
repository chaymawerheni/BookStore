/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.controller;

import bookstore.connect.ConnectSing;
import bookstore.model.Client;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Youssef
 */
public class ClientCtrl {

    public ClientCtrl() {

        ConnectSing.GetInstance();
    }

    public static Client getClient(String nom) {
        Client client = null;
        try {
            ResultSet r;
            Statement st;

            String req = ("select * from client where nom like '" + nom + "'");

            st = ConnectSing.GetInstance().createStatement();
            r = st.executeQuery(req);

            while (r.next()) {

                client = new Client(r.getInt(1), r.getString(2), r.getString(3), r.getString(4), r.getString(5), r.getString(6));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return client;

    }
    
    public static Client getClient(int id) {
        Client client = null;
        try {
            ResultSet r;
            Statement st;

            String req = ("select * from client where idClient = '" + id + "'");

            st = ConnectSing.GetInstance().createStatement();
            r = st.executeQuery(req);

            while (r.next()) {

                client = new Client(r.getInt(1), r.getString(2), r.getString(3), r.getString(4), r.getString(5), r.getString(6));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return client;

    }

    public static void AjoutClient(Client c) {

        try {

            String req = "insert into client (nom,prenom,email,tel,adresse) "
                    + "values ('" + c.getNom() + "','" + c.getPrenom() + "','" + c.getEmail() + "','" + c.getTel() + "','"
                    + c.getAdresse() + "')";

            PreparedStatement preparedStmt = ConnectSing.GetInstance().prepareStatement(req);

            preparedStmt.execute();

            
            System.out.println("Un nouveau client a ete ajouter avec succee!");

        } catch (SQLException ex) {
            Logger.getLogger(ClientCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
