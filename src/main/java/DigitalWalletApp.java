
import System.DigitalWalletSystem;
import services.Commands;

import java.util.Scanner;

public class DigitalWalletApp {

    DigitalWalletSystem digitalWalletSystem = new DigitalWalletSystem();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = "Yes";
        while (s.matches("Yes")) {

            String command;
            System.out.println("Enter the command");
            command = sc.nextLine();
            String[] commands = command.split(" ");
            Commands c = CommandFactory.getCommands(commands[0]);
            if (c != null) {
                System.out.println(c.excCommand().toString());
            }
            System.out.println("Yes/No");
            s = sc.nextLine();

        }

    }
}
