package services;

import System.DigitalWalletSystem;
import models.Transaction;
import models.Wallet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Statement extends Service {

    private static Logger logger = LoggerFactory.getLogger(Statement.class);

    // private final int NUMBER_OF_FIELDS = 2;
    private static final int accountHolder = 1;

    public Statement(DigitalWalletSystem digitalWalletSystem) {
        super(digitalWalletSystem);
    }

    @Override
    public void executeCommand(String[] commandArgs) {

        logger.info("Command Statement is executed");

        Wallet wallet = getDigitalWalletSystem().getWalletList().get(commandArgs[accountHolder]);
        for (Transaction transaction : wallet.getTransactions())
            System.out.println(transaction.getName() + " " + transaction.getType() + " " + transaction.getAmount());


    }
}

