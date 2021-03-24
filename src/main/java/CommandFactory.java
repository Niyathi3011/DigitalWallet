import System.DigitalWalletSystem;
import services.*;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private final DigitalWalletSystem digitalWalletSystem;
    private final Map<Command,Service> services;

    public CommandFactory(DigitalWalletSystem digitalWalletSystem) {
        this.digitalWalletSystem = digitalWalletSystem;
        services = new HashMap<>();
        services.put(Command.CREATE_WALLET,new CreateWallet(digitalWalletSystem));
        services.put(Command.OVERVIEW,new Overview(digitalWalletSystem));
        services.put(Command.STATEMENT,new Statement(digitalWalletSystem));
        services.put(Command.TRANSFER_MONEY,new TransferMoney(digitalWalletSystem));
    }

    public Service getCommands(Command command) {
        switch (command) {
            case CREATE_WALLET:
                return services.get(command);
            case OVERVIEW:
                 return services.get(command);
            case STATEMENT:
                return services.get(command);
            case TRANSFER_MONEY:
                return services.get(command);
        }
        return null;
    }

}
