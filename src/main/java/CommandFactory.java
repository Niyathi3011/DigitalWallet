import services.*;

public class CommandFactory {

    public static Commands getCommands(Command command) {
        switch (command) {
            case CreateWallet:
                return new CreateWallet();
            case Overview:
                return new Overview();
            case Statement:
                return new Statement();
            case TransferMoney:
                return new TransferMoney();
            case Offer:
                return new Offer();
        }
        return null;
    }

}
