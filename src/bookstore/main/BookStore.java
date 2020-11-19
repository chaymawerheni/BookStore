/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.main;

import bookstore.model.Book;
import bookstore.model.Utility;
import java.util.Scanner;
import java.util.ArrayList;
import static bookstore.controller.BookCtrl.*;

/**
 *
 * @author chaym
 */
public class BookStore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
       /* Scanner sc = new Scanner(System.in);
        
        System.out.println("Donner le nbr de quantite");
        int qte= sc.nextInt();
        
        System.out.println("Donner le prix unitaire ");
        double unitP= sc.nextDouble();
        
        Utility u= new Utility(qte, unitP);
        
        double result= u.calculTotalPrice(qte, unitP);
        
        System.out.println(result);*/    
               int chx;

        do {

            System.out.println("_________________________________________________");
            System.out.println("___________________Bienvenue_____________________");
            System.out.println("________1/Afficher la liste des livres");
            System.out.println("________2/Ajouter un livre");
            System.out.println("________3/ Quitter_______________________________");
            System.out.println("_________________________________________________\n");

            do {

                Scanner sc = new Scanner(System.in);

                System.out.println("Saisissez votre choix");
                chx = sc.nextInt();

            } while (chx < 0 && chx > 4);

            switch (chx) {
                case 1:
                     ArrayList<Book> list = new ArrayList();
                     AfficheList(list);
                    break;
                case 2:
                    AjoutBookBD();
                    System.out.println("\n");
                    break;
                case 3:
                    System.out.println("___________________A bientot!_____________________");
                    System.exit(0);
                    break;
                default:
                    System.out.println("!!!!");

            }

        } while (chx != 6);
       
       
    }

    private static void AjoutBookBD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
