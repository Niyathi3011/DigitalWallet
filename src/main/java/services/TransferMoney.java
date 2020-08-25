package services;

import models.Result;
import models.Transaction;
import models.Wallet;

public class TransferMoney extends Commands {

    private final int NUMBER_OF_FIELDS = 4;

    @Override
    public Result execCommand(String[] commands) {

        if (commands.length != NUMBER_OF_FIELDS) {
            System.out.println("Wrong number of fields");
            return null;
        }

        String accountHolder1 = commands[1];
        String accountHolder2 = commands[2];
        int amount = Integer.valueOf(commands[3]);

        Transaction transaction = new Transaction(accountHolder2, Transaction.Type.Debit, amount);
        Transaction transaction1 = new Transaction(accountHolder1, Transaction.Type.Credit, amount);

        for (Wallet wallet : digitalWalletSystem.getWalletList().values()) {
            if (wallet.getName().equalsIgnoreCase(accountHolder1))
                wallet.getTransactionList().add(transaction);
            else if (wallet.getName().equalsIgnoreCase(accountHolder2))
                wallet.getTransactionList().add(transaction1);
        }

        checkForOffer1(accountHolder1, accountHolder2);
        return null;
    }

    public void checkForOffer1(String accountHolder1, String accountHolder2) {

        int sum1 = 0, sum2 = 0;
        Transaction transaction = new Transaction("offer1", Transaction.Type.Credit, 10);
        for (Wallet wallet : digitalWalletSystem.getWalletList().values()) {
            if (wallet.getName().equalsIgnoreCase(accountHolder1))
                sum1 = wallet.getTotalAmount();
            else if (wallet.getName().equalsIgnoreCase(accountHolder2))
                sum2 = wallet.getTotalAmount();
        }

        if (sum1 == sum2) {
            for (Wallet wallet : digitalWalletSystem.getWalletList().values()) {
                if (wallet.getName().equalsIgnoreCase(accountHolder1))
                    wallet.getTransactionList().add(transaction);
                else if (wallet.getName().equalsIgnoreCase(accountHolder2))
                    wallet.getTransactionList().add(transaction);
            }

        }

    }
}
