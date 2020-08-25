package models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Wallet {

    private final String name;
    private final List<Transaction> transactionList;

    public int getTotalAmount() {
        int sum = 0;
        for (Transaction transaction : this.transactionList) {
            if (transaction.getType() == Transaction.Type.Credit)
                sum += transaction.getAmount();
            else
                sum = sum - transaction.getAmount();

        }

        return sum;

    }

}
