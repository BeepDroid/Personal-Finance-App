
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kebey
 */
class TransactionManager {
    private static TransactionManager manager;
    private  ArrayList <ITransaction> transactions;
    private int currentID;
    
    private TransactionManager(){
        transactions = new ArrayList<ITransaction>();
    }
    
    public static TransactionManager getInstance(){
        if(manager == null){
            manager = new TransactionManager();
        }
        return manager;
    }
    
    Collection<ITransaction> getTransactions(Date startDate, Date endDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
   // public Collection<ITransaction> getTransactions(Date startDate, Date endDate) {
    //    return Collections.unmodifiableCollection(transactions);
  //  }
    
    public int getNextID(){
        currentID++;
        return currentID;   
    }
    
    public ITransaction findTransaction(int id){
         for (ITransaction transaction : transactions) {
            if (transaction.getId() == id) {
                return transaction;
            }
           
        }
          return null;
    }
    
    public boolean removeTransaction(int id) {
       ITransaction transaction = findTransaction(id);
       if(transaction == null){
           return false;
       }
       transactions.remove(transaction);
       return true;
    }
    
    public int addTransaction(Date date, String description, double amount, ICategory category, IAccount account){
        if(date == null || date.after(new Date())){
            return -1;
        }
        if(description == null || description.trim().length() == 0){
            return -1;
        }
        if(amount < 0){
            return -1;
        }
                
        if(category == null || account == null){
            return -1;
        }
        
        if(account.getValue() - amount < 0){
            return -1;
        }

        int newId = getNextID();
            ITransaction transaction = new Transaction(newId, date, amount, category, account, description);
            return newId;
    }

  

    
}
