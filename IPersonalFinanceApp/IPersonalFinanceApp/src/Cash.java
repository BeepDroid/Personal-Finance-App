/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kebey
 */
 */
public class Cash extends Account {
    protected double cashValue = 0;
    public Cash(String name, double value) {
        super(name, value);
    }
    
    public double getValue(){
        return value;
    }
     public void increasecashValue( double cashDeposited){
        cashValue += cashDeposited;
    }
    public void decreasedcashValue ( double cashWithdraw){
       cashValue -= cashWithdraw; 
    }


    @Override
    public boolean updateBalance(double transAmount) {
        if(transAmount > 0){
            increasecashValue(transAmount);
        }
        else
            decreasedcashValue(transAmount);
        return true;
    }
}
