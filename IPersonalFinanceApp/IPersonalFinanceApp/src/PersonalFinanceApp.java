import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
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
   ArrayList <Debt> debt;
    Budget budget;
   ArrayList <CreditCard> credit;
    CashTransaction cashtransaction;
    CreditCard creditcard;
    Debit debitcard;
    
    private PersonalFinanceApp(){
        cash = new Cash("cash",0);
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
     if (cash.Value<0)
       return false;
       
     else if(cash.Value > 0)
         cash.increasevalue(newAmount);
        return true;
    }

    @Override
    public Collection<IAccount> getCreditCards() {
         return Collections.unmodifiableCollection(credit);
    }

    @Override
    public boolean addCreditCard(String name, double debt) {
        CreditCard card = new CreditCard(name, debt);
        credit.add(card);
        return true;
    }

    @Override
    public boolean removeCreditCard(String name) {
         int index = credit.size();
        if(index <= 0){
            return false;
        }
        int lastElement = index - 1;
        credit.remove(lastElement);
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
         return Collections.unmodifiableCollection(debit);
    }

    @Override
    public boolean addDebitAccount(String name, double balance) {
        Debit debitcard = new Debit(name, balance);
        debit.add(debitcard);
        return true;
    }

    @Override
    public boolean removeDebitAccount(String name) {
          int indexD = debit.size();
        if(indexD <= 0){
            return false;
        }
        int lastElementD = indexD - 1;
        debit.remove(lastElementD);
        return true;
    }

    @Override
    public boolean updateDebitAccountName(String name, String newName) {
           if (debitcard.name != name){
            return false;
        } 
        debitcard.name = newName;
        return true;
    }

    @Override
    public boolean updateDebitAccountBalance(String name, double newBalance) {
        if (debitcard.name != name){
            return false;
        }
        debitcard.value = newBalance;
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
        int indexC = categories.size();
        if (indexC <= 0){
            return false;
        }
        int lastElementC = indexC - 1;
        categories.remove(lastElementC);
        return true;
    }

    @Override
    public boolean updateCategoryName(String name, String newName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateCategoryType(String name, ICategory.TransactionType newType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<IBudget> getBudgets() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addBudget(String name, Date startDate, Date endDate, Map<String, Double> items) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeBudget(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateBudgetName(String name, String newName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateBudgetStartDate(String name, Date newStartDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateBudgetEndDate(String name, Date newEndDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addOrUpdateBudgetItem(String name, String categoryName, double value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeBudgetItem(String name, String categoryName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Itransaction> getTransactions(Date startDate, Date endDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int addTransaction(Date date, String description, double amount, String categoryName, String accountName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeTransaction(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateTransactionDate(int id, Date newDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateTransactionDescription(int id, String newDescription) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateTransactionAmount(int id, double newAmount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateTransactionCategory(int id, String newCategoryName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean getStatus(String budgetName, Map<ICategory, Double> projected, Map<ICategory, Double> actual) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
            
    
    
    
    
    
}
