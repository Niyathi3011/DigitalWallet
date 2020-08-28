package services;

import System.DigitalWalletSystem;
import models.Transaction;
import models.Wallet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Statement extends Commands {

    private static Logger logger = LoggerFactory.getLogger(Statement.class);

    // private final int NUMBER_OF_FIELDS = 2;
    private static final int accountHolder = 1;

    @Override
    public void execCommand(String[] commands, DigitalWalletSystem digitalWalletSystem) {

        logger.info("Command Statement is executed");

        Wallet wallet = digitalWalletSystem.getWalletList().get(commands[accountHolder]);
        for (Transaction transaction : wallet.getTransactionList()) {
            if (!transaction.getName().equalsIgnoreCase(commands[accountHolder])) {
                System.out.println(transaction.getName() + " " + transaction.getType() + " " + transaction.getAmount());
            }
        }

    }
}
