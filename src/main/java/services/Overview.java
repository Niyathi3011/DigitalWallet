package services;

import System.DigitalWalletSystem;
import models.Wallet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class Overview extends Service {

    private static Logger logger = LoggerFactory.getLogger("Overview.class");

    public Overview(DigitalWalletSystem digitalWalletSystem) {
        super(digitalWalletSystem);
    }


    @Override
    public void executeCommand(String[] commandArgs) {

        logger.info("Command Overview is executed");

        for (Map.Entry<String, Wallet> entry : getDigitalWalletSystem().getWalletList().entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().getAmount());
        }

    }
}
