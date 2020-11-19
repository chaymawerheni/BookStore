/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Chayma
 */
public class ConnectSing {

    public static Connection connect;

    private ConnectSing() {

        System.out.println("Connection test...");
        try {

            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("pilote charged");
        } catch (ClassNotFoundException e) {

            System.out.println("Where is your MYSQL JDBC Driver?");
            e.printStackTrace();
            return;

        }
        System.out.println("MYSQL JDBC Driver Registered!");
        try {

            connect = DriverManager.getConnection("jdbc:mysql://localhost:3308/bookstore", "root", "");

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check console");
            e.printStackTrace();
            return;

        }
        if (connect != null) {
            System.out.println("Connected");
            System.out.println("\n");
        } else {
            System.out.println("Connection Failed!");
        }
    }

    public static Connection GetInstance() {

        if (connect == null) {
            System.out.println("\n");
            System.out.println("_____________Etablissement de la connection avec la bd _____________");
            System.out.println("instantiation of MySQL database");
            new ConnectSing();

        } else {
            System.out.println("               ");
            System.out.println("               \n");
        }
        return connect;
    }

}
