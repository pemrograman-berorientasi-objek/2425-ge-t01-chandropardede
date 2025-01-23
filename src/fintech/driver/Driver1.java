package fintech.driver;
import java.util.Scanner;

import fintech.model.Account;

/**
 * @author NIM Nama
 * @author NIM Nama
 */
public class Driver1 {

    public static void main(String[] _args) {

        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        String owner = scanner.nextLine();
        String name = scanner.nextLine();

        if (command.equalsIgnoreCase("create-account")) {
            Account account = new Account(owner, name);
            System.out.println(account);

        }

        scanner.close();
    }

}