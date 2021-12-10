
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Javon LaCour
 */
public class AccountManager {
    ArrayList <IAccount> accounts;
   
 public AccountManager(){
     accounts = new ArrayList<IAccount>();
 } 
 
  public boolean addAccount(String name, double value) {
        if (name==null || name.trim().length() ==0)
         return false;
       
        if(value<0)
         return false;
        IAccount testaccount = find(name);
        if(testaccount!= null)
        if (name.contains(name))
         return false;
        
        IAccount account = new Account(name, value);
        accounts.add(account);
         return true;
        
      
        
        
        
    }
  
  public boolean removeAccount(String name) {
          if(accounts.isEmpty()) 
              return false;
          IAccount account = find(name);
            if(account == null){
                return false;
            }       
          accounts.remove(account);
          return true;
    }
  
   public IAccount find(String name) {
        for (IAccount account : accounts) {
            if (account.getName().equals(name)) {
                return account;
            }
        
        
        }     
       return null;
    }
   public Collection<IAccount> getAccounts() {
         return Collections.unmodifiableCollection(accounts);
    }
   public boolean updateAccountName(String name,String newName){
        if (newName==null || newName.trim().length() ==0)
         return false;
        IAccount testaccount = find(newName);
        if(testaccount!= null)
         return false;
       if(accounts.isEmpty()) 
              return false;
       Account account = (Account)find (name);
       if(account == null)
           return false;
       account.setName(newName);
       return true;
   }
   public boolean updateAccountValue(String name, double value){
       if(accounts.isEmpty()) 
        return false;
       if(value<0)
        return false;       
       Account account = (Account)find (name);
       if(account == null)
        return false;
       account.setValue(value);
       return true;
   }
}




