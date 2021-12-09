
public interface IAccount {
   /**
    * @return - he name of the account
    */
   String getName();

   /**
    * @return - the value of the account. In case of cash its the cash value, in case of credit its the debt, and in case
    * of debit, its the account balance
    */
   double getValue();
   
   public abstract boolean updateBalance(double transAmount);
}
