package services;
import System.DigitalWalletSystem;
import models.Result;

public abstract class Commands {

    public abstract Result execCommand(String[] commands);
    public static int size=1;
    public DigitalWalletSystem digitalWalletSystem=new DigitalWalletSystem();

}
