package services;

import models.Result;
import models.Transaction;
import models.Wallet;

import java.util.ArrayList;

public class CreateWallet extends Commands {

    @Override
    public Result execCommand(String[] commands) {

        Transaction transaction = new Transaction(commands[1], Transaction.Type.Credit, Integer.valueOf(commands[2]));
        for (Wallet wallet : digitalWalletSystem.getWalletList().values()) {
            if (wallet.getName().equalsIgnoreCase(commands[1])) {
                wallet.getTransactionList().add(transaction);}
                else{
                    digitalWalletSystem.getWalletList().put(k, new Wallet(commands[1], new ArrayList<>()));
                    digitalWalletSystem.getWalletList().get(k).getTransactionList().add(transaction);
                }
            }

         return null;
        }

    }
}
