package fintech.driver;
import java.util.Scanner;

import fintech.model.Account;
import fintech.model.Transaction;
/**
 * @authonser NIM Nama
 * @authonser NIM Nama
 */
public class Driver2 {

    public static void main(String[] _args) {
        String owner;
        String name;
        Account account;
        Scanner scanner = new Scanner(System.in);
        while(true){
            if (!scanner.hasNextLine()) break;
            String command = scanner.nextLine();

            if (command.equalsIgnoreCase("create-account")) {
                if (!scanner.hasNextLine()) break;
                owner = scanner.nextLine();
                if (!scanner.hasNextLine()) break;
                name = scanner.nextLine();
                account = new Account(owner, name);
                System.out.println(account);
                System.out.println("Account created successfully.");
            } else if (command.equalsIgnoreCase("create-transaction")) {
                try {
                    if (!scanner.hasNextLine()) break;
                    owner = scanner.nextLine();
                    if (!scanner.hasNextLine()) break;
                    name = scanner.nextLine();
                    account = new Account(owner, name);
                    if (!scanner.hasNextLine()) break;
                    String amount = scanner.nextLine();
                    if (!scanner.hasNextLine()) break;
                    String postedAt = scanner.nextLine();
                    if (!scanner.hasNextLine()) break;
                    String note = scanner.nextLine();
                    Transaction transaction = new Transaction(account, Double.parseDouble(amount), postedAt, note);
                    System.out.println(transaction);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }                
            } else if (command.equalsIgnoreCase("delete-account")) {
                try {
                    if (!scanner.hasNextLine()) break;
                    owner = scanner.nextLine();
                    if (!scanner.hasNextLine()) break;
                    name = scanner.nextLine();
                    Account.deleteAccount(owner, name);
                    System.out.println("Account deleted successfully.");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (command.equalsIgnoreCase("show-all")) {
                try {
                    Account.showall();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            if (command.equalsIgnoreCase("exit")) {
                scanner.close();
                break;
            }
        }
        scanner.close();
    }
}