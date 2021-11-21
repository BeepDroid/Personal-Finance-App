/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kebey
 */
public class Debit extends Account {
    
    public Debit(String name, double value) {
        super(name, value);
    }
    
    @Override
    public double getValue(){
        return value;  
    }
    
}
