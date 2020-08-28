package services;

import System.DigitalWalletSystem;

public abstract class Commands {

    public abstract void execCommand(String[] commands, DigitalWalletSystem digitalWalletSystem);

    public Commands() {
    }

}
