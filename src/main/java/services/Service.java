package services;

import System.DigitalWalletSystem;

public abstract class Service {

    private final DigitalWalletSystem digitalWalletSystem;

    protected Service(DigitalWalletSystem digitalWalletSystem) {
        this.digitalWalletSystem = digitalWalletSystem;
    }

    public abstract void executeCommand(String[] commandArgs);

    public DigitalWalletSystem getDigitalWalletSystem() {
        return digitalWalletSystem;
    }
}
