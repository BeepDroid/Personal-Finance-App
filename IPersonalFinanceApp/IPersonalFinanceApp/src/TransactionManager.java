
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
public class TransactionManager {
    private TransactionManager manager;
    private  ArrayList <ITransaction> transactions;
    
    public TransactionManager(){
        transactions = new ArrayList<ITransaction>();
    }
    
    public Collection<ITransaction> getTransactions(Date startDate, Date endDate) {
        return Collections.unmodifiableCollection(transactions);
    }
    
 
}
