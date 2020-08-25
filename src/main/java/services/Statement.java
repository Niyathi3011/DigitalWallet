package services;

import models.Result;
import models.Transaction;
import models.Wallet;

public class Statement extends Commands {


    @Override
    public Result execCommand(String[] commands) {
        for(Wallet wallet:digitalWalletSystem.getWalletList().values()){
            if(wallet.getName().equalsIgnoreCase(commands[1])){
                for(Transaction transaction:wallet.getTransactionList()){
                    if(!transaction.getName().equalsIgnoreCase(commands[1])){
                        System.out.println(transaction.getName()+transaction.getType()+transaction.getAmount());
                    }
                }
            }
        }
        return null;
    }
}
