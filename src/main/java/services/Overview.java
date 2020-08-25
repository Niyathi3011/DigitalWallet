package services;

import models.Result;
import models.Wallet;

public class Overview extends Commands {
    private final int NUMBER_OF_FIELDS = 1;

    @Override
    public Result execCommand(String[] commands) {

        if (commands.length != NUMBER_OF_FIELDS) {
            System.out.println("Wrong number of fields");
            return null;
        }
        System.out.println("Overview Running");
        for (Wallet wallet : digitalWalletSystem.getWalletList().values()) {
            System.out.println(wallet.getName() + wallet.getTotalAmount());
        }

        return null;
    }


}
