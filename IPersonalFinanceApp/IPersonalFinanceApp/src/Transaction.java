import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kebey
 */
public class Transaction implements ITransaction {
    protected int ID;
    protected Date date;
    protected String description;
    protected Double amount;
    ICategory category;
    IAccount account;
    
    
     public Transaction(int ID, Date date, double amount, ICategory category, IAccount account, String description){
        this.ID = ID;
        this.date = date;
        this.amount = amount;
        this.category = category;
        this.account = account;
        this.description = description;
        this.account.updateBalance(amount);
    }
    
    

    @Override
    public int getId() {
        return ID;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Double getAmount() {
        return amount;
    }

    @Override
    public ICategory getCategory() {
        return category;
    }

    @Override
    public IAccount getAccount() {
        return account;
    }
    
    public void updateCategory(ICategory category){
        this.category = category;
    }
    
}
