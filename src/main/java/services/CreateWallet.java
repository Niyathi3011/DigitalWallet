package services;

import models.Result;
import models.Transaction;
import models.Wallet;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class CreateWallet extends Commands {

    private final int NUMBER_OF_FIELDS = 3;

    @Override
    public Result execCommand(String[] commands) {

        if (commands.length != NUMBER_OF_FIELDS) {
            System.out.println("Wrong input");
            return null;
        }

        String accountHolder = commands[1];
        int amount = parseInt(commands[2]);

        if (amount < digitalWalletSystem.getMIN_AMOUNT()) {
            System.out.println("Amount less than required");
            return null;
        }

        Transaction transaction = new Transaction(accountHolder, Transaction.Type.Credit, amount);

        for (Wallet wallet : digitalWalletSystem.getWalletList().values()) {
            if (wallet.getName().equalsIgnoreCase(accountHolder)) {
                wallet.getTransactionList().add(transaction);
                return null;
            }
        }
        digitalWalletSystem.getWalletList().put(size, new Wallet(accountHolder, new ArrayList<>()));
        digitalWalletSystem.getWalletList().get(size).getTransactionList().add(transaction);

        size++;
        return null;
    }

}

