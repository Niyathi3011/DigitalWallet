package services;

import System.DigitalWalletSystem;
import models.Transaction;
import models.Wallet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Integer.parseInt;

public class TransferMoney extends Commands {

    //private final int NUMBER_OF_FIELDS = 4;
    private static Logger logger = LoggerFactory.getLogger("TransferMoney.class");
    private static final int accountHolder1 = 1;
    private static final int accountHolder2 = 2;
    private static final int offsetAmount = 3;

    @Override
    public void execCommand(String[] commands, DigitalWalletSystem digitalWalletSystem) {

        logger.info("TransferMoney class is executed");
        Transaction debited = new Transaction(commands[accountHolder2], Transaction.Type.Debit, parseInt(commands[offsetAmount]));
        Transaction credited = new Transaction(commands[accountHolder1], Transaction.Type.Credit, parseInt(commands[offsetAmount]));

        Wallet wallet = digitalWalletSystem.getWalletList().get(commands[accountHolder1]);

        wallet.getTransactionList().add(debited);
        Wallet wallet1 = digitalWalletSystem.getWalletList().get(commands[accountHolder2]);
        if (wallet1 != null)
            wallet1.getTransactionList().add(credited);
        else {
            digitalWalletSystem.getWalletList().put(commands[accountHolder2], new Wallet());
            digitalWalletSystem.getWalletList().get(commands[accountHolder2]).getTransactionList().add(credited);
        }

    }
}

