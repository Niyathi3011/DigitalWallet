import services.Commands;
import System.DigitalWalletSystem;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DigitalWalletSystem digitalWalletSystem=new DigitalWalletSystem();
        Scanner sc = new Scanner(System.in);
        String s = "Yes";
        while (s.matches("Yes")) {

            String command;
            System.out.println("Enter the command");
            command = sc.nextLine();
            String[] commands = command.split(" ");
            Commands c = CommandFactory.getCommands(commands[0]);
            if (c != null) {
                System.out.println(c.execCommand(commands).toString());
            }
            System.out.println("Yes/No");
            s = sc.nextLine();

        }
}
