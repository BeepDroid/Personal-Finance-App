import java.util.HashMap;
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
    
    ICategory category;
    String name;
    Date startDate;
    Date endDate;
    HashMap<ICategory, Double> budgetitems;

    
    public Budget(String name, Date startDate, Date endDate, HashMap<ICategory, Double> budgetItems){
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budgetItems = budgetItems;
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
        return budgetItems; //To change body of generated methods, choose Tools | Templates.
    }


}
