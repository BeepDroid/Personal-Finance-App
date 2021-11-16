/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author EBONY
 */
public class CashAccount implements IAccount {
     private String name;
    protected int cashValue;
    
    
    public CashAccount(String name, int cashValue){
        this.name = name;
        this.cashValue = cashValue;  
    }
    

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getValue() {
        return cashValue; //To change body of generated methods, choose Tools | Templates.
    }
}
