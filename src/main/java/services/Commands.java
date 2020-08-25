package services;
import System.DigitalWalletSystem;
import models.Result;

public abstract class Commands {

    public abstract Result execCommand(String[] commands);

    public DigitalWalletSystem digitalWalletSystem=new DigitalWalletSystem();


}
