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
    private PersonalFinanceApp finance;
    protected double cashValue;
    
   ArrayList<Category> categories;
    Cash cash;
   ArrayList <Debit> debt;
    Budget budget;
   ArrayList <IAccount> credits;
   TransactionManager transactionManager;
   ArrayList <IAccount> debits;
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
      ArrayList credits = new ArrayList<IAccount>();
      ArrayList debits = new ArrayList<IAccount>();
      ArrayList categories = new ArrayList<Category>();
      ArrayList transaction = new ArrayList<ITransaction>();
      transactionManager = TransactionManager.getInstance();
    }
    
    public PersonalFinanceApp getInstance(){
       if (finance == null){
        finance = new PersonalFinanceApp();
       }
        return finance;
    }
    public Collection getCategories() {
   return Collections.unmodifiableCollection(categories);
   
   
}

    @Override
    public double getCash() {
        
     return cash.getValue();
    }

    @Override
    public boolean updateCash(double newAmount) {
     if (cash.value<0)
       return false;
       
     else if(cash.value > 0)
         cash.increasecashValue(newAmount);
        return true;
    }
    
    public IAccount findAccount(String name) {
        Iterable<IAccount> debits = null;
        Iterable<IAccount> credits = null;
        for (IAccount debit : debits) {
            if (debit.getName().equals(name)) {
                return debit;
            }
        }
        for(IAccount credit : credits){
            if(credit.getName().equals(name)){
                return credit;
            }
        }
        return null;
    }

    @Override
    public Collection<IAccount> getCreditCards() {
         return Collections.unmodifiableCollection(credits);
    }

    @Override
    public boolean addCreditCard(String name, double debt) {
        CreditCard card = new CreditCard(name, debt);
        credits.add(card);
        return true;
    }

    @Override
    public boolean removeCreditCard(String name) {
               IAccount account = findAccount(name);
            if(account.getName() != name){
                return false;
            }       
          credits.remove(name);
          return true;
    }

    @Override
    public boolean updateCreditCardName(String name, String newName) {
         if(creditcard.name != name){
            return false;}
         creditcard.name = newName;
        return true;
    }

    @Override
    public boolean updateCreditCardDebt(String name, double newDebt) {
        if(creditcard.name != name){
        return false; }
        creditcard.value = newDebt;
        return true;
    }

    @Override
    public Collection<IAccount> getDebitAccounts() {
         return Collections.unmodifiableCollection(debits);
    }

    @Override
    public boolean addDebitAccount(String name, double balance) {
        Debit debitcard = new Debit(name, balance);
        debits.add(debitcard);
        return true;
    }

    @Override
    public boolean removeDebitAccount(String name) {
             IAccount account = findAccount(name);
            if(account.getName() != name){
                return false;
            }       
          debits.remove(name);
          return true;
    }

    @Override
    public boolean updateDebitAccountName(String name, String newName) {
           if (debit.name != name){
            return false;
        } 
        debit.name = newName;
        return true;
    }

    @Override
    public boolean updateDebitAccountBalance(String name, double newBalance) {
        if (debit.name != name){
            return false;
        }
        debit.value = newBalance;
        return true;
    }

    @Override
    public boolean addCategory(String name, ICategory.TransactionType transactionType) {
      Category cat = new Category(name, transactionType);
      categories.add(cat);
      return true;
    }

    @Override
    public boolean removeCategory(String name) {
         categories.remove(name);
        return true;
    }

    @Override
    public boolean updateCategoryName(String name, String newName) {
              if(category.name != name){
           return false;
       }
       category.name = newName;
       return true;
    }

    @Override
    public boolean updateCategoryType(String name, ICategory.TransactionType newType) {
        if(category.name != name){
           return false;
       }
       category.transaction = newType;
       return true;
    }

    @Override
    public Collection<IBudget> getBudgets() {
          return Collections.unmodifiableCollection(myBudget);
    }
    
             public ICategory findCategory(String name) {
        Iterable<ICategory> categories = null;
        for (ICategory category : categories) {
            if (category.getName().equals(name)) {
                return category;
            }
        }
        return null;
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
                ICategory category = findCategory(categoryName);
            if (category == null) {
                return false;
                        }
                    else {
                m.put(category, items.get(categoryName));
            }
                    }
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
        ICategory category = findCategory(categoryName);
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
        ICategory category = findCategory(newCategoryName);
        ITransaction transaction = transactionManager.findTransaction(id);
        transaction.updateCategory(category);
        return true;
    }

    @Override
    public boolean getStatus(String budgetName, Map<ICategory, Double> projected, Map<ICategory, Double> actual) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
            
    
    
    
    
    
}
