/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kebey
 */
public class Account implements IAccount {
    protected String name;
    protected double value = 0;
    protected String newName;
    
    public Account(String name, double value){
        this.name = name;
        this.value = value;
    }

    @Override
    public String getName() {
        return name; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getValue() {
        return value; //To change body of generated methods, choose Tools | Templates.
    }
    
    public String updateName(String newName){
        this.newName = name;
        return name;    
    }
    
    public abstract boolean updateBalance(double transAmount);
    
}
