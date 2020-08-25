package System;

import models.Wallet;

import java.util.HashMap;

public final class DigitalWalletSystem {
    private final double MIN_AMOUNT;
    private final HashMap<Integer, Wallet> walletList;

    public double getMIN_AMOUNT() {
        return MIN_AMOUNT;
    }

    public HashMap<Integer, Wallet> getWalletList() {
        return walletList;
    }

    public DigitalWalletSystem() {
        this.MIN_AMOUNT=0.00001;
        this.walletList=new HashMap<>();
    }


}
