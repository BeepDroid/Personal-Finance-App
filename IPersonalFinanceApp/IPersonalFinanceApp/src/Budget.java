
import java.util.Date;
import java.util.Map;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kebey
 */
public class Budget implements IBudget{
    
    IAccount account;
    DebitAccount debit;
    CashAccount cash;
    ICategory category;
    String name;
    Date startDate;
    Date endDate;

    
    public Budget(ICategory category, String name, Date startDate, Date endDate){
        this.category = category;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    
    

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Date getStartDate() {
       return startDate; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Date getEndDate() {
        return endDate; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<ICategory, Double> getItems() {
        return (Map<ICategory, Double>) category; //To change body of generated methods, choose Tools | Templates.
    }


}
