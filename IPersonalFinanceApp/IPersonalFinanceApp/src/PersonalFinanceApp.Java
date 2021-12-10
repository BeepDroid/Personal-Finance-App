import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 
/**
 *
 * @author EBONY
 */
public class PersonalFinanceApp implements IPersonalFinance {
    private static PersonalFinanceApp finance;
    protected double cashValue;
    
   CategoryManager categories;
    Cash cash;
   ArrayList <Debit> debt;
    Budget budget;
   AccountManager  credits;
   TransactionManager transactionManager;
   AccountManager debits;
   ArrayList <Budget> myBudget;
   CreditCard creditcard;
   Debit debit;
   Category category;
   Transaction transaction;
  // CashTransaction cashTrans;
  // CreditCardTransaction cardTrans;
   DebitTransaction debitTrans;
    
    private PersonalFinanceApp(){
       cash = new Cash("cash",0);
       credits = new AccountManager();
       debits = new AccountManager();
       categories = new CategoryManager();
       transactionManager =  TransactionManager.getInstance();
       myBudget = new ArrayList<Budget>();
      
    }
    
    public static PersonalFinanceApp getInstance(){
       if (finance == null){
        finance = new PersonalFinanceApp();
       }
        return finance;
    }
    public Collection getCategories() {
       return categories.getCategories();
    }

    @Override
    public double getCash() {
        
     return cash.getValue();
    }

    @Override
    public boolean updateCash(double newAmount) {   
     if (newAmount<0)     
       return false;
       
        return cash.updateBalance(newAmount);
    }
    
    public IAccount findAccount(String name) {
        IAccount account = credits.find(name);
        if(account==null)
        account = debits.find(name);
         return account;
    }

    @Override
    public Collection<IAccount> getCreditCards() {
         return credits.getAccounts();
    }

    @Override
    public boolean addCreditCard(String name, double debt) {
      return credits.addAccount(name, debt);
    }

    @Override
    public boolean removeCreditCard(String name) {
                     
          return credits.removeAccount(name);
          
    }

    @Override
    public boolean updateCreditCardName(String name, String newName) {
         return credits.updateAccountName(name, newName);    }

    @Override
    public boolean updateCreditCardDebt(String name, double newDebt) {
        return credits.updateAccountValue(name, newDebt);
    }

    @Override
    public Collection<IAccount> getDebitAccounts() {
         return debits.getAccounts();
    }

    @Override
    public boolean addDebitAccount(String name, double balance) {
        return debits.addAccount(name, balance);
        
    }

    @Override
    public boolean removeDebitAccount(String name) {
            return debits.removeAccount(name);
    }

    @Override
    public boolean updateDebitAccountName(String name, String newName) {
        return debits.updateAccountName(name, newName);
        
    }

    @Override
    public boolean updateDebitAccountBalance(String name, double newBalance) {
         return debits.updateAccountValue(name, newBalance);
    }

    @Override
    public boolean addCategory(String name, ICategory.TransactionType transactionType) {
      return categories.addCategory(name, transactionType);
    }

    @Override
    public boolean removeCategory(String name) {
        return categories.removeCategory(name);
    }

    @Override
    public boolean updateCategoryName(String name, String newName) {
        return categories.updateCategoryName(name, newName);
      
    }

    @Override
    public boolean updateCategoryType(String name, ICategory.TransactionType newType) {
        return categories.updateCategoryType(name, newType);
    }

    @Override
    public Collection<IBudget> getBudgets() {
          return Collections.unmodifiableCollection(myBudget);
    }
   
             
    public IBudget findBudget(String name){
        Iterable<IBudget> myBudget = null;
        for (IBudget budget : myBudget){
            if (budget.getName().equals(name)) {
                return budget;
            }
        
        }
        return null;
    }

    @Override
    public boolean addBudget(String name, Date startDate, Date endDate, Map<String, Double> items) {
        HashMap m = new HashMap<>();
            for (String categoryName : items.keySet()) {
                ICategory category = categories.find(categoryName);
            if (category == null) {
                return false;
                        }
                    else {
                m.put(category, items.get(categoryName));
            }
                    }
            System.out.println(m);
            Budget thisBudget = new Budget(name, startDate, endDate, m);
            myBudget.add(thisBudget);
        return true;    
    }   

    @Override
    public boolean removeBudget(String name) {
            int indexB = myBudget.size();
        if (indexB <= 0){
            return false;
        }
        int lastElementB = indexB - 1;
        myBudget.remove(lastElementB);
        return true;
    }

    @Override
    public boolean updateBudgetName(String name, String newName) {
        if(budget.name != name){
            return false;
        }
        budget.name = newName;
        return true;
    }

    @Override
    public boolean updateBudgetStartDate(String name, Date newStartDate) {
        if(budget.name != name){
            return false;
        }
        budget.startDate = newStartDate;
        return true;
    }
    
    

    @Override
    public boolean updateBudgetEndDate(String name, Date newEndDate) {
        if(budget.name != name){
            return false;
        }
        budget.endDate = newEndDate;
        return true;
    }

    //Ask for help with this one
    @Override
    public boolean addOrUpdateBudgetItem(String name, String categoryName, double value) {
        IBudget budget = findBudget(name);
        if(budget == null){
            return false;
        }
        ((Budget)budget).addOrUpdateBudgetItem(categoryName, value);
        return true;
    }

    //This one too.
    @Override
    public boolean removeBudgetItem(String name, String categoryName) {
             IBudget budget = findBudget(name);
        if(budget == null){
            return false;
        }
        ((Budget)budget).removeBudgetItem(name, categoryName);
        return true;
    }

    //This one probably works?
    @Override
    public Collection<ITransaction> getTransactions(Date startDate, Date endDate) {
        return transactionManager.getTransactions(startDate, endDate);
    }

    //This one I ALSO need help with
    @Override
    public int addTransaction(Date date, String description, double amount, String categoryName, String accountName) {
        ICategory category = categories.find(categoryName);
        IAccount account = findAccount(accountName);
        return transactionManager.addTransaction(date, description, amount, category, account);        
    }

    @Override
    public boolean removeTransaction(int id) {
        return transactionManager.removeTransaction(id);
    }

    
    //This one probably doesn't work as intended. Logic error expected. 
    @Override
    public boolean updateTransactionDate(int id, Date newDate) {
        if(id != transaction.getId()) {
            return false;
        }
        transaction.getDate();
        newDate = transaction.getDate();
        return true;
    }

    @Override
    public boolean updateTransactionDescription(int id, String newDescription) {
        if(id != transaction.getId()){
            return false;
        }
        transaction.description = newDescription;
        return true;
    }

    @Override
    public boolean updateTransactionAmount(int id, double newAmount) {
        if(id != transaction.getId()){
            return false;
        }
        transaction.amount = newAmount;
        return true;
    }

    //Yeaaaah need help with this one too. Make a note to email her with a request for a zoom call.
    @Override
    public boolean updateTransactionCategory(int id, String newCategoryName) {
        if(id != transaction.getId()){
            return false;
        }
        ICategory category = categories.find(newCategoryName);
        ITransaction transaction = transactionManager.findTransaction(id);
        transaction.updateCategory(category);
        return true;
    }

    @Override
    public boolean getStatus(String budgetName, Map<ICategory, Double> projected, Map<ICategory, Double> actual) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
            
    
    
    
    
    
}
   


    
            
