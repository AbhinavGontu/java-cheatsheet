import java.lang.*;

class InsufficientFundsException extends Exception{
    public InsufficientFundsException(String m){
        super(m);
    }
}
public class BankAccount{
    double balance;
    public BankAccount(double balance){ this.balance = balance;}
    void withdraw(double amount)throws InsufficientFundsException{
            if( (balance-amount) < 0)
                throw new InsufficientFundsException("Insufficent funds in the account");

        balance -= amount;
       System.out.println("Balance : "+ balance);

    }
    void deposit(double amount){
            if(amount <= 0)
                throw new IllegalArgumentException("Deposit amount must be positive");
        
        balance += amount;
        System.out.println("Balance : "+ balance);

            
   }

   public static void main(String[] args) throws InsufficientFundsException {
       BankAccount baObj = new BankAccount(100);
       baObj.deposit(100);
       try{
       baObj.deposit(-1);
       }
       catch(IllegalArgumentException e){
        System.out.println(e);
       }
       baObj.withdraw(100);
       baObj.withdraw(120);
   }

}