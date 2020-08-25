import services.*;

public class CommandFactory {

    public static Commands getCommands(String command) {
        switch (command) {
            case "CreateWallet":
                return new CreateWallet();
            case "Overview":
                return new Overview();
            case "Statement":
                return new Statement();
            case "TransferMoney":
                return new TransferMoney();
            case "Offer1":return new Offer1();
            case "Offer2":return new Offer2();
        }
        return null;
    }

}
