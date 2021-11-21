/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kebey
 */
public class CreditCard extends Account {
    
    public CreditCard(String name, double value) {
        super(name, value);
    }
    
    public double getDebt(){
        return value;
    }
    
}
