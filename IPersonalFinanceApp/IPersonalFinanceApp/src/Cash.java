/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Javon LaCour
 */
public class Cash extends Account {
     
    public Cash(String name, double value) {
        super(name, value);
    }
    
    public double getValue(){
        return value;
    }
     public void increasecashValue( double cashDeposited){
         System.out.println(cashDeposited);
         value += cashDeposited;
    }
    public void decreasedcashValue ( double cashWithdraw){
       value -= cashWithdraw; 
    }


    @Override
    public boolean updateBalance(double transAmount) {
        if(transAmount > 0){
        value = transAmount;
        return true;
        }
        else  
        return false;
    }
}

