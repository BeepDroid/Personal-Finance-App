/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kebey
 */
public class DebitAccount implements IAccount{
    
    private String name;
    protected int debitValue;
    protected String newName;
    
    public DebitAccount(String name, int debitValue){
        this.name = name;
        this.debitValue = debitValue;   
    }

    @Override
    public String getName() {
        return name; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getValue() {
        return debitValue; //To change body of generated methods, choose Tools | Templates.
    }
    
    public String updateName(String newName){
        this.newName = name;
        return name;
    }
    
    
}
