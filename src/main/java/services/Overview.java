package services;

import System.DigitalWalletSystem;
import models.Wallet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class Overview extends Commands {
    private static Logger logger = LoggerFactory.getLogger("Overview.class");

    private final int NUMBER_OF_FIELDS = 1;


    @Override
    public void execCommand(String[] commands, DigitalWalletSystem digitalWalletSystem) {

        logger.info("Command Overview is executed");

        for (Map.Entry<String, Wallet> entry : digitalWalletSystem.getWalletList().entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().getAmount());
        }

    }
}
