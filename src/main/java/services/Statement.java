package services;

import models.Result;
import models.Transaction;
import models.Wallet;

public class Statement extends Commands {

    private final int NUMBER_OF_FIELDS = 2;

    @Override
    public Result execCommand(String[] commands) {

        if (commands.length != NUMBER_OF_FIELDS) {
            System.out.println("Input has wrong number of fields");
            return null;
        }

        String accountHolder = commands[1];

        for (Wallet wallet : digitalWalletSystem.getWalletList().values()) {
            if (wallet.getName().equalsIgnoreCase(accountHolder)) {
                for (Transaction transaction : wallet.getTransactionList()) {
                    if (!transaction.getName().equalsIgnoreCase(accountHolder)) {
                        System.out.println(transaction.getName() + transaction.getType() + transaction.getAmount());
                    }
                }
            }
        }
        return null;
    }
}
