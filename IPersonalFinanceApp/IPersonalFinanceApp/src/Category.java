/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Javon LaCour
 */
public class Category implements ICategory {
   String name;
    TransactionType transaction;
    
    public Category(String name, TransactionType transaction){
        this.name = name;
        this.transaction = transaction;
    }
    
    
    @Override
    public String getName() {
        return name; 
    }

    @Override
    public TransactionType getType() {
        return transaction; 
    }
     public void setName(String newName){
       this.name = newName;
   } 
    public void setTransaction(TransactionType transactiontype){
       this.transaction = transactiontype;  
    }
    
}
  

