/**
 *
 * @author Javon LaCour
 */
public class Category implements ICategory {

    String name;
    TransactionType transaction;
    
    public Category(String name, TransactionType transaction){
        this.name = name;
        this.transaction = transaction;
    }
    
    
    @Override
    public String getName() {
        return name; 
    }

    @Override
    public TransactionType getType() {
        return transaction; 
    }
    
    
}

