package services;

import models.Result;
import models.Wallet;

public class Overview extends Commands {


    @Override
    public Result execCommand(String[] commands) {

        for(Wallet wallet:digitalWalletSystem.getWalletList().values()){
            System.out.println(wallet.getName() + wallet.getTotalAmount());
        }

        return null;
    }
}
