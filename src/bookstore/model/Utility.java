/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.model;

/**
 *
 * @author Chayma
 */
public class Utility implements CalculateTotalPrice{
    
    
    int qte;
    double unitePrice;

    public Utility(int qte, double unitePrice) {
        this.qte = qte;
        this.unitePrice = unitePrice;
    }

    @Override
    public double calculTotalPrice(int qte, double unitePrice) {
        
        return qte*unitePrice;
    }
    
    
    
}
