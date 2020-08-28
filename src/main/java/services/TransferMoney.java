package services;

import System.DigitalWalletSystem;
import models.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Integer.parseInt;

public class TransferMoney extends Service {

    //private final int NUMBER_OF_FIELDS = 4;
    private static Logger logger = LoggerFactory.getLogger("TransferMoney.class");
    private static final int CREDIT_HOLDER = 1;
    private static final int DEBIT_HOLDER = 2;
    private static final int AMOUNT_OFFSET = 3;

    public TransferMoney(DigitalWalletSystem digitalWalletSystem) {
        super(digitalWalletSystem);
    }

    @Override
    public void executeCommand(String[] commandArgs) {

        logger.info("TransferMoney class is executed");
        Transaction debited = new Transaction(commandArgs[DEBIT_HOLDER], Transaction.Type.DEBIT, parseInt(commandArgs[AMOUNT_OFFSET]));
        Transaction credited = new Transaction(commandArgs[CREDIT_HOLDER], Transaction.Type.CREDIT, parseInt(commandArgs[AMOUNT_OFFSET]));
        getDigitalWalletSystem().addTransaction(commandArgs[CREDIT_HOLDER], debited);
        getDigitalWalletSystem().addTransaction(commandArgs[DEBIT_HOLDER], credited);

        if (getDigitalWalletSystem().getAmount(commandArgs[CREDIT_HOLDER]) == getDigitalWalletSystem().getAmount(commandArgs[DEBIT_HOLDER])) {
            offer(commandArgs[CREDIT_HOLDER], commandArgs[DEBIT_HOLDER]);
        }

    }

    public void offer(String creditHolder, String debitHolder) {

        Transaction transaction = new Transaction("Offer1", Transaction.Type.CREDIT, 10);
        getDigitalWalletSystem().addTransaction(creditHolder, transaction);
        getDigitalWalletSystem().addTransaction(debitHolder, transaction);
    }
}

