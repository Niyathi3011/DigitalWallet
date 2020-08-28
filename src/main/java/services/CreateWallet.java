package services;

import System.DigitalWalletSystem;
import models.Transaction;
import models.Wallet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Integer.parseInt;

public class CreateWallet extends Commands {

    private static final Logger logger = LoggerFactory.getLogger(CreateWallet.class);

    //private final int NUMBER_OF_FIELDS = 3;
    private static final int accountName = 1;
    private static final int amountOffset = 2;

    @Override
    public void execCommand(String[] commands, DigitalWalletSystem digitalWalletSystem) {

        logger.info("CreateWallet Command is executed");
        Transaction transaction = new Transaction(commands[accountName], Transaction.Type.Credit, parseInt(commands[amountOffset]));
        digitalWalletSystem.getWalletList().put(commands[accountName], new Wallet());
        digitalWalletSystem.getWalletList().get(commands[accountName]).getTransactionList().add(transaction);

    }
}

