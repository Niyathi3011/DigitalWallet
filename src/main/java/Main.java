import services.Commands;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = "Yes";
        while (s.matches("Yes")) {

            String command;
            System.out.println("Enter the command");
            command = sc.nextLine();
            String[] data = command.split(" ");
            Commands c = CommandFactory.getCommands(data[0]);
            if (c != null) {
                c.execCommand(data);
            }
            System.out.println("Yes/No");
            s = sc.nextLine();

        }
    }
}
