package services;

import models.Result;
import models.Transaction;
import models.Wallet;

public class TransferMoney extends Commands {


    @Override
    public Result execCommand(String[] commands) {

        Transaction transaction=new Transaction(commands[2], Transaction.Type.Debit,Integer.valueOf(commands[3]));
        Transaction transaction1=new Transaction(commands[1], Transaction.Type.Credit,Integer.valueOf(commands[3]));
        for(Wallet wallet:digitalWalletSystem.getWalletList().values()){
            if(wallet.getName().equalsIgnoreCase(commands[1]))
                wallet.getTransactionList().add(transaction);
            else if(wallet.getName().equalsIgnoreCase(commands[2]))
                wallet.getTransactionList().add(transaction1);
        }

        return null;
    }

    public void checkForOffer1(String account1,String account2){

        int sum1=0,sum2=0;
        Transaction transaction=new Transaction("offer1", Transaction.Type.Credit,10);
        for(Wallet wallet:digitalWalletSystem.getWalletList().values()){
            if(wallet.getName().equalsIgnoreCase(account1))
                sum1=wallet.getTotalAmount();
            else if(wallet.getName().equalsIgnoreCase(account2))
                sum2=wallet.getTotalAmount();
        }

        if(sum1==sum2){
            for(Wallet wallet:digitalWalletSystem.getWalletList().values()){
                if(wallet.getName().equalsIgnoreCase(account1))
                    wallet.getTransactionList().add(transaction);
                else if(wallet.getName().equalsIgnoreCase(account2))
                    wallet.getTransactionList().add(transaction);
            }

        }

    }
}
