package System;

import models.Wallet;

import java.util.HashMap;

public class DigitalWalletSystem {

    private static final double MIN_AMOUNT = 0.0001;
    private final HashMap<String, Wallet> walletList;

    public DigitalWalletSystem() {
        this.walletList = new HashMap<>();
    }

    public HashMap<String, Wallet> getWalletList() {
        return walletList;
    }
}
