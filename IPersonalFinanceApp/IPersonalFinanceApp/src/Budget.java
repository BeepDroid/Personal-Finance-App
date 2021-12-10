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

    
    public Budget(String name, Date startDate, Date endDate, HashMap<ICategory, Double> budgetitems){
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budgetitems = budgetitems;
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
        return budgetitems; //To change body of generated methods, choose Tools | Templates.
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
    
    public boolean addOrUpdateBudgetItem(String categoryName, double value){
        budgetitems.put(findCategory(categoryName), value);
        return true;
    }
    
     public boolean removeBudgetItem(String name, String categoryName){
        budgetitems.remove(name, categoryName);
        return true;
    }
    
    //HashMap<ICategory, Double> firstBudget; 
    //firstBudget = new HashMap<ICategory, Double>(); -- hwo to make a HashMap in the main class. Above is included.
    //firstBudget.put(new Category("Housing", Category.TransactionType.EXPENDITURE), 500.00); -- How to use this with the Category class.


}
