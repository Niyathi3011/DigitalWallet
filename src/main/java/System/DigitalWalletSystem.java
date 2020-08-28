package System;

import lombok.ToString;
import models.Transaction;
import models.Wallet;

import java.util.HashMap;
import java.util.Map;

@ToString
public class DigitalWalletSystem {

    public static final double MIN_AMOUNT = 0.0001;
    private final Map<String, Wallet> walletList;

    public DigitalWalletSystem() {
        this.walletList = new HashMap<>();
    }

    public Map<String, Wallet> getWalletList() {
        return walletList;
    }

    public void addTransaction(String name, Transaction transaction) {
        this.walletList.get(name).addTransaction(transaction);
    }

    public void createWallet(String name, int amount) {
        this.walletList.put(name, new Wallet(name, amount));

    }

    public boolean isAccountExists(String name) {
        if (this.getWalletList().containsKey(name))
            return true;
        return false;
    }

    public int getAmount(String name) {
        return this.getWalletList().get(name).getAmount();
    }
}
