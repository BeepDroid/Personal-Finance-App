/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Date;
/**
 *
 * @author EBONY
 */
public class CashTransaction implements ITransaction {
    protected int ID;
    //I know the all caps ID is bad for a variable I promise to fix it when I get things working pls mercy
    protected Date date;
    protected String description;
    protected Double amount = 0.00;
    ICategory category;
    IAccount account;
    
    public CashTransaction(int ID, Date date, ICategory category, IAccount account, String description){
        this.ID = ID;
        this.date = date;
        this.category = category;
        this.account = account;
        this.description = description;
    }

    @Override
    public int getId() {
        return ID; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Date getDate() {
        return date; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDescription() {
        return description; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Double getAmount() {
        return amount; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ICategory getCategory() {
        return category; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IAccount getAccount() {
        return account; //To change body of generated methods, choose Tools | Templates.
    }
}
