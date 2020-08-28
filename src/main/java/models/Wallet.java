package models;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class Wallet {

    private final List<Transaction> transactions;
    private int amount;
    private final String name;

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public Wallet(String name, int amount) {
        this.name = name;
        this.amount = amount;
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
        if (transaction.getType() == Transaction.Type.CREDIT)
            amount += transaction.getAmount();
        else
            amount -= transaction.getAmount();

    }

    public int getAmount() {
        return amount;
    }
}
