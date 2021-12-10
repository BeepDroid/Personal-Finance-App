/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Javon LaCour
 */
public  class Account implements IAccount {

   protected String name;
    protected double value = 0;
    protected String newName;
    
    public Account(String name, double value){
        this.name = name;
        this.value = value;
    }

    @Override
    public String getName() {
     this.newName = name;
        return name;      }

    @Override
    public double getValue() {
       return value; 
    }

   public boolean updateBalance(double transAmount){
       this.value = transAmount;
       return true;
   }
   public void setName(String newName){
       this.name = newName;
   } 
   public void setValue(double value){
       this.value = value;
   }
}
   
