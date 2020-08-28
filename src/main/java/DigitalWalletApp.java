import System.DigitalWalletSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.Service;

import java.util.Scanner;

public class DigitalWalletApp {

    private static final Logger logger = LoggerFactory.getLogger(DigitalWalletApp.class);


    public static void main(String[] args) {

        logger.info("Digital Wallet System is instantiated");
        DigitalWalletSystem digitalWalletSystem = new DigitalWalletSystem();
        CommandFactory commandFactory=new CommandFactory(digitalWalletSystem);
        Scanner sc = new Scanner(System.in);

        String s = "Yes";

        while (s.matches("Yes")) {

            String command;
            System.out.println("Enter the command");
            logger.info("Command is given");
            command = sc.nextLine();
            String[] data = command.split(" ");
            logger.info("Getting the instance of a particular Command");
            Service service = commandFactory.getCommands(Command.valueOf(data[0]));
            if (service != null) {
                service.executeCommand(data);

            }
            System.out.println("Yes/No");
            s = sc.nextLine();
            logger.info("Next Command is given");

        }
    }
}
