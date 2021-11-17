/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kebey
 */
public class DebitTransaction implements ITransaction{
    
    protected int ID;
    protected Date date;
    protected String description;
    protected Double amount;
    ICategory category;
    IAccount account;
    
    public DebitTransaction(int ID, Date date, ICategory category, IAccount account, String description){
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
