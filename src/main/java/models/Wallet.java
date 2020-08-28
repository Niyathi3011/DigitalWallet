package models;


import java.util.ArrayList;
import java.util.List;

public class Wallet {

    private final List<Transaction> transactionList;
    private int amount;

    public List<Transaction> getTransactionList() {
        return transactionList;
    }


    public Wallet() {
        this.transactionList = new ArrayList<>();
    }

    public int getAmount() {

        amount = 0;
        for (Transaction transaction : transactionList) {
            if (transaction.getType() == Transaction.Type.Credit)
                amount += transaction.getAmount();
            else
                amount -= transaction.getAmount();

        }
        return amount;
    }

}
