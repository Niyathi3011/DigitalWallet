package services;

import System.DigitalWalletSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Integer.parseInt;

public class CreateWallet extends Service {

    private static final Logger logger = LoggerFactory.getLogger(CreateWallet.class);

    //private final int NUMBER_OF_FIELDS = 3;
    private static final int ACCOUNT_NAME_OFFSET = 1;
    private static final int AMOUNT_OFFSET = 2;

    public CreateWallet(DigitalWalletSystem digitalWalletSystem) {
        super(digitalWalletSystem);
    }

    @Override
    public void executeCommand(String[] commandArgs) {

        logger.info("CreateWallet Command is executed");
        getDigitalWalletSystem().createWallet(commandArgs[ACCOUNT_NAME_OFFSET], parseInt(commandArgs[AMOUNT_OFFSET]));
    }
}

