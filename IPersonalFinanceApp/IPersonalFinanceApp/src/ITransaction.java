import java.util.Date;

/**
 *
 * @author EBONY
 */
public interface ITransaction {
   /**
    * @return - the autogenerated integer id of the transaction
    */
   int getId();

   /**
    * @return - the date of the transaction
    */
   Date getDate();

   /**
    * @return - the description of the transaction
    */
   String getDescription();

   /**
    * @return - the amount of the transaction
    */
   Double getAmount();

   /**
    * @return - the category of the transaction
    */
   ICategory getCategory();

   /**
    * @return - the account with which the transaction is associated
    */
   IAccount getAccount();
}
   
