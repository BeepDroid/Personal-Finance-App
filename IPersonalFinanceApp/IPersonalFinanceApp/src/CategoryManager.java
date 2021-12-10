
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
public class CategoryManager {
  ArrayList<ICategory> categories;  
 public CategoryManager(){
    categories =  new ArrayList<ICategory>(); 
 }
 public Collection getCategories() {
   return Collections.unmodifiableCollection(categories);
}
public boolean addCategory(String name, ICategory.TransactionType transactionType) {
     ICategory testcategory = find(name);
        if(testcategory != null)
         return false;
    
    if (name==null || name.trim().length() ==0)
         return false;
     if (transactionType==null)
         return false;
    Category cat = new Category(name, transactionType);
      categories.add(cat);
      return true;
    }

    
    public boolean removeCategory(String name) {
        ICategory category = find(name); 
        if(category==null)
           return false;
        categories.remove(category);
        return true;
    }

    
    public boolean updateCategoryName(String name, String newName) {
         if (newName==null || newName.trim().length() ==0)
         return false;
        ICategory testcategory = find(newName);
        if(testcategory != null)
         return false;
       if(categories.isEmpty()) 
        return false;
       Category category = (Category)find (name);
       if(category == null)
           return false;
       category.setName(newName);
       return true;
    }

   
    public boolean updateCategoryType(String name, ICategory.TransactionType newType) {
        
       Category category = (Category)find(name);
       category.setTransaction(newType);
       return true;
    }
     public ICategory find(String name) {
        for (ICategory category : categories) {
            if (category.getName().equals(name)) {
                return category;
            }
        }
        return null;
    }
}


