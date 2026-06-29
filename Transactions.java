import java.util.stream.*;
import java.util.*;
class Transaction{
    double amount;
    String category,id;
    public Transaction( String id, String category, double amount){
        this.id = id;
        this.category = category;
        this.amount = amount;
    }
}
public class Transactions{
    List<Transaction> transactions;

    public Transactions(List<Transaction> transactions){
        this.transactions = transactions;
    }
    public static void main(String[] args){
        List<Transaction> transactions = new ArrayList<>(List.of(
        new Transaction("1","CREDIT",100),
        new Transaction("11","DEBIT",200),
        new Transaction("5","CREDIT",250),
        new Transaction("17","DEBIT",100),
        new Transaction("45","CREDIT",50),
        new Transaction("24","DEBIT",150)));
        
        Transactions transactionsObj = new Transactions(transactions);

        transactionsObj.findById("45")
                .ifPresentOrElse(
                    transaction -> 
                    System.out.println("id: "+ transaction.id+ " category: "+
                    transaction.category+" amount: "+transaction.amount),
                    () -> System.out.println("Transaction not found")
                );
        transactionsObj.largestAmountByCategory("DEBIT")
                .ifPresentOrElse(
                    transaction ->
                    System.out.println("id: "+ transaction.id+ " category: "
                    + transaction.category+ " amount: "+transaction.amount)
                    ,()-> System.out.println("No transactions in this category")
                );
        double totalCreditAmount = transactionsObj.totalCategoryAmount("CREDIT");
        System.out.println("Total credit amount is "+totalCreditAmount);

        List<String> idsList = transactionsObj.idsAbove(100);
        for(String id: idsList) System.out.println(id);



    }

    Optional<Transaction> largestAmountByCategory(String category){
        return transactions.stream()
                    .filter( transaction -> transaction.category.equals(category))
                    .max(Comparator.comparingDouble(transaction -> transaction.amount));
    }

    double totalCategoryAmount(String category){
        return transactions.stream()
                .filter(transaction -> transaction.category.equals(category))
                .mapToDouble(t->t.amount)
                .sum();

    }

    List<String> idsAbove(double threshold){
        return transactions.stream()
                .filter( t -> t.amount > threshold)
                .sorted(Comparator.comparingDouble((Transaction t) -> t.amount).reversed())
                .map( t -> t.id)
                .toList();
    }

    Optional<Transaction> findById(String id){
        return transactions.stream()
                    .filter( transaction -> transaction.id.equals(id))
                    .findFirst();

    }
}