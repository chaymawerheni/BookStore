/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import bookstore.Models.Utility;
import java.util.Scanner;

/**
 *
 * @author chaym
 */
public class BookStore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Donner le nbr de quantite");
        int qte= sc.nextInt();
        
        System.out.println("Donner le prix unitaire ");
        double unitP= sc.nextDouble();
        
        Utility u= new Utility(qte, unitP);
        
        double result= u.calculTotalPrice(qte, unitP);
        
        System.out.println(result);
    }
    
}
